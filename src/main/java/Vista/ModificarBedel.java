/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GestorDeBedel;
import Modelo.Bedel;
import Modelo.Usuario;
import Controlador.UsuarioDAO;
import Modelo.Admin;
import Modelo.Politicascontrasenia;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Integer.parseInt;
import javax.swing.ImageIcon;
import javax.swing.ToolTipManager;

/**
 *
 * @author azuli
 */
public class ModificarBedel extends javax.swing.JFrame {

    /**
     * Creates new form ModificarBedel
     */
    final static Color ROJOERROR = new Color(255, 138, 128);
    Admin adm;
    Bedel b;
    GestorDeBedel gdb;
    Politicascontrasenia pc;
    
    public ModificarBedel(Admin adm, Bedel b) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icono.png")).getImage());
        this.b=b;
        this.adm=adm;
        this.gdb = new GestorDeBedel();
        this.setPoliticas();
        this.username.setText(b.getUsuario().getNombreUsuario());
        String nom = gdb.revertMayus(b.getUsuario().getNombre());
        String ape = gdb.revertMayus(b.getUsuario().getApellido());
        this.name.setText(nom);
        this.last.setText(ape);
        this.email.setText(b.getEmail().toLowerCase());
        this.id.setEditable(false);
        this.id.setFocusable(false);
        this.id.setText(b.getUsuario().getUserId().toString());
        this.turno.setSelectedItem(b.getTurno());
        this.pass1.setText(b.getUsuario().getClave().getValor());
        this.pass2.setText(b.getUsuario().getClave().getValor());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        guardarCambios = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        minimizeButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        last = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        turno = new javax.swing.JComboBox<>();
        jLabelContrasenia = new javax.swing.JLabel();
        pass1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        pass2 = new javax.swing.JPasswordField();
        infoPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        guardarCambios.setBackground(new java.awt.Color(204, 204, 204));
        guardarCambios.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        guardarCambios.setText("Guardar Cambios");
        guardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarCambiosActionPerformed(evt);
            }
        });
        guardarCambios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                guardarCambiosKeyPressed(evt);
            }
        });

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

        exitButton.setBackground(new java.awt.Color(55, 64, 70));
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/closed.png"))); // NOI18N
        exitButton.setBorder(null);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.setFocusable(false);
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonMouseExited(evt);
            }
        });
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color(204, 204, 204));
        cancelar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelarKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        jLabel9.setText("Modificar bedel");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setText("Nombre de usuario:");

        username.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usernameMouseEntered(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Nombre:");

        name.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFocusLost(evt);
            }
        });
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nameMouseEntered(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Apellido:");

        last.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        last.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        last.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastFocusLost(evt);
            }
        });
        last.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lastMouseEntered(evt);
            }
        });
        last.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lastKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setText("Email:");

        email.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });
        email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emailMouseEntered(evt);
            }
        });
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("ID:");

        id.setBackground(new java.awt.Color(204, 204, 204));
        id.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                idFocusLost(evt);
            }
        });
        id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                idMouseEntered(evt);
            }
        });
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Turno:");

        turno.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        turno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mañana", "Tarde", "Noche" }));
        turno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                turnoFocusLost(evt);
            }
        });
        turno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                turnoMouseEntered(evt);
            }
        });

        jLabelContrasenia.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabelContrasenia.setText("Contraseña:");
        jLabelContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelContraseniaMouseEntered(evt);
            }
        });

        pass1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        pass1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pass1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pass1FocusLost(evt);
            }
        });
        pass1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pass1MouseEntered(evt);
            }
        });
        pass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pass1KeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setText("Confirmar Contraseña:");

        pass2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        pass2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pass2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pass2FocusLost(evt);
            }
        });
        pass2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pass2MouseEntered(evt);
            }
        });
        pass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pass2KeyTyped(evt);
            }
        });

        infoPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info.png"))); // NOI18N
        infoPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoPassMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pass2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guardarCambios))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pass1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(turno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelContrasenia)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(infoPass))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(email, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(last, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(minimizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(last, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelContrasenia))
                    .addComponent(infoPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarCambios)
                    .addComponent(cancelar))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void setPoliticas(){
        pc = gdb.getPoliticas();
        String pols="", polAux="";

        int nro = pc.getLongMin();
        if(nro!=0){
            pols="Debe poseer como mínimo " + nro + " caracteres.\n";
        }

        if (pc.isDigito() || pc.isLetraMay() || pc.isSignosEspeciales()){
            pols = pols + "Tiene que contener al menos un/a: \n";
        }

        if(pc.isLetraMay()){
            pols = pols + "\t\t\t-Letra mayúscula\n";
        }

        if(pc.isDigito()){
            pols = pols + "\t\t\t-Dígito\n";
        }

        if(pc.isSignosEspeciales()){
            pols = pols + "\t\t\t-Signo especial\n";
            polAux = "\nLos signos especiales pueden ser: (@#$%&*)";
        }

        if(pc.isPassIgual()){
            pols = pols + "Además no puede ser idéntica a una contraseña anterior.";
        }
        pols = "<html><body><pre>" + pols;
        pols = pols + polAux + "</pre></body></html>";
        this.infoPass.setToolTipText(pols);
        ToolTipManager.sharedInstance().setDismissDelay(10000);
    }
    
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.confirmarCancelar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited
        // TODO add your handling code here:
        exitButton.setContentAreaFilled(false);
    }//GEN-LAST:event_exitButtonMouseExited

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        // TODO add your handling code here:
        exitButton.setContentAreaFilled(true);
    }//GEN-LAST:event_exitButtonMouseEntered

    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeButtonActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizeButtonActionPerformed

    private void minimizeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseExited
        // TODO add your handling code here:
        minimizeButton.setContentAreaFilled(false);
    }//GEN-LAST:event_minimizeButtonMouseExited

    private void minimizeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseEntered
        // TODO add your handling code here:
        minimizeButton.setContentAreaFilled(true);
    }//GEN-LAST:event_minimizeButtonMouseEntered

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.confirmarCancelar();
    }//GEN-LAST:event_backButtonActionPerformed

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        // TODO add your handling code here:
        backButton.setContentAreaFilled(false);
    }//GEN-LAST:event_backButtonMouseExited

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        // TODO add your handling code here:
        backButton.setContentAreaFilled(true);
    }//GEN-LAST:event_backButtonMouseEntered

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained
        this.setAlwaysOnTop(false);
    }//GEN-LAST:event_usernameFocusGained

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        if(this.username.getText().length()>15){
            this.username.setBackground(ROJOERROR);
            username.setToolTipText("El nombre de usuario supera los 15 caracteres");
        }else{
            if (this.username.getText().isEmpty()){
            this.username.setBackground(ROJOERROR);
            username.setToolTipText("No puede utilizarse un nombre de usuario vacío.");
        }else{
            if (!this.username.getText().equals(b.getUsuario().getNombreUsuario())){
                Usuario us = gdb.devolverNombreUsuario(username.getText());
                if (!(us == null)){
                    this.username.setBackground(ROJOERROR);
                    username.setToolTipText("El nombre de usuario ya existe.");
                }
                else{
                    this.username.setBackground(Color.white);
                    username.setToolTipText("");
                }
            }else{
                this.username.setBackground(Color.white);
                username.setToolTipText("");
            }
        }  
        }
    }//GEN-LAST:event_usernameFocusLost

    private void usernameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseEntered

    }//GEN-LAST:event_usernameMouseEntered

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed

    }//GEN-LAST:event_usernameActionPerformed

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.guardarCambios.requestFocus();
            this.guardarCambios.doClick();
        }
    }//GEN-LAST:event_usernameKeyPressed

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
        if (this.username.getText().length()>34 || (evt.getKeyChar() == KeyEvent.VK_SPACE)){
            evt.consume();
        }
    }//GEN-LAST:event_usernameKeyTyped

    private void nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusLost
        //COMPRUEBO QUE NO HAYA ESPACIOS AL PRINCIPIO NI AL FINAL Y SI HAY, LOS ELIMINO
        this.name.setText(gdb.ignoreSpaces(this.name.getText()));
        if (this.name.getText().isEmpty()){
            this.name.setBackground(ROJOERROR);
            name.setToolTipText("No puede utilizarse un nombre vacío.");
        }else{
            this.name.setBackground(Color.white);
            name.setToolTipText("");
        }
    }//GEN-LAST:event_nameFocusLost

    private void nameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseEntered
        if(this.name.getBackground().equals(ROJOERROR)){
            name.setToolTipText("No puede utilizarse un nombre vacío.");
        }else{
            name.setToolTipText("");
        }
    }//GEN-LAST:event_nameMouseEntered

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.guardarCambios.requestFocus();
            this.guardarCambios.doClick();
        }
    }//GEN-LAST:event_nameKeyPressed

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
        if (!((evt.getKeyChar()>=KeyEvent.VK_A && evt.getKeyChar()<=KeyEvent.VK_Z) || (evt.getKeyChar()>=97 && evt.getKeyChar()<=122) || (evt.getKeyChar() == KeyEvent.VK_SPACE) || gdb.isEnieOAcento(evt)) || this.name.getText().length()>19)
            evt.consume();
    }//GEN-LAST:event_nameKeyTyped

    private void lastFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastFocusLost
        //COMPRUEBO QUE NO HAYA ESPACIOS AL PRINCIPIO NI AL FINAL Y SI HAY, LOS ELIMINO
        this.last.setText(gdb.ignoreSpaces(this.last.getText()));
        if (this.last.getText().isEmpty()){
            this.last.setBackground(ROJOERROR);
            last.setToolTipText("No puede utilizarse un apellido vacío.");
        }else{
            this.last.setBackground(Color.white);
            last.setToolTipText("");
        }
    }//GEN-LAST:event_lastFocusLost

    private void lastMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastMouseEntered

    }//GEN-LAST:event_lastMouseEntered

    private void lastKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.guardarCambios.requestFocus();
            this.guardarCambios.doClick();
        }
    }//GEN-LAST:event_lastKeyPressed

    private void lastKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastKeyTyped
        if (!((evt.getKeyChar()>=KeyEvent.VK_A && evt.getKeyChar()<=KeyEvent.VK_Z) || (evt.getKeyChar()>=97 && evt.getKeyChar()<=122) || (evt.getKeyChar() == KeyEvent.VK_SPACE) || gdb.isEnieOAcento(evt)) || this.last.getText().length()>19)
            evt.consume();
    }//GEN-LAST:event_lastKeyTyped

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
        this.setAlwaysOnTop(false);
    }//GEN-LAST:event_emailFocusGained

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        if (this.email.getText().isEmpty()){
            this.email.setBackground(ROJOERROR);
            email.setToolTipText("No puede utilizarse un correo electrónico vacío.");
        }else{
            if(!this.email.getText().contains("@") || !this.email.getText().contains(".")){
                this.email.setBackground(ROJOERROR);
                email.setToolTipText("El correo electrónico no es válido.");
            }else{
                this.email.setBackground(Color.white);
                email.setToolTipText("");
            }
        }
    }//GEN-LAST:event_emailFocusLost

    private void emailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseEntered

    }//GEN-LAST:event_emailMouseEntered

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.guardarCambios.requestFocus();
            this.guardarCambios.doClick();
        }
    }//GEN-LAST:event_emailKeyPressed

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        if (this.email.getText().length()>34 || (evt.getKeyChar() == KeyEvent.VK_SPACE)){
            evt.consume();
        }
    }//GEN-LAST:event_emailKeyTyped

    private void idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFocusGained

    }//GEN-LAST:event_idFocusGained

    private void idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFocusLost

    }//GEN-LAST:event_idFocusLost

    private void idMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idMouseEntered

    }//GEN-LAST:event_idMouseEntered

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyPressed

    }//GEN-LAST:event_idKeyPressed

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped

    }//GEN-LAST:event_idKeyTyped

    private void turnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_turnoFocusLost

    }//GEN-LAST:event_turnoFocusLost

    private void turnoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_turnoMouseEntered

    }//GEN-LAST:event_turnoMouseEntered

    private void jLabelContraseniaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelContraseniaMouseEntered

    }//GEN-LAST:event_jLabelContraseniaMouseEntered

    private void pass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass1FocusGained
        this.setAlwaysOnTop(false);
    }//GEN-LAST:event_pass1FocusGained

    private void pass1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass1FocusLost
        String contra=String.valueOf(pass1.getPassword()), contra2=String.valueOf(pass2.getPassword());
        String passtring = String.valueOf(pass1.getPassword());
        int ID = Integer.parseInt(this.id.getText());
        if(passtring.isEmpty()){
            pass1.setToolTipText("No puede utilizarse una contraseña vacía.");
            this.pass1.setBackground(ROJOERROR);
        }else{
            if (!passtring.equals(b.getUsuario().getClave().getValor())){
                int error = gdb.validarPass(passtring, ID);
                if (!(error == 0)){
                    switch (error){
                        case 1:
                            pass1.setToolTipText("La contraseña es demasiado corta.");
                            break;
                        case 2:
                            pass1.setToolTipText("La contraseña no contiene signos especiales.");
                            break;
                        case 3:
                            pass1.setToolTipText("La contraseña no contiene dígito.");
                            break;
                        case 4:
                            pass1.setToolTipText("La contraseña no contiene letra mayúscula.");
                            break;
                        case 5:
                            pass1.setToolTipText("La contraseña ya existe.");
                            break;
                    }
                    this.pass1.setBackground(ROJOERROR);
                }else{
                    this.pass1.setBackground(Color.white);
                    pass1.setToolTipText("");
                }
                if (!gdb.matchPass(contra, contra2) || contra2.isEmpty()){
                    this.pass2.setBackground(ROJOERROR);
                    pass2.setToolTipText("Las contraseñas no coinciden.");
                }else{
                    this.pass2.setBackground(Color.white);
                    pass2.setToolTipText("");
                }
            }else{
                this.pass1.setBackground(Color.white);
                pass1.setToolTipText("");
            }
        }
    }//GEN-LAST:event_pass1FocusLost

    private void pass1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass1MouseEntered

    }//GEN-LAST:event_pass1MouseEntered

    private void pass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.guardarCambios.requestFocus();
            this.guardarCambios.doClick();
        }
    }//GEN-LAST:event_pass1KeyPressed

    private void pass1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass1KeyTyped
        if (String.valueOf(pass1.getPassword()).length()>29){
            evt.consume();
        }
    }//GEN-LAST:event_pass1KeyTyped

    private void pass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass2FocusGained
        this.setAlwaysOnTop(false);
    }//GEN-LAST:event_pass2FocusGained

    private void pass2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass2FocusLost
        String contra=String.valueOf(pass1.getPassword()), contra2=String.valueOf(pass2.getPassword());
        if (contra2.isEmpty()){
            this.pass2.setBackground(ROJOERROR);
            pass2.setToolTipText("Debe confirmar la contraseña.");
        }else{
            if (!gdb.matchPass(contra, contra2)){
                this.pass2.setBackground(ROJOERROR);
                pass2.setToolTipText("Las contraseñas no coinciden.");
            }else{
                this.pass2.setBackground(Color.white);
            }
        }
    }//GEN-LAST:event_pass2FocusLost

    private void pass2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass2MouseEntered

    }//GEN-LAST:event_pass2MouseEntered

    private void pass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.guardarCambios.requestFocus();
            this.guardarCambios.doClick();
        }
    }//GEN-LAST:event_pass2KeyPressed

    private void pass2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass2KeyTyped
        if (String.valueOf(pass2.getPassword()).length()>29){
            evt.consume();
        }
    }//GEN-LAST:event_pass2KeyTyped

    private void guardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarCambiosActionPerformed
        ModificarBedel esta=this;
        this.setAlwaysOnTop(true);
        this.setEnabled(false);
        String contra= String.valueOf(pass1.getPassword()), contra2=String.valueOf(pass2.getPassword());
        if (gdb.camposLlenos(username.getText(), name.getText(), last.getText(), email.getText(), id.getText(), turno.getSelectedItem().toString(), contra, contra2)){
            int validacion = gdb.validar(username.getText(), email.getText(), id.getText(), contra, contra2, b);
            switch (validacion){
                case 0:
                    ConfirmacionGuardarCambios cgc = new ConfirmacionGuardarCambios(adm, this);
                    cgc.getCancelar().addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        esta.setEnabled(true);
                        esta.username.requestFocus();
                    }
                    });
                    cgc.getConfirmar().addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        gdb.modificarDatosBedel(pc, contra, b.getUsuario().getClave(), username.getText(), name.getText().toUpperCase(), last.getText().toUpperCase(), b.getUsuario(), turno.getSelectedItem().toString(), email.getText().toUpperCase(), b);
                    }
                    });
                    break;
                case 1:
                    ErrorNombreUsuario enu = new ErrorNombreUsuario();
                    enu.addWindowListener(new WindowAdapter(){
                        public void windowClosed(WindowEvent e){
                            esta.setEnabled(true);
                            esta.username.requestFocus();
                        }
                    });
                    break;
                case 2:
                    ErrorEmail ee = new ErrorEmail();
                    ee.addWindowListener(new WindowAdapter(){
                        public void windowClosed(WindowEvent e){
                            esta.setEnabled(true);
                            esta.email.requestFocus();
                        }
                    });
                    break;
                case 4:
                    ErrorCondicionesDeContraseñas eccoi = new ErrorCondicionesDeContraseñas();
                    eccoi.addWindowListener(new WindowAdapter(){
                        public void windowClosed(WindowEvent e){
                            esta.setEnabled(true);
                            esta.pass1.requestFocus();
                        }
                    });
                    break;
                case 5:
                    ErrorCoincidenciaContraseñas ecc = new ErrorCoincidenciaContraseñas();
                    ecc.addWindowListener(new WindowAdapter(){
                        public void windowClosed(WindowEvent e){
                            esta.setEnabled(true);
                            esta.pass2.requestFocus();
                        }
                    });
                break;
            }
        }else{
            ErrorCamposVacios ecv = new ErrorCamposVacios();
            ecv.addWindowListener(new WindowAdapter(){
                public void windowClosed(WindowEvent e){
                    esta.setEnabled(true);
                    esta.username.requestFocus();
                }
            });
        }
    }//GEN-LAST:event_guardarCambiosActionPerformed

    private void cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.cancelar.doClick();
        }
    }//GEN-LAST:event_cancelarKeyPressed

    private void infoPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoPassMouseEntered
        
    }//GEN-LAST:event_infoPassMouseEntered

    private void guardarCambiosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guardarCambiosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.guardarCambios.doClick();
        }
    }//GEN-LAST:event_guardarCambiosKeyPressed

    private void confirmarCancelar(){
        ModificarBedel esta=this;
        esta.setAlwaysOnTop(true);
        ConfirmacionCancelarModificar ccm = new ConfirmacionCancelarModificar();
        esta.setEnabled(false);
        ccm.getCancelar().addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            esta.setEnabled(true);
            esta.username.requestFocus();
        }
        });
        ccm.getConfirmar().addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            esta.dispose();
            BuscarBedel bb = new BuscarBedel(adm);
        }
        });
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField email;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton guardarCambios;
    private javax.swing.JTextField id;
    private javax.swing.JLabel infoPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelContrasenia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField last;
    private javax.swing.JButton minimizeButton;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JComboBox<String> turno;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
