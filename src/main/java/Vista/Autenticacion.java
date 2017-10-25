/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GestorAutenticacion;
import Modelo.Admin;
import Modelo.Bedel;
import Modelo.Usuario;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author azuli
 */
public class Autenticacion extends javax.swing.JFrame {

    /**
     * Creates new form Autenticacion2
     */
    List uap = new ArrayList();
    
    public Autenticacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public Autenticacion(List uap){
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.uap=uap;
    }

    public void ingresoSistema(){
        
        GestorAutenticacion ga = new GestorAutenticacion(uap);
        Usuario us = ga.autenticarUsuario(user.getText(), pass);
        if (us instanceof Bedel){
            OpcionesDelBedel b = new OpcionesDelBedel((Bedel)us);
            this.dispose();
        }else{
            if (us instanceof Admin){
                this.dispose();
                OpcionesDelAdministrador ad= new OpcionesDelAdministrador((Admin)us);
            }else{
                Autenticacion esta=this;
                esta.setAlwaysOnTop(true);
                ErrorDeAutenticacion eda = new ErrorDeAutenticacion();
                esta.setEnabled(false);
                eda.addWindowListener(new WindowAdapter(){
                    public void windowClosed(WindowEvent e){
                        esta.setEnabled(true);
                        esta.user.requestFocus();
                    }
                });
            }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        ingresar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(55, 64, 70));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setFocusable(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(570, 322));
        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingreso al sistema");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");

        jSeparator1.setBackground(new java.awt.Color(240, 240, 240));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setToolTipText("");

        user.setBackground(new java.awt.Color(55, 64, 70));
        user.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        user.setForeground(new java.awt.Color(204, 204, 255));
        user.setText("Ingrese usuario");
        user.setToolTipText("");
        user.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userFocusLost(evt);
            }
        });
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        pass.setBackground(new java.awt.Color(55, 64, 70));
        pass.setForeground(new java.awt.Color(204, 204, 255));
        pass.setText("123456789");
        pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passFocusLost(evt);
            }
        });
        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMouseClicked(evt);
            }
        });
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passKeyPressed(evt);
            }
        });

        ingresar.setBackground(new java.awt.Color(0, 200, 83));
        ingresar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ingresar.setText("Ingresar");
        ingresar.setBorder(null);
        ingresar.setBorderPainted(false);
        ingresar.setFocusPainted(false);
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });
        ingresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ingresarKeyPressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(244, 67, 54));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton2.setText("Salir");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Para Bedel utilice Usuario: bedel | Contraseña: bedel");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Para Administrador utilice Usuario: admin | Contraseña: admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 248, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pass)
                            .addComponent(user)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        
    }//GEN-LAST:event_userActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        
    }//GEN-LAST:event_userMouseClicked

    private void passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseClicked
        
    }//GEN-LAST:event_passMouseClicked

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        ingresoSistema();
    }//GEN-LAST:event_ingresarActionPerformed

    private void userFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userFocusGained
        this.setAlwaysOnTop(false);
        if (user.getText().equals("Ingrese usuario"))
            user.setText(null);
    }//GEN-LAST:event_userFocusGained

    private void passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFocusGained
        String contra="";
        char a;
        for (int i=0; i<pass.getPassword().length; i++){
            a= pass.getPassword()[i];
            contra = contra + a;
        }
        if (contra.equals("123456789"))
            pass.setText(null);
    }//GEN-LAST:event_passFocusGained

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed

    }//GEN-LAST:event_passActionPerformed

    private void userFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userFocusLost
        if (user.getText().isEmpty())
            user.setText("Ingrese usuario");
    }//GEN-LAST:event_userFocusLost

    private void passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFocusLost
        if (pass.getPassword().length==0)
            pass.setText("123456789");
    }//GEN-LAST:event_passFocusLost

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained

    }//GEN-LAST:event_jPanel2FocusGained

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            ingresoSistema();
        }
    }//GEN-LAST:event_passKeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void ingresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ingresarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            ingresoSistema();
        }
    }//GEN-LAST:event_ingresarKeyPressed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ingresar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
