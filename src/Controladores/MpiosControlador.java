package Controladores;

import Modelos.MpioModelo;
import Vistas.FrmMpios;
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
public class MpiosControlador implements ActionListener,MouseListener{

    FrmMpios ventana;
    MpioModelo modelo = new MpioModelo();

    public enum AccionMVC{
        __VER_,
        __AGREGAR_,
        __ELIMINAR_,
        __ADICIONAR_
    }

    public MpiosControlador(FrmMpios vista){
        this.ventana = vista;
        modelo.llenarComboDptos(this.ventana.jCmbDpto);
    }

    public void iniciar(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows."
                    + "WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(ventana);
            ventana.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(ventana, "Error de driver de "
                      + "video: "+ex.getMessage());
          }
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}


        this.ventana.jBtnVer.setActionCommand("__VER_");
        this.ventana.jBtnVer.addActionListener(this);
        
        this.ventana.jBtnAdicionar.setActionCommand("__ADICIONAR_");
        this.ventana.jBtnAdicionar.addActionListener(this);

        this.ventana.jBtnAgregar.setActionCommand("__AGREGAR_");
        this.ventana.jBtnAgregar.addActionListener(this);

        this.ventana.jBtnEliminar.setActionCommand("__ELIMINAR_");
        this.ventana.jBtnEliminar.addActionListener(this);

        this.ventana.jTabla.addMouseListener(this);
        this.ventana.jTabla.setModel(new DefaultTableModel());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()== 1)//boton izquierdo
        {
             int fila = this.ventana.jTabla.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.ventana.jTexCodigo.setText(String.valueOf(
                        this.ventana.jTabla.getValueAt(fila, 0)));
                this.ventana.jTexNombre.setText(String.valueOf(
                        this.ventana.jTabla.getValueAt(fila, 2)));
                this.ventana.jCmbDpto.removeAllItems();
                this.ventana.jCmbDpto.addItem(String.valueOf(
                        this.ventana.jTabla.getValueAt(fila, 1)));                
                this.ventana.jTexCodigo.setEditable(false);
                this.ventana.jTexNombre.setEditable(false); 
                this.ventana.jCmbDpto.setEnabled(false);
             }
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand())){
            
            case __VER_:{
                this.ventana.jTabla.setModel(this.modelo.
                        getTabla());
                this.ventana.jTexCodigo.requestFocus();
                break;
            }
            case __ADICIONAR_:{
                this.ventana.jTexCodigo.setEditable(true);
                this.ventana.jTexNombre.setEditable(true);
                this.ventana.jTexCodigo.requestFocus();
                this.ventana.jTexCodigo.setText("");
                this.ventana.jTexNombre.setText("");
                this.modelo.llenarComboDptos(this.ventana.jCmbDpto);
                this.ventana.jCmbDpto.setEnabled(true);
                break;
            }
            case __AGREGAR_:{
                String ver = this.modelo.hallarCodiDpto(this.ventana.jCmbDpto.getSelectedItem().toString());
                if (this.modelo.Nuevo(
                        this.ventana.jTexCodigo.getText(),
                        ver,
                        this.ventana.jTexNombre.getText())){
                        this.ventana.jTabla.setModel(this.modelo.getTabla());
                        JOptionPane.showMessageDialog(ventana,"Ciudad creada!.");
                        this.ventana.jTexCodigo.setText("");
                        this.ventana.jTexNombre.setText("");
                        this.ventana.jTexCodigo.requestFocus();
                }
                else
                    JOptionPane.showMessageDialog(ventana,"Datos incorrectos!.");
                break;
            }
            case __ELIMINAR_:{
                if (this.modelo.Eliminar(this.ventana.jTexCodigo.getText())){
                    this.ventana.jTabla.setModel(this.modelo.getTabla());
                    JOptionPane.showMessageDialog(ventana,"Ciudad eliminada!.");
                    this.ventana.jTexCodigo.setText("");
                    this.ventana.jTexNombre.setText("") ;
                }
                break;       
            }
        }
    }
}
