/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GestorDeBedel;
import Modelo.Admin;
import Modelo.Bedel;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author azuli
 */
public class BuscarBedel extends javax.swing.JFrame {

    /**
     * Creates new form BuscarBedel
     */
    Admin adm;
    List<Bedel> bedeles;
    GestorDeBedel gdb;
    
    public BuscarBedel(Admin adm) {
        this.adm=adm;
        this.gdb = new GestorDeBedel();
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icono.png")).getImage());
        this.apellidotf.setEnabled(false);
        this.turnodesp.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void realizarBusqueda(){
        DefaultTableModel dtm = (DefaultTableModel) this.tabla.getModel();
        dtm.setRowCount(0);
        String apellido = null, turno = null;
        if (this.apellidotf.isEnabled() && this.turnodesp.isEnabled()){
            if (!this.apellidotf.getText().isEmpty()){
                apellido = this.apellidotf.getText();
                turno = this.turnodesp.getSelectedItem().toString();
            }
        }else{
            if ((this.apellidotf.isEnabled() && !this.apellidotf.getText().isEmpty()) && !this.turnodesp.isEnabled()){
                apellido = this.apellidotf.getText();
            }else{
                if (!this.apellidotf.isEnabled() && this.turnodesp.isEnabled()){
                        turno = this.turnodesp.getSelectedItem().toString();
                }else{
                    dtm.setRowCount(0);
                    this.modificar.setEnabled(false);
                    this.eliminar.setEnabled(false);
                    return ;
                }
            }
        }
        
        try{
            this.bedeles = gdb.buscarBedel(apellido, turno);
            if (!(this.bedeles == null)){
                for (int i=0; i<this.bedeles.size(); i++){
                        String datos[] = new String[4];
                        datos[0] = this.bedeles.get(i).getUserId().toString();
                        datos[1] = gdb.revertMayus(this.bedeles.get(i).getUsuario().getNombre());
                        datos[2] = gdb.revertMayus(this.bedeles.get(i).getUsuario().getApellido());
                        datos[3] = this.bedeles.get(i).getTurno();
                        dtm.addRow(datos);
                }
            }
        }catch (java.lang.NullPointerException e){
            dtm.setRowCount(0);
            this.modificar.setEnabled(false);
            this.eliminar.setEnabled(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        apellidotf = new javax.swing.JTextField();
        lastcb = new javax.swing.JCheckBox();
        turnocb = new javax.swing.JCheckBox();
        turnodesp = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        jDialog1.setTitle("dfhgfddh");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Buscar por:");

        buscar.setBackground(new java.awt.Color(204, 204, 204));
        buscar.setFont(new java.awt.Font("Coco Gothic", 1, 14)); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jLabel4.setText("Buscar bedel");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        eliminar.setBackground(new java.awt.Color(204, 204, 204));
        eliminar.setFont(new java.awt.Font("Coco Gothic", 1, 14)); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.setEnabled(false);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        modificar.setBackground(new java.awt.Color(204, 204, 204));
        modificar.setFont(new java.awt.Font("Coco Gothic", 1, 14)); // NOI18N
        modificar.setText("Modificar");
        modificar.setEnabled(false);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(55, 64, 70));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back-left-arrow-circular-button-outline.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.setFocusable(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(55, 64, 70));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diminish.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(55, 64, 70));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/closed.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);
        jButton4.setFocusable(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        apellidotf.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        apellidotf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                apellidotfFocusLost(evt);
            }
        });
        apellidotf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apellidotfKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidotfKeyTyped(evt);
            }
        });

        lastcb.setBackground(new java.awt.Color(153, 153, 153));
        lastcb.setText("Apellido");
        lastcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastcbActionPerformed(evt);
            }
        });

        turnocb.setBackground(new java.awt.Color(153, 153, 153));
        turnocb.setText("Turno");
        turnocb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnocbActionPerformed(evt);
            }
        });

        turnodesp.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        turnodesp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mañana", "Tarde", "Noche" }));

        tabla.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Turno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablaKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastcb)
                                    .addComponent(turnocb))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(apellidotf)
                                    .addComponent(turnodesp, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(192, 192, 192)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 125, Short.MAX_VALUE)
                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(apellidotf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lastcb))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(turnocb))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(turnodesp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscar)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(modificar)
                    .addComponent(eliminar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        if(lastcb.isSelected()){
            if(!apellidotf.getText().equals("")){
                realizarBusqueda(); 
            }else{
                ErrorApellBusq eab = new ErrorApellBusq();
                eab.setVisible(true); 
            }
        }else{
            if(turnocb.isSelected()){
                realizarBusqueda(); 
            }else{
                ErrorSelecBusq esb = new ErrorSelecBusq();
                esb.setVisible(true);
            }
        }

    }//GEN-LAST:event_buscarActionPerformed
   
    
    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        this.dispose();
        ModificarBedel mb = new ModificarBedel(adm, this.bedeles.get(this.tabla.getSelectedRow()));
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        
    }//GEN-LAST:event_eliminarActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
        jButton5.setContentAreaFilled(true);
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        // TODO add your handling code here:
        jButton5.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
        OpcionesDelAdministrador opc = new OpcionesDelAdministrador(adm);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setContentAreaFilled(true);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jButton4.setContentAreaFilled(true);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
        jButton4.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void lastcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastcbActionPerformed
        if (this.lastcb.isSelected()){
            this.apellidotf.setEnabled(true);
        }else{
            if (this.apellidotf.isEnabled()){
                this.apellidotf.setEnabled(false);
                this.apellidotf.setText(null);
            }
        }
    }//GEN-LAST:event_lastcbActionPerformed

    private void turnocbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnocbActionPerformed
        if (this.turnocb.isSelected()){
            this.turnodesp.setEnabled(true);
        }else{
            if (this.turnodesp.isEnabled()){
                this.turnodesp.setEnabled(false);
                this.turnodesp.setSelectedItem("Mañana");
            }
        }
    }//GEN-LAST:event_turnocbActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        try{
            this.bedeles.get(this.tabla.getSelectedRow()).getUserId();
        }catch(Exception e){
            this.modificar.setEnabled(false);
            this.eliminar.setEnabled(false);
            return ;
        }
        this.modificar.setEnabled(true);
        this.eliminar.setEnabled(true);
    }//GEN-LAST:event_tablaMouseClicked

    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) && this.modificar.isEnabled()){
            try{
                this.bedeles.get(this.tabla.getSelectedRow());
            }catch(Exception e){
                this.modificar.setEnabled(false);
                this.eliminar.setEnabled(false);
                return ;
            }
            this.modificar.requestFocus();
            this.modificar.doClick();
        }else{
            try{
                this.bedeles.get(this.tabla.getSelectedRow()).getUserId();
            }catch(java.lang.IndexOutOfBoundsException e){
                this.modificar.setEnabled(false);
                this.eliminar.setEnabled(false);
                return ;
            }
            this.modificar.setEnabled(true);
            this.eliminar.setEnabled(true);
        }
    }//GEN-LAST:event_tablaKeyPressed

    private void tablaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyTyped

    }//GEN-LAST:event_tablaKeyTyped

    private void tablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyReleased
        try{
            this.bedeles.get(this.tabla.getSelectedRow()).getUserId();
        }catch(java.lang.IndexOutOfBoundsException e){
            this.modificar.setEnabled(false);
            this.eliminar.setEnabled(false);
            return ;
        }
        this.modificar.setEnabled(true);
        this.eliminar.setEnabled(true);
    }//GEN-LAST:event_tablaKeyReleased

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscar.doClick();
        }
    }//GEN-LAST:event_buscarKeyPressed

    private void apellidotfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidotfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscar.requestFocus();
            this.buscar.doClick();
        }
    }//GEN-LAST:event_apellidotfKeyPressed

    private void apellidotfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidotfKeyTyped
        if (!((evt.getKeyChar()>=KeyEvent.VK_A && evt.getKeyChar()<=KeyEvent.VK_Z) || (evt.getKeyChar()>=97 && evt.getKeyChar()<=122) || (evt.getKeyChar() == KeyEvent.VK_SPACE) || gdb.isEnieOAcento(evt)) || this.apellidotf.getText().length()>19)
            evt.consume();
    }//GEN-LAST:event_apellidotfKeyTyped

    private void apellidotfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidotfFocusLost
        this.apellidotf.setText(gdb.ignoreSpaces(this.apellidotf.getText()));
    }//GEN-LAST:event_apellidotfFocusLost

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidotf;
    private javax.swing.JButton buscar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JCheckBox lastcb;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JButton modificar;
    private javax.swing.JTable tabla;
    private javax.swing.JCheckBox turnocb;
    private javax.swing.JComboBox<String> turnodesp;
    // End of variables declaration//GEN-END:variables
}
