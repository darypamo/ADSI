package Controladores;

import Modelos.DepartamentoModelo;
import Vistas.FrmDepartamentos;
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
public class DepartamentosControlador implements ActionListener,MouseListener{

    FrmDepartamentos vtnDpto;
    DepartamentoModelo modelo = new DepartamentoModelo();

    public enum AccionMVC{
        __VER_DPTO,
        __AGREGAR_DPTO,
        __ELIMINAR_DPTO,
        __ADICIONAR_DPTO
    }

    public DepartamentosControlador(FrmDepartamentos vista){
        this.vtnDpto = vista;
    }

    public void iniciar(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows."
                    + "WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vtnDpto);
            vtnDpto.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(vtnDpto, "Error de driver de "
                      + "video: "+ex.getMessage());
          }
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}


        this.vtnDpto.jBtnVer.setActionCommand("__VER_DPTO");
        this.vtnDpto.jBtnVer.addActionListener(this);
        
        this.vtnDpto.jBtnAdicionar.setActionCommand("__ADICIONAR_DPTO");
        this.vtnDpto.jBtnAdicionar.addActionListener(this);

        this.vtnDpto.jBtnAgregar.setActionCommand("__AGREGAR_DPTO");
        this.vtnDpto.jBtnAgregar.addActionListener(this);

        this.vtnDpto.jBtnEliminar.setActionCommand("__ELIMINAR_DPTO");
        this.vtnDpto.jBtnEliminar.addActionListener(this);

        this.vtnDpto.jTblDptos.addMouseListener(this);
        this.vtnDpto.jTblDptos.setModel(new DefaultTableModel());
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getButton()== 1)//boton izquierdo
        {
             int fila = this.vtnDpto.jTblDptos.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.vtnDpto.jTexCodigo.setText(String.valueOf(
                        this.vtnDpto.jTblDptos.getValueAt(fila, 0)));
                this.vtnDpto.jTexNombre.setText(String.valueOf(
                        this.vtnDpto.jTblDptos.getValueAt(fila, 1)));
                this.vtnDpto.jTexCodigo.setEditable(false);
                this.vtnDpto.jTexNombre.setEditable(false);
                                           
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
            
                case __VER_DPTO:{
                    this.vtnDpto.jTblDptos.setModel(this.modelo.
                            getTablaDptos());
                    this.vtnDpto.jTexCodigo.requestFocus();
                    break;
                }
                case __ADICIONAR_DPTO:{
                    this.vtnDpto.jTexCodigo.setEditable(true);
                    this.vtnDpto.jTexNombre.setEditable(true);
                    this.vtnDpto.jTexCodigo.requestFocus();
                    this.vtnDpto.jTexCodigo.setText("");
                    this.vtnDpto.jTexNombre.setText("");
                     break;
                }
                case __AGREGAR_DPTO:{
                    if (this.modelo.NuevoProducto(
                            this.vtnDpto.jTexCodigo.getText(),
                            this.vtnDpto.jTexNombre.getText())){
                            this.vtnDpto.jTblDptos.setModel(this.modelo.
                                    getTablaDptos());
                            JOptionPane.showMessageDialog(vtnDpto,"Departamento creado!.");
                            this.vtnDpto.jTexCodigo.setText("");
                            this.vtnDpto.jTexNombre.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(vtnDpto,"Datos incorrectos!.");
                    break;
                }
                case __ELIMINAR_DPTO:{
                    if (this.modelo.EliminarDpto(this.vtnDpto.jTexCodigo.
                            getText())){
                        this.vtnDpto.jTblDptos.setModel(this.modelo.
                                getTablaDptos());
                        JOptionPane.showMessageDialog(vtnDpto,"Departamento eliminado.");
                        this.vtnDpto.jTexCodigo.setText("");
                        this.vtnDpto.jTexNombre.setText("") ;
                    }
                    break;       
                }
            }
        }
}
