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
public class ProductoModelo extends Conexion{

    public DefaultTableModel getTablaProducto(){
      MiModelo tablamodelo = new MiModelo();
      int numregistros = 0;
      String[] NombreColumnas = {"Código","Nombre","Precio","Cantidad"};

      try{
         String sql = "SELECT count(*) as Total FROM Productos;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery();
         resultado.next();
         numregistros = resultado.getInt("Total");
         resultado.close();
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }

      Object[][] datos = new String[numregistros][4];
      try{
         String sql = "Select * from Productos;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery();
         int i = 0;
         while(resultado.next()){
            datos[i][0] = resultado.getString("Codi_Prod");
            datos[i][1] = resultado.getString("Nomb_Prod");
            datos[i][2] = resultado.getString("Precio");
            datos[i][3] = resultado.getString("Cantidad");
            i++;
         }
         resultado.close();

         tablamodelo.setDataVector(datos, NombreColumnas);
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablamodelo;
    }

    public boolean NuevoProducto(String codigo, String nombre, String precio, 
            String cantidad){
        if(valida_datos(codigo, nombre, precio, cantidad)){
            precio = precio.replace(",", ".");

            String sql = "Insert into Productos "
                       +"values('"+codigo+"','"+nombre+"','"+precio+"','"+cantidad+"');";                       

            try {
                PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
                sentencia.execute();
                sentencia.close();
                return true;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "El Producto ya existe!");
            }
            return false;
        }else
           return false;
    }

    public boolean EliminarProducto(String codigo){
        boolean bandera = false;

        String sql = "Delete from Productos where Codi_Prod = '"+codigo+"';" ;

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

    private boolean valida_datos(String codigo, String nombre , String precio,
            String cantidad){
        if(codigo.equals(" - "))
            return false;
        else if(nombre.length() > 0 && precio.length() > 0 && cantidad.length() 
                > 0){
            return true;
        }else 
            return false;
    }
}
