package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * @author Ricardo Palacio P.
 */

public class Conexion {

  private String db = "Tienda";
  private String user = "root";
  private String clave = "";
  private String url = "jdbc:mysql://localhost/"+db;
  private String driver = "com.mysql.jdbc.Driver";
  private Connection conexion = null;

   public Conexion(){
      try{
         Class.forName(driver);
         conexion = DriverManager.getConnection(url, user , clave);         
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Error de SQL: "+e.getMessage());
      }catch(ClassNotFoundException e){
         JOptionPane.showMessageDialog(null, "Error con el driver: "+e.getMessage());
      }
   }

   public Connection getConexion(){
      return this.conexion;
   }
}