package Controladores;

import Modelos.ValidarModelo;
import Vistas.FrmValidar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 * @author Ricardo Palacio P.
 */
public class ValidarControlador implements ActionListener,MouseListener{
    ValidarModelo modelo = new ValidarModelo();
    FrmValidar ventana;

    public enum AccionMVC{
        __INGRESAR_
    }

    public ValidarControlador(FrmValidar vista){
        this.ventana = vista;
    }

    public void iniciar(){
//        try{
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            SwingUtilities.updateComponentTreeUI(ventana);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
//        } catch (UnsupportedLookAndFeelException ex) {}
//          catch (ClassNotFoundException ex) {
//              JOptionPane.showMessageDialog(ventana, "Error de driver de "
//                      + "video: "+ex.getMessage());
//          }
//          catch (InstantiationException ex) {}
//          catch (IllegalAccessException ex) {}

        this.ventana.jBtnIngresar.setActionCommand("__INGRESAR_");
        this.ventana.jBtnIngresar.addActionListener(this); 
    }

    @Override
    public void mouseClicked(MouseEvent e) {}        
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand())){
            
            case __INGRESAR_:{
                if(this.modelo.validaEntrada(this.ventana.jTexUsuario.getText(), leerClave())){
                    this.ventana.dispose();
                }else{                    
                    JOptionPane.showMessageDialog(ventana, "Usuario o clave incorrectos!!");
                    this.ventana.jTexUsuario.requestFocus();
                    this.ventana.jTexUsuario.selectAll();
                }
                break;
            }      
        }
    }    
    
    private String leerClave(){
        String pass = "";
        char[] clave = this.ventana.jTexClave.getPassword();
        
        for (int i = 0; i < clave.length; i++) {
            pass += clave[i];            
        }
                
        return pass;
    }
}
