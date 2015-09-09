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
public class DepartamentoModelo extends Conexion{

    public DefaultTableModel getTablaDptos(){
      MiModelo tablamodelo = new MiModelo();
      int numregistros = 0;
      String[] NombreColumnas = {"Código","Departamento"};

      try{
         String sql = "SELECT count(*) as Total FROM Departamentos;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery();
         resultado.next();
         numregistros = resultado.getInt("Total");
         resultado.close();
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }

      Object[][] datos = new String[numregistros][2];
      try{
         String sql = "Select * from Departamentos;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery();
         int i = 0;
         while(resultado.next()){
            datos[i][0] = resultado.getString("Codi_Dpto");
            datos[i][1] = resultado.getString("Nomb_Dpto");
            i++;
         }
         resultado.close();

         tablamodelo.setDataVector(datos, NombreColumnas);
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablamodelo;
    }

    public boolean NuevoProducto(String codigo, String nombre){
        if(valida_datos(codigo, nombre)){

            String sql = "Insert into Departamentos "
                       +"values('"+codigo+"','"+nombre+"');";                       

            try {
                PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
                sentencia.execute();
                sentencia.close();
                return true;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "El Departamento ya existe!");
            }
            return false;
        }else
           return false;
    }

    public boolean EliminarDpto(String codigo){
        boolean bandera = false;

        String sql = "Delete from Departamentos where Codi_Dpto = '"+codigo+"';" ;

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

    private boolean valida_datos(String codigo, String nombre){
        if(nombre.length() > 0 && codigo.length() > 0){
            return true;
        }else 
            return false;
    }
}
