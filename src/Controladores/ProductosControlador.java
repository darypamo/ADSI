package Controladores;

import Modelos.ProductoModelo;
import Vistas.FrmProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
/**
 * @author Ricardo Palacio P.
 */
public class ProductosControlador implements ActionListener,MouseListener{

    FrmProductos vtnProductos ;
    ProductoModelo modelo = new ProductoModelo();

    public enum AccionMVC{
        __VER_PRODUCTOS,
        __AGREGAR_PRODUCTO,
        __ELIMINAR_PRODUCTO,
        __ADICIONAR_PRODUCTO
    }

    public ProductosControlador(FrmProductos vista){
        this.vtnProductos = vista;
    }

    public void iniciar(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows."
                    + "WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vtnProductos);
            vtnProductos.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(vtnProductos, "Error de driver de "
                      + "video: "+ex.getMessage());
          }
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}


        this.vtnProductos.jBtnVerP.setActionCommand("__VER_PRODUCTOS");
        this.vtnProductos.jBtnVerP.addActionListener(this);
        
        this.vtnProductos.jBtnAdicionarP.setActionCommand("__ADICIONAR_PRODUCTO");
        this.vtnProductos.jBtnAdicionarP.addActionListener(this);

        this.vtnProductos.jBtnAgragarP.setActionCommand("__AGREGAR_PRODUCTO");
        this.vtnProductos.jBtnAgragarP.addActionListener(this);

        this.vtnProductos.jBtnEliminarP.setActionCommand("__ELIMINAR_PRODUCTO");
        this.vtnProductos.jBtnEliminarP.addActionListener(this);

        this.vtnProductos.jTblProductos.addMouseListener(this);
        this.vtnProductos.jTblProductos.setModel(new DefaultTableModel());
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getButton()== 1)//boton izquierdo
        {
             int fila = this.vtnProductos.jTblProductos.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.vtnProductos.jFtIdProducto.setText(String.valueOf(
                        this.vtnProductos.jTblProductos.getValueAt(fila, 0)));
                this.vtnProductos.jFtNombe.setText(String.valueOf(
                        this.vtnProductos.jTblProductos.getValueAt(fila, 1)));
                this.vtnProductos.jFtPrecio.setText(String.valueOf(
                        this.vtnProductos.jTblProductos.getValueAt(fila, 2)));
                this.vtnProductos.jFtCantidad.setText(String.valueOf(
                        this.vtnProductos.jTblProductos.getValueAt(fila, 3)));
                this.vtnProductos.jFtIdProducto.setEditable(false);
                this.vtnProductos.jFtNombe.setEditable(false);
                this.vtnProductos.jFtPrecio.setEditable(false);
                this.vtnProductos.jFtCantidad.setEditable(false);                                            
             }
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) { }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand())){
            
                case __VER_PRODUCTOS:{
                    this.vtnProductos.jTblProductos.setModel(this.modelo.
                            getTablaProducto());
                    this.vtnProductos.jFtIdProducto.requestFocus();
                    break;
                }
                case __ADICIONAR_PRODUCTO:{
                    this.vtnProductos.jFtIdProducto.setEditable(true);
                    this.vtnProductos.jFtNombe.setEditable(true);
                    this.vtnProductos.jFtPrecio.setEditable(true);
                    this.vtnProductos.jFtCantidad.setEditable(true);
                    this.vtnProductos.jFtIdProducto.requestFocus();
                    this.vtnProductos.jFtIdProducto.setText("");
                    this.vtnProductos.jFtNombe.setText("");
                    this.vtnProductos.jFtPrecio.setText("");
                    this.vtnProductos.jFtCantidad.setText("");
                    break;
                }
                case __AGREGAR_PRODUCTO:{
                    if (this.modelo.NuevoProducto(
                            this.vtnProductos.jFtIdProducto.getText(),
                            this.vtnProductos.jFtNombe.getText() ,
                            this.vtnProductos.jFtPrecio.getText(),
                            this.vtnProductos.jFtCantidad.getText())){
                            this.vtnProductos.jTblProductos.setModel(this.modelo.
                                    getTablaProducto());
                            JOptionPane.showMessageDialog(vtnProductos,"Producto creado!.");
                            this.vtnProductos.jFtIdProducto.setText("");
                            this.vtnProductos.jFtNombe.setText("");
                            this.vtnProductos.jFtPrecio.setText("");
                            this.vtnProductos.jFtCantidad.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(vtnProductos,"Datos incorrectos!.");
                    break;
                }
                case __ELIMINAR_PRODUCTO:{
                    if (this.modelo.EliminarProducto(this.vtnProductos.jFtIdProducto.
                            getText())){
                        this.vtnProductos.jTblProductos.setModel(this.modelo.
                                getTablaProducto());
                        JOptionPane.showMessageDialog(vtnProductos,"Producto eliminado.");
                        this.vtnProductos.jFtIdProducto.setText("");
                        this.vtnProductos.jFtNombe.setText("") ;
                        this.vtnProductos.jFtPrecio.setText("");
                        this.vtnProductos.jFtCantidad.setText("") ;
                    }
                    break;       
                }
            }
        }
}
