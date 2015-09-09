package Modelos;

import Controladores.MiModelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Conexion;

/**
 * @author Ricardo Palacio P.
 */
public class MpioModelo extends Conexion{

    public DefaultTableModel getTabla(){
      MiModelo tablamodelo = new MiModelo();
      int numregistros = 0;
      String[] NombreColumnas = {"Código","Departamento","Ciudad"};

      try{
         String sql = "SELECT count(*) as Total FROM Ciudades;";
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
         String sql = "Select C.Codi_Mpio, D.Nomb_Dpto as Dpto, C.Nomb_Mpio from Ciudades C, Departamentos D "
                 + "where C.Depto = D.Codi_Dpto;";
         PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery();
         int i = 0;
         while(resultado.next()){
            datos[i][0] = resultado.getString("Codi_Mpio");
            datos[i][1] = resultado.getString("Dpto");
            datos[i][2] = resultado.getString("Nomb_Mpio");
            i++;
         }
         resultado.close();

         tablamodelo.setDataVector(datos, NombreColumnas);
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tablamodelo;
    }

    public boolean Nuevo(String codigo, String dpto, String nombre){
        if(valida_datos(codigo, dpto, nombre)){

            String sql = "Insert into Ciudades "
                       +"values('"+codigo+"','"+dpto+"','"+nombre+"');";                       

            try {
                PreparedStatement sentencia = this.getConexion().prepareStatement(sql);
                sentencia.execute();
                sentencia.close();
                return true;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "La Ciudad ya existe!");
            }
            return false;
        }else
           return false;
    }

    public boolean Eliminar(String codigo){
        boolean bandera = false;

        String sql = "Delete from Ciudades where Codi_Mpio = '"+codigo+"';" ;

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

    private boolean valida_datos(String codigo, String dpto, String nombre){
        if(nombre.length() > 0 && codigo.length() > 0 && dpto.length() > 0){
            return true;
        }else 
            return false;
    }
    
    public void llenarComboDptos(JComboBox jCmb){
        String sql = "Select * from Departamentos;";
        
        try {
            PreparedStatement sentencia = this.getConexion().prepareStatement(sql);                            
            ResultSet resultado = sentencia.executeQuery(sql);           

            while (resultado.next()) {                    
                jCmb.addItem(resultado.getString("Nomb_Dpto"));
            }
            sentencia.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL: "+ex.getMessage());
        }        
    }    
    
    public String hallarCodiDpto(String dpto){
        String sql = "select Codi_Dpto from departamentos where Nomb_Dpto = '"+dpto+"';";
        String codigo = "";
        
        try {
            PreparedStatement sentencia = this.getConexion().prepareStatement(sql);            
            ResultSet resultado = sentencia.executeQuery(sql);
            
            while(resultado.next()){
                codigo = resultado.getString("Codi_Dpto");
            }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error SQL: "+ex.getMessage());
            }
        return codigo;
    }
}
