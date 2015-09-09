package Modelos;

import Controladores.MiModelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Conexion;

/**
 * @author Ricardo Palacio P.
 */
public class UsuarioModelo extends Conexion{

    public DefaultTableModel getTablaUsuario(){
      MiModelo tablamodelo = new MiModelo();
      int numregistros = 0;
      String[] NombreColumnas = {"Usuario","Nombre","Privilegios"};

      try{
         String sql = "SELECT count(*) as Total FROM Usuarios;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery();
         resultado.next();
         numregistros = resultado.getInt("Total");
         resultado.close();
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }

      Object[][] datos = new String[numregistros][3];
      try{
         String sql = "Select Usuario, Nomb_Usua, Privilegios from Usuarios;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery();
         int i = 0;
         while(resultado.next()){
            datos[i][0] = resultado.getString("Usuario");
            datos[i][1] = resultado.getString("Nomb_Usua");
            datos[i][2] = resultado.getString("Privilegios");            
            i++;
         }
         resultado.close();

         tablamodelo.setDataVector(datos, NombreColumnas);
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablamodelo;
    }

    public boolean NuevoUsuario(String usuario, String clave, String nombre, String privilegios){
        if(valida_datos(usuario, clave, nombre, privilegios)){            

            String sql = "Insert into Usuarios "
                       +"values('"+usuario+"',SHA1('"+clave+"'),'"+nombre+"','"+privilegios+"');";                       

            try {
                PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
                sentencia.execute();
                sentencia.close();
                return true;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "El Usuario ya existe!");
            }
            return false;
        }else
           return false;
    }

    public boolean EliminarUsuario(String usuario){
        boolean bandera = false;

        String sql = "Delete from Usuarios where usuario = '"+usuario+"';";

         try {
            PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
            sentencia.execute();
            sentencia.close();
            bandera = true;
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
        return bandera;
    }

    private boolean valida_datos(String usuario, String clave, String nombre , String privilegios){
        if(nombre.length() > 0 && privilegios.length() > 0 && clave.length()> 0 && usuario.length() > 0){
            return true;
        }else 
            return false;
    }
}
