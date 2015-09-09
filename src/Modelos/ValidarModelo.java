package Modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.Conexion;

/**
 * @author Ricardo Palacio P.
 */
public class ValidarModelo extends Conexion{

    public boolean validaEntrada(String usuario, String clave){
      boolean bandera = false;
      
      if(valida_datos(usuario, clave)){
        try{
            String sql = "Select * from usuarios "
                    + "where Usuario = '"+usuario+"' and clave = SHA1('"+clave+"');";
            PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            int i = 0;
            while(resultado.next()){
                Nuevo(usuario);
                bandera = true;
            }
          }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
        }
      }else{
          JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios!");
      }
        return bandera;
    }


    private boolean valida_datos(String usuario, String clave){
        if(usuario.length() > 0 && clave.length() > 0){
            return true;
        }else 
            return false;
    }

    
    public boolean Nuevo(String usuario){
        String sql = "Insert into UltimoIngreso "
                    +"values('"+usuario+"',now(),"+null+",'1');";                       
        try {                            
            PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
            sentencia.execute();                
            sentencia.close();
            return true;
        }catch(SQLException e){                
        }
        return false;
    }
}
