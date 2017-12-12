/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GestorDeReserva;
import Modelo.Actividad;
import Modelo.Aula;
import Modelo.Bedel;
import Modelo.Docente;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author azuli
 */
public class AulasDisponibles extends javax.swing.JFrame {
    
    Actividad act;
    Bedel b;
    Docente doc;
    int cantAlumnos;
    List<Aula> aulas;
    GestorDeReserva gdr;
    int listsize;
    Vector fechas;
    List<Integer> contador;
    
    public AulasDisponibles(Vector fechas, List<Aula> aulas, GestorDeReserva gdr, List<Integer> contador, int listsize, Bedel b, Actividad act, Docente doc, int cantAlumnos) {
        initComponents();
        this.aulas = aulas;
        this.cantAlumnos = cantAlumnos;
        this.b = b;
        this.act = act;
        this.doc = doc;
        this.listsize=listsize;
        this.gdr = gdr;
        this.fechas = fechas;
        this.contador = contador;
        this.fecha.setText(fechas.get(0).toString());
        this.h_inicio.setText(fechas.get(2).toString());
        this.h_fin.setText(fechas.get(3).toString());
        completarTabla();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void completarTabla(){
        DefaultTableModel dtm = (DefaultTableModel) this.tabla.getModel();
        dtm.setRowCount(0);
        for (int i=0; i<this.aulas.size(); i++){
            String datos[] = new String[3];
            datos[0] = this.aulas.get(i).getNombre();
            datos[1] = this.aulas.get(i).getCapacidad().toString();
            datos[2] = this.aulas.get(i).getPiso().toString();
            dtm.addRow(datos);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        seleccionar = new javax.swing.JButton();
        fecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        h_inicio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        h_fin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        backButton = new javax.swing.JButton();
        minimizeButton = new javax.swing.JButton();

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel10.setText("Hora de inicio:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel11.setText("Aulas disponibles para:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Capacidad", "Piso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        seleccionar.setBackground(new java.awt.Color(204, 204, 204));
        seleccionar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        seleccionar.setText("Seleccionar");
        seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarActionPerformed(evt);
            }
        });

        fecha.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        fecha.setText("2017/20/20");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setText("desde:");

        h_inicio.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        h_inicio.setText("07:55");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setText("hasta:");

        h_fin.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        h_fin.setText("55:55");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        backButton.setBackground(new java.awt.Color(55, 64, 70));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back-left-arrow-circular-button-outline.png"))); // NOI18N
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setFocusable(false);
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        minimizeButton.setBackground(new java.awt.Color(55, 64, 70));
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diminish.png"))); // NOI18N
        minimizeButton.setBorder(null);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setFocusPainted(false);
        minimizeButton.setFocusable(false);
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseExited(evt);
            }
        });
        minimizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h_inicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h_fin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(seleccionar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minimizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(fecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(h_inicio)
                    .addComponent(jLabel4)
                    .addComponent(h_fin))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(seleccionar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarActionPerformed
        // TODO add your handling code here:
        //REGISTRAR RESERVA CON ESTE AULA
        if (this.tabla.getSelectedRow()!=-1){
            gdr.registrarEsporadica(this.aulas.get(this.tabla.getSelectedRow()), fechas);
        }
        this.contador.add(1);
        System.out.println(contador.size());
        System.out.println(listsize);
        if (contador.size()==listsize){
            gdr.registrarReserva(b, act, doc, cantAlumnos);
        }
        RegistroExitoso rex = new RegistroExitoso();
        
        this.dispose();
    }//GEN-LAST:event_seleccionarActionPerformed

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        // TODO add your handling code here:
        backButton.setContentAreaFilled(true);
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        backButton.setContentAreaFilled(false);
    }//GEN-LAST:event_backButtonMouseExited

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void minimizeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseEntered
        // TODO add your handling code here:
        minimizeButton.setContentAreaFilled(true);
    }//GEN-LAST:event_minimizeButtonMouseEntered

    private void minimizeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseExited
        // TODO add your handling code here:
        minimizeButton.setContentAreaFilled(false);
    }//GEN-LAST:event_minimizeButtonMouseExited

    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeButtonActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizeButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel h_fin;
    private javax.swing.JLabel h_inicio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton minimizeButton;
    private javax.swing.JButton seleccionar;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
