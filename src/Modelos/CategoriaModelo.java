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
public class CategoriaModelo extends Conexion{

    public DefaultTableModel getTabla(){
      MiModelo tablamodelo = new MiModelo();
      int numregistros = 0;
      String[] NombreColumnas = {"Código","Nombre","Descripción"};

      try{
         String sql = "SELECT count(*) as Total FROM Categorias;";
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
         String sql = "Select * from Categorias;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery();
         int i = 0;
         while(resultado.next()){
            datos[i][0] = resultado.getString("Codi_Cate");
            datos[i][1] = resultado.getString("Nomb_Cate");
            datos[i][2] = resultado.getString("Descripcion");
            i++;
         }
         resultado.close();

         tablamodelo.setDataVector(datos, NombreColumnas);
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablamodelo;
    }

    public boolean Nuevo(String codigo, String nombre, String descripcion){
        if(valida_datos(codigo, nombre, descripcion)){

            String sql = "Insert into Categorias "
                       +"values('"+codigo+"','"+nombre+"','"+descripcion+"');"; 
            JOptionPane.showMessageDialog(null, sql);
            try {
                PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
                sentencia.execute();
                sentencia.close();
                return true;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "La Categoría ya existe!");
                return false;
            }
        }else
           return false;
    }

    public boolean Eliminar(String codigo){
        boolean bandera = false;

        String sql = "Delete from Categorias where Codi_Cate = '"+codigo+"';" ;

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

    private boolean valida_datos(String codigo, String nombre, String descripcion){
        if(nombre.length() > 0 && codigo.length() > 0 && descripcion.length() > 0){
            return true;
        }else 
            return false;
    }
}
