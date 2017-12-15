/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GestorDeBedel;
import Controlador.UsuarioDAO;
import Modelo.Admin;
import Modelo.Bedel;
import Modelo.Clave;
import Modelo.Politicascontrasenia;
import Modelo.Usuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.ToolTipManager;

/**
 *
 * @author azuli
 */
public class RegistrarBedel extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarBedel
     */
    Admin adm;
    GestorDeBedel gdb;
    Politicascontrasenia pc;
    final static Color ROJOERROR = new Color(255, 138, 128);
    
    public RegistrarBedel(Admin adm) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icono.png")).getImage());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        gdb = new GestorDeBedel();
        this.setPoliticas();
        this.adm=adm;
    }
    
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
            pols = pols + "No puede ser idéntica a una contraseña anterior.";
        }
        pols = "<html><body><pre>" + pols;
        pols = pols + polAux + "</pre></body></html>";
        this.infoPass.setToolTipText(pols);
        ToolTipManager.sharedInstance().setDismissDelay(10000);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelContrasenia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        pass2 = new javax.swing.JPasswordField();
        name = new javax.swing.JTextField();
        last = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        pass1 = new javax.swing.JPasswordField();
        turno = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        minimizeButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        infoPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Apellido:");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("ID:");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Turno:");

        jLabelContrasenia.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabelContrasenia.setText("Contraseña:");
        jLabelContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelContraseniaMouseEntered(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setText("Confirmar Contraseña:");

        aceptar.setBackground(new java.awt.Color(204, 204, 204));
        aceptar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        aceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aceptarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aceptarKeyTyped(evt);
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

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

        turno.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        turno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Mañana", "Tarde", "Noche" }));
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

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reg.png"))); // NOI18N
        jLabel7.setText("Registrar bedel");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setText("Nombre de usuario:");

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setText("Email:");

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
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                        .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pass1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(turno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelContrasenia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(infoPass))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(last, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                                        .addComponent(email, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING))))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minimizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(backButton)))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(last, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelContrasenia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(infoPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        RegistrarBedel esta=this;
        this.setAlwaysOnTop(true);
        this.setEnabled(false);
        String contra= String.valueOf(pass1.getPassword()), contra2=String.valueOf(pass2.getPassword());
        if (gdb.camposLlenos(username.getText(), name.getText(), last.getText(), email.getText(), id.getText(), turno.getSelectedItem().toString(), contra, contra2)){
            int validacion = gdb.validar(username.getText(), email.getText(), id.getText(), contra, contra2, new Bedel(0));
            switch (validacion){
                case 0:
                    gdb.guardar(pc, contra, parseInt(id.getText()), username.getText(), name.getText().toUpperCase(), last.getText().toUpperCase(), turno.getSelectedItem().toString(), email.getText().toUpperCase());
                    RegistroExitoso re = new RegistroExitoso();
                    re.addWindowListener(new WindowAdapter(){
                        public void windowClosed(WindowEvent e){
                            esta.dispose();
                            OpcionesDelAdministrador opc = new OpcionesDelAdministrador(adm);
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
                case 3:
                    ErrorRegistrarBedel erb = new ErrorRegistrarBedel();
                    erb.addWindowListener(new WindowAdapter(){
                        public void windowClosed(WindowEvent e){
                            esta.setEnabled(true);
                            esta.id.requestFocus();
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
    }//GEN-LAST:event_aceptarActionPerformed
    
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.verificarCamposCancelar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        
    }//GEN-LAST:event_usernameActionPerformed

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained
        this.setAlwaysOnTop(false);
    }//GEN-LAST:event_usernameFocusGained

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
        this.setAlwaysOnTop(false);
    }//GEN-LAST:event_emailFocusGained

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
        if (!(evt.getKeyChar()>=48 && evt.getKeyChar()<=57) || this.id.getText().length()>10)
            evt.consume();
    }//GEN-LAST:event_idKeyTyped

    private void jLabelContraseniaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelContraseniaMouseEntered

    }//GEN-LAST:event_jLabelContraseniaMouseEntered

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        // TODO add your handling code here:
        backButton.setContentAreaFilled(true);
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        // TODO add your handling code here:
        backButton.setContentAreaFilled(false);
    }//GEN-LAST:event_backButtonMouseExited

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.verificarCamposCancelar();
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

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        // TODO add your handling code here:
        exitButton.setContentAreaFilled(true);
    }//GEN-LAST:event_exitButtonMouseEntered

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited
        // TODO add your handling code here:
        exitButton.setContentAreaFilled(false);
    }//GEN-LAST:event_exitButtonMouseExited

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void aceptarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aceptarKeyTyped
        
    }//GEN-LAST:event_aceptarKeyTyped

    private void aceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aceptarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.aceptar.doClick();
        }
    }//GEN-LAST:event_aceptarKeyPressed

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.aceptar.requestFocus();
            this.aceptar.doClick();
        }
    }//GEN-LAST:event_usernameKeyPressed

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.aceptar.requestFocus();
            this.aceptar.doClick();
        }
    }//GEN-LAST:event_nameKeyPressed

    private void lastKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.aceptar.requestFocus();
            this.aceptar.doClick();
        }
    }//GEN-LAST:event_lastKeyPressed

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.aceptar.requestFocus();
            this.aceptar.doClick();
        }
    }//GEN-LAST:event_emailKeyPressed

    private void idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.aceptar.requestFocus();
            this.aceptar.doClick();
        }
    }//GEN-LAST:event_idKeyPressed

    private void pass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.aceptar.requestFocus();
            this.aceptar.doClick();
        }
    }//GEN-LAST:event_pass1KeyPressed

    private void pass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.aceptar.requestFocus();
            this.aceptar.doClick();
        }
    }//GEN-LAST:event_pass2KeyPressed

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
        if (!((evt.getKeyChar()>=KeyEvent.VK_A && evt.getKeyChar()<=KeyEvent.VK_Z) || (evt.getKeyChar()>=97 && evt.getKeyChar()<=122) || (evt.getKeyChar() == KeyEvent.VK_SPACE) || gdb.isEnieOAcento(evt)) || this.name.getText().length()>19)
            evt.consume();
    }//GEN-LAST:event_nameKeyTyped

    
    private void lastKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastKeyTyped
        if (!((evt.getKeyChar()>=KeyEvent.VK_A && evt.getKeyChar()<=KeyEvent.VK_Z) || (evt.getKeyChar()>=97 && evt.getKeyChar()<=122) || (evt.getKeyChar() == KeyEvent.VK_SPACE) || gdb.isEnieOAcento(evt)) || this.last.getText().length()>19)
            evt.consume();
    }//GEN-LAST:event_lastKeyTyped

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
        if (this.username.getText().length()>14 || (evt.getKeyChar() == KeyEvent.VK_SPACE)){
            evt.consume();
        }
    }//GEN-LAST:event_usernameKeyTyped

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        if (this.email.getText().length()>34 || (evt.getKeyChar() == KeyEvent.VK_SPACE)){
            evt.consume();
        }
    }//GEN-LAST:event_emailKeyTyped

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

    private void pass1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass1FocusLost
        String contra=String.valueOf(pass1.getPassword()), contra2=String.valueOf(pass2.getPassword());
        String passtring = String.valueOf(pass1.getPassword());
        int ID = Integer.parseInt(this.id.getText());
        if(passtring.isEmpty()){
            pass1.setToolTipText("No puede utilizarse una contraseña vacía.");
            this.pass1.setBackground(ROJOERROR);
        }else{
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
        }
    }//GEN-LAST:event_pass1FocusLost

    private void pass2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass2KeyTyped
        if (String.valueOf(pass2.getPassword()).length()>29){
            evt.consume();
        }
    }//GEN-LAST:event_pass2KeyTyped

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

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        if (this.username.getText().isEmpty()){
            this.username.setBackground(ROJOERROR);
            username.setToolTipText("No puede utilizarse un nombre de usuario vacío.");
        }else{
            Usuario us = gdb.devolverNombreUsuario(username.getText());
            if (!(us == null)){
                this.username.setBackground(ROJOERROR);
                username.setToolTipText("El nombre de usuario ya existe.");
            }
            else{
                this.username.setBackground(Color.white);
                username.setToolTipText("");
            }
        }
    }//GEN-LAST:event_usernameFocusLost

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

    private void idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFocusLost
        if (this.id.getText().isEmpty()){
            this.id.setBackground(ROJOERROR);
            id.setToolTipText("No puede utilizarse un ID vacío.");
        }else{
            Usuario us = gdb.devolverUsuario(id.getText());
            if (!(us == null)){
                this.id.setBackground(ROJOERROR);
                id.setToolTipText("El ID ya existe.");
            }else{
                this.id.setBackground(Color.white);
                id.setToolTipText("");
            }
        }
    }//GEN-LAST:event_idFocusLost

    private void turnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_turnoFocusLost
        if (this.turno.getSelectedItem().toString().isEmpty()){
            this.turno.setBackground(ROJOERROR);
            turno.setToolTipText("No puede utilizarse un turno vacío.");
        }else{
            this.turno.setBackground(Color.white);
            turno.setToolTipText("");
        }
    }//GEN-LAST:event_turnoFocusLost

    private void cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.cancelar.doClick();
        }
    }//GEN-LAST:event_cancelarKeyPressed

    private void usernameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseEntered

    }//GEN-LAST:event_usernameMouseEntered

    private void idMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idMouseEntered

    }//GEN-LAST:event_idMouseEntered

    private void pass1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass1KeyTyped
        if (String.valueOf(pass1.getPassword()).length()>29){
            evt.consume();
        }
    }//GEN-LAST:event_pass1KeyTyped

    private void nameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseEntered

    }//GEN-LAST:event_nameMouseEntered

    private void lastMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastMouseEntered

    }//GEN-LAST:event_lastMouseEntered

    private void emailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseEntered

    }//GEN-LAST:event_emailMouseEntered

    private void turnoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_turnoMouseEntered

    }//GEN-LAST:event_turnoMouseEntered

    private void pass1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass1MouseEntered

    }//GEN-LAST:event_pass1MouseEntered

    private void pass2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass2MouseEntered

    }//GEN-LAST:event_pass2MouseEntered

    private void idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFocusGained
        this.setAlwaysOnTop(false);
    }//GEN-LAST:event_idFocusGained

    private void pass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass1FocusGained
        this.setAlwaysOnTop(false);
    }//GEN-LAST:event_pass1FocusGained

    private void pass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pass2FocusGained
        this.setAlwaysOnTop(false);
    }//GEN-LAST:event_pass2FocusGained

    private void usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyReleased

    }//GEN-LAST:event_usernameKeyReleased

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nameKeyReleased

    private void infoPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoPassMouseEntered
        
    }//GEN-LAST:event_infoPassMouseEntered

    public void verificarCamposCancelar(){
        String contra= String.valueOf(pass1.getPassword()), contra2=String.valueOf(pass2.getPassword());
        if (!(gdb.camposVacios(username.getText(), name.getText(), last.getText(), email.getText(), id.getText(), turno.getSelectedItem().toString(), contra, contra2))){
            RegistrarBedel esta=this;
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
                OpcionesDelAdministrador opc = new OpcionesDelAdministrador(adm);
            }
            });
        }else{
            this.dispose();
            OpcionesDelAdministrador opc = new OpcionesDelAdministrador(adm);
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField email;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField id;
    private javax.swing.JLabel infoPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
