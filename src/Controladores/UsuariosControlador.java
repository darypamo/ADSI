package Controladores;

import Modelos.UsuarioModelo;
import Vistas.FrmUsuarios;
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
public class UsuariosControlador implements ActionListener,MouseListener{

    FrmUsuarios vtnUsuarios ;
    UsuarioModelo modelo = new UsuarioModelo();

    public enum AccionMVC{
        __VER_USUARIO,
        __AGREGAR_USUARIO,
        __ELIMINAR_USUARIO,
        __ADICIONAR_USUARIO
    }

    public UsuariosControlador(FrmUsuarios vista){
        this.vtnUsuarios = vista;
    }

    public void iniciar(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows."
                    + "WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vtnUsuarios);
            vtnUsuarios.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(vtnUsuarios, "Error de driver de "
                      + "video: "+ex.getMessage());
          }
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}


        this.vtnUsuarios.jBtnVer.setActionCommand("__VER_USUARIO");
        this.vtnUsuarios.jBtnVer.addActionListener(this);
        
        this.vtnUsuarios.jBtnAdicionar.setActionCommand("__ADICIONAR_USUARIO");
        this.vtnUsuarios.jBtnAdicionar.addActionListener(this);

        this.vtnUsuarios.jBtnAgregar.setActionCommand("__AGREGAR_USUARIO");
        this.vtnUsuarios.jBtnAgregar.addActionListener(this);

        this.vtnUsuarios.jBtnEliminar.setActionCommand("__ELIMINAR_USUARIO");
        this.vtnUsuarios.jBtnEliminar.addActionListener(this);

        this.vtnUsuarios.jTblUsuarios.addMouseListener(this);
        this.vtnUsuarios.jTblUsuarios.setModel(new DefaultTableModel());
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == 1)//boton izquierdo
        {
             int fila = this.vtnUsuarios.jTblUsuarios.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.vtnUsuarios.jTexUsuario.setText(String.valueOf(
                        this.vtnUsuarios.jTblUsuarios.getValueAt(fila, 0)));
                this.vtnUsuarios.jTexNombre.setText(String.valueOf(
                        this.vtnUsuarios.jTblUsuarios.getValueAt(fila, 1)));
                this.vtnUsuarios.jTexPrivilegios.setText(String.valueOf(
                        this.vtnUsuarios.jTblUsuarios.getValueAt(fila, 2)));
                this.vtnUsuarios.jTexUsuario.setEditable(false);
                this.vtnUsuarios.jTexNombre.setEditable(false);
                this.vtnUsuarios.jTexPrivilegios.setEditable(false);    
                this.vtnUsuarios.jTexClave.setVisible(false);
                this.vtnUsuarios.jTexRClave.setVisible(false);
                this.vtnUsuarios.jLblClave.setVisible(false);
                this.vtnUsuarios.jLblRClave.setVisible(false);                
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
            
                case __VER_USUARIO:{
                    this.vtnUsuarios.jTblUsuarios.setModel(this.modelo.getTablaUsuario());
                    this.vtnUsuarios.jTexClave.setVisible(false);
                    this.vtnUsuarios.jTexRClave.setVisible(false);
                    this.vtnUsuarios.jLblClave.setVisible(false);
                    this.vtnUsuarios.jLblRClave.setVisible(false);                    
                    break;
                }
                case __ADICIONAR_USUARIO:{
                    this.vtnUsuarios.jTexUsuario.setEditable(true);
                    this.vtnUsuarios.jTexNombre.setEditable(true);
                    this.vtnUsuarios.jTexPrivilegios.setEditable(true);
                    this.vtnUsuarios.jTexClave.setVisible(true);
                    this.vtnUsuarios.jTexRClave.setVisible(true);
                    this.vtnUsuarios.jLblClave.setVisible(true);
                    this.vtnUsuarios.jLblRClave.setVisible(true);
                    this.vtnUsuarios.jTexUsuario.requestFocus();
                    this.vtnUsuarios.jTexUsuario.setText("");
                    this.vtnUsuarios.jTexNombre.setText("");
                    this.vtnUsuarios.jTexPrivilegios.setText("");
                    this.vtnUsuarios.jTexUsuario.setEnabled(true);
                    this.vtnUsuarios.jTexPrivilegios.setEnabled(true);
                    this.vtnUsuarios.jTexNombre.setEnabled(true);                    
                    break;
                }
                case __AGREGAR_USUARIO:{
                    boolean sonIguales = false;
                    sonIguales = clavesIguales(leerClave(this.vtnUsuarios.jTexClave.getPassword()), 
                            leerClave(this.vtnUsuarios.jTexRClave.getPassword()));
                    if(sonIguales){
                        if (this.modelo.NuevoUsuario(
                                this.vtnUsuarios.jTexUsuario.getText(),
                                leerClave(this.vtnUsuarios.jTexClave.getPassword()),
                                this.vtnUsuarios.jTexNombre.getText() ,
                                this.vtnUsuarios.jTexPrivilegios.getText())){
                                this.vtnUsuarios.jTblUsuarios.setModel(this.modelo.getTablaUsuario());
                                JOptionPane.showMessageDialog(vtnUsuarios,"Usuario creado!.");
                                this.vtnUsuarios.jTexUsuario.setText("");
                                this.vtnUsuarios.jTexNombre.setText("");
                                this.vtnUsuarios.jTexPrivilegios.setText("");
                                this.vtnUsuarios.jTexClave.setVisible(false);
                                this.vtnUsuarios.jTexRClave.setVisible(false);
                                this.vtnUsuarios.jLblClave.setVisible(false);
                                this.vtnUsuarios.jLblRClave.setVisible(false);
                                this.vtnUsuarios.jTexUsuario.setEnabled(false);
                                this.vtnUsuarios.jTexPrivilegios.setEnabled(false);
                                this.vtnUsuarios.jTexNombre.setEnabled(false);                                 
                        }
                        else
                            JOptionPane.showMessageDialog(vtnUsuarios,"Datos incorrectos!.");
                    }else{
                        JOptionPane.showMessageDialog(vtnUsuarios, "las claves no son iguales!");
                        this.vtnUsuarios.jTexClave.requestFocus();
                    }
                    break;
                }
                case __ELIMINAR_USUARIO:{
                    if (this.modelo.EliminarUsuario(this.vtnUsuarios.jTexUsuario.
                            getText())){
                        this.vtnUsuarios.jTblUsuarios.setModel(this.modelo.
                                getTablaUsuario());
                        JOptionPane.showMessageDialog(vtnUsuarios,"Usuario eliminado.");
                        this.vtnUsuarios.jTexUsuario.setText("");
                        this.vtnUsuarios.jTexNombre.setText("");
                        this.vtnUsuarios.jTexPrivilegios.setText("");
                        this.vtnUsuarios.jTexClave.setVisible(false);
                        this.vtnUsuarios.jTexRClave.setVisible(false);
                        this.vtnUsuarios.jLblClave.setVisible(false);
                        this.vtnUsuarios.jLblRClave.setVisible(false);                        
                        this.vtnUsuarios.jTexUsuario.setEnabled(false);
                        this.vtnUsuarios.jTexPrivilegios.setEnabled(false);
                        this.vtnUsuarios.jTexNombre.setEnabled(false);  
                    }
                    break;       
                }
            }
    }
    
    private String leerClave(char[] pass){
        String clave = "";
        //char[] pass = this.vtnUsuarios.jTexClave.getPassword();
        
        for (int i = 0; i < pass.length; i++) {
            clave += pass[i];            
        }
        
        return clave;
    }
    
    private boolean clavesIguales(String p1, String p2){
        if(p1.equals(p2))
           return true;
        else
           return false;
    }
}
