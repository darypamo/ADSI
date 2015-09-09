/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class FrmUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public FrmUsuarios() {
        initComponents();
        setLocationRelativeTo(this);
        this.jLblClave.setVisible(false);
        this.jLblRClave.setVisible(false);
        this.jTexClave.setVisible(false);
        this.jTexRClave.setVisible(false);
        this.jTexUsuario.setEnabled(false);
        this.jTexPrivilegios.setEnabled(false);
        this.jTexNombre.setEnabled(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTblUsuarios = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLblClave = new javax.swing.JLabel();
        jBtnAgregar = new javax.swing.JButton();
        jBtnVer = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnAdicionar = new javax.swing.JButton();
        jLblRClave = new javax.swing.JLabel();
        jTexClave = new javax.swing.JPasswordField();
        jTexRClave = new javax.swing.JPasswordField();
        jTexPrivilegios = new javax.swing.JTextField();
        jTexNombre = new javax.swing.JTextField();
        jTexUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CRUD Usuarios");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTblUsuarios);

        jLabel1.setText("Usuario:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Privilegios:");

        jLblClave.setText("Clave:");

        jBtnAgregar.setText("Agregar Usuarios");

        jBtnVer.setText("Ver Usuarios");
        jBtnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVerActionPerformed(evt);
            }
        });

        jBtnEliminar.setText("Eliminar Usuarios");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jBtnAdicionar.setText("Adicionar Usuarios");
        jBtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionarActionPerformed(evt);
            }
        });

        jLblRClave.setText("Confirmar Clave:");

        jTexClave.setText("jPasswordField1");
        jTexClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTexClaveFocusGained(evt);
            }
        });

        jTexRClave.setText("jPasswordField1");
        jTexRClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTexRClaveFocusGained(evt);
            }
        });

        jTexPrivilegios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTexPrivilegiosFocusLost(evt);
            }
        });
        jTexPrivilegios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTexPrivilegiosKeyTyped(evt);
            }
        });

        jTexNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTexNombreKeyTyped(evt);
            }
        });

        jTexUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTexUsuarioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLblRClave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTexUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTexPrivilegios, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLblClave))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTexClave, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                    .addComponent(jTexNombre)
                                    .addComponent(jTexRClave))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnVer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnEliminar)
                        .addGap(91, 91, 91))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtnAdicionar, jBtnAgregar, jBtnEliminar, jBtnVer});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTexNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTexUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTexClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTexPrivilegios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblRClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTexRClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnVer)
                    .addComponent(jBtnAgregar)
                    .addComponent(jBtnEliminar)
                    .addComponent(jBtnAdicionar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnVerActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnAdicionarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jTexPrivilegiosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTexPrivilegiosKeyTyped
        // TODO add your handling code here:
        int longitud = this.jTexPrivilegios.getText().length() + 1;
        
        char c = evt.getKeyChar();
 
        if (c == '1' || c == '0'){
        
        }else{
            JOptionPane.showMessageDialog(null,"Los privilegios deben ser solo 1 o 0 y son 10 privilegios!","Error",JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
        
        if (longitud > 10){
            JOptionPane.showMessageDialog(null,"Ya asignó todos los privilegios!","Error",JOptionPane.INFORMATION_MESSAGE);
            evt.consume();
        }                
    }//GEN-LAST:event_jTexPrivilegiosKeyTyped

    private void jTexNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTexNombreKeyTyped
        // TODO add your handling code here:
        int longitud = this.jTexNombre.getText().length() + 1;
        
        if(longitud > 60 || Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_jTexNombreKeyTyped

    private void jTexUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTexUsuarioKeyTyped
        // TODO add your handling code here:
        int longitud = this.jTexUsuario.getText().length() + 1;
        
        if(longitud > 45)
            evt.consume();
    }//GEN-LAST:event_jTexUsuarioKeyTyped

    private void jTexClaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTexClaveFocusGained

        this.jTexClave.setText("");
    }//GEN-LAST:event_jTexClaveFocusGained

    private void jTexRClaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTexRClaveFocusGained
        // TODO add your handling code here:
        this.jTexRClave.setText("");
    }//GEN-LAST:event_jTexRClaveFocusGained

    private void jTexPrivilegiosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTexPrivilegiosFocusLost

        int longitud = this.jTexPrivilegios.getText().length();
        
        if (longitud < 10){
            this.jTexPrivilegios.requestFocus();
        }
    }//GEN-LAST:event_jTexPrivilegiosFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmUsuarios().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnAdicionar;
    public javax.swing.JButton jBtnAgregar;
    public javax.swing.JButton jBtnEliminar;
    public javax.swing.JButton jBtnVer;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLblClave;
    public javax.swing.JLabel jLblRClave;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable jTblUsuarios;
    public javax.swing.JPasswordField jTexClave;
    public javax.swing.JTextField jTexNombre;
    public javax.swing.JTextField jTexPrivilegios;
    public javax.swing.JPasswordField jTexRClave;
    public javax.swing.JTextField jTexUsuario;
    // End of variables declaration//GEN-END:variables

}
