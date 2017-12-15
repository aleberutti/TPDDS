/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.AutoSuggestor;
import Controlador.ActividadDAO;
import Controlador.DocenteDAO;
import Controlador.FechasLectivasDAO;
import Controlador.GestorDeActividad;
import Controlador.GestorDeDocente;
import Controlador.GestorDeFechasLectivas;
import Controlador.GestorDeReserva;
import Controlador.UsuarioDAO;
import Controlador.RangeEvaluator;
import Modelo.Actividad;
import Modelo.Aula;
import Modelo.Bedel;
import Modelo.Catedra;
import Modelo.Curso;
import Modelo.Docente;
import Modelo.FechalectivasId;
import Modelo.Seminario;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Fausto
 */
public class RegistroEsporadica extends javax.swing.JFrame {

    /**
     * Creates new form RegistroPeriodica
     */
    private Bedel b;
    private GestorDeReserva gdr;
    private DefaultTableModel modelo;
    private List <Actividad> actividades;
    private List<Docente> docentes;
    private Object prevValIn;
    private Object prevValFin;
    private AutoSuggestor a1;
    private AutoSuggestor a2;
    private AutoSuggestor a3;
    private JComboBox carrera;
    private GestorDeDocente gd= new GestorDeDocente();
    private GestorDeActividad ga= new GestorDeActividad();
    private GestorDeFechasLectivas gfl= new GestorDeFechasLectivas();
    private ArrayList <String> curso = ga.getCursos();
    private ArrayList <String> car = ga.getCursosCarrera();
    private ArrayList <String> sem =ga.getSeminarios();
    private ArrayList <String> themes =ga.getSeminariosThemes();
    private ArrayList <String> carr =ga.getCatedrasCarrera();
    private ArrayList <String> com =ga.getCatedrasComision();
    
    public RegistroEsporadica(Bedel b){
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icono.png")).getImage());
        this.b=b;
        this.setLocationRelativeTo(null);
        this.a1 = new AutoSuggestor(this.text1, this, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f);
        this.a2 = new AutoSuggestor(this.text2, this, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f);
        this.a3 = new AutoSuggestor(this.text3, this, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f);        
        this.gdr = new GestorDeReserva();
        this.modelo = (DefaultTableModel) this.tabla.getModel();
        this.setearDayChooser();
        this.prevValIn=this.hora_inicio.getValue();
        this.prevValFin=this.hora_fin.getValue();
        setDocentes();
        ComboDocente.setSelectedIndex(0);
        this.carrera =  new JComboBox();
        this.carrera.setSize(this.text2.getSize());
        this.carrera.setLocation(this.text2.getLocation());
        this.carrera.setBackground(this.ComboDocente.getBackground());
        this.carrera.setForeground(this.ComboDocente.getForeground());
        this.jPanel1.add(carrera);
        text1.setVisible(false);
        text2.setVisible(false);
        text3.setVisible(false);
        carrera.setVisible(false);
        emailprofe.setText("Seleccione un docente de la lista");
        this.actividades=this.ga.obtenerActividad();
        this.setVisible(true);
    }
    

    
    public void setDocentes(){
        //seteo el combobox con nombre y apellido de los docentes de la bd
        ArrayList <String> datos = new ArrayList(); 
        datos.addAll(this.gd.getApellidoNombre());
        this.docentes=this.gd.getDocentes();

        if(datos.isEmpty()){
            JOptionPane.showMessageDialog(null,"No se encuentran docentes en la BD"); 
            ComboDocente.setEnabled(false);
            emailprofe.setText("No existen docentes en la BD");
        }else{
            emailprofe.setText("Seleccione un docente de la lista");
            ComboDocente.setModel(new DefaultComboBoxModel(datos.toArray()));  
        }      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        aceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lcant = new javax.swing.JLabel();
        cantAlumnos = new javax.swing.JSpinner();
        ltipoa = new javax.swing.JLabel();
        tipoDeAula = new javax.swing.JComboBox<>();
        lapel = new javax.swing.JLabel();
        ltipo = new javax.swing.JLabel();
        lmail = new javax.swing.JLabel();
        emailprofe = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cargar = new javax.swing.JButton();
        hora_fin = new javax.swing.JSpinner();
        hora_inicio = new javax.swing.JSpinner();
        fecha = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        exitButton = new javax.swing.JButton();
        minimizeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        ComboDocente = new javax.swing.JComboBox<>();
        eliminar = new javax.swing.JButton();
        text3 = new javax.swing.JTextField();
        info3 = new javax.swing.JLabel();
        info2 = new javax.swing.JLabel();
        text2 = new javax.swing.JTextField();
        text1 = new javax.swing.JTextField();
        info1 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));

        aceptar.setBackground(new java.awt.Color(204, 204, 204));
        aceptar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file.png"))); // NOI18N
        jLabel4.setText("Reserva Esporádica");

        lcant.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lcant.setText("Cantidad de Alumnos:");

        cantAlumnos.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        cantAlumnos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cantAlumnosFocusGained(evt);
            }
        });

        ltipoa.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ltipoa.setText("Tipo de Aula:");

        tipoDeAula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Multimedios", "Informática", "Sin Recursos Adicionales" }));
        tipoDeAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDeAulaActionPerformed(evt);
            }
        });

        lapel.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lapel.setText("Apellido y nombre:");

        ltipo.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ltipo.setText("Tipo:");

        lmail.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lmail.setText("E-mail:");

        emailprofe.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        emailprofe.setText("email");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Día", "Hora inicio", "Hora fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        cargar.setBackground(new java.awt.Color(204, 204, 204));
        cargar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cargar.setText("Cargar");
        cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarActionPerformed(evt);
            }
        });

        hora_fin.setModel(new javax.swing.SpinnerListModel(new String[] {"07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45"}));
        hora_fin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hora_finStateChanged(evt);
            }
        });

        hora_inicio.setModel(new javax.swing.SpinnerListModel(new String[] {"07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15"}));
        hora_inicio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hora_inicioStateChanged(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel13.setText("Elija una fecha:");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel14.setText("Hora de inicio:");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel17.setText("Hora de fin:");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

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

        ComboDocente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        ComboDocente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboDocenteItemStateChanged(evt);
            }
        });

        eliminar.setBackground(new java.awt.Color(204, 204, 204));
        eliminar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        info3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        info3.setText("Información:");

        info2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        info2.setText("Información:");

        info1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        info1.setText("Información:");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Curso", "Seminario", "Carrera de grado" }));
        comboTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTipoItemStateChanged(evt);
            }
        });
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cargar)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel17))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(27, 27, 27)
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lcant)
                            .addComponent(ltipoa)
                            .addComponent(lapel)
                            .addComponent(lmail))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tipoDeAula, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ComboDocente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cantAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailprofe))))
                        .addGap(115, 115, 115))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(368, 368, 368)
                                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(info2)
                                    .addComponent(info1)
                                    .addComponent(info3)
                                    .addComponent(ltipo))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(text3)
                                    .addComponent(text1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                                    .addComponent(text2))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(minimizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton))
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(cargar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcant)
                    .addComponent(cantAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ltipoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipoDeAula, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lapel)
                    .addComponent(ComboDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lmail)
                    .addComponent(emailprofe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ltipo)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(text1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(info2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(info3)
                    .addComponent(text3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void setearDayChooser(){
        FechalectivasId fd = this.gfl.obtenerFechas();
        if (fd==null){
            JOptionPane.showMessageDialog(null,"No se encuentran fechas lectivas en la BD");
            return ;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());
        try{
            if (sdf.parse(today).after(fd.getFechainicio1c())){
                this.fecha.setMinSelectableDate(sdf.parse(today));
            }else{
                this.fecha.setMinSelectableDate(fd.getFechainicio1c());
            }
        }catch(ParseException e){
            
        }
        this.fecha.setMaxSelectableDate(fd.getFechafin2c());
//        System.out.println("Fecha fin 2 c: " + sdf.format(fd.getFechafin2c()) + " Fecha incio 1 c : " + sdf.format(fd.getFechainicio1c()));
        RangeEvaluator re2 = new RangeEvaluator();
        re2.setStartDate(fd.getFechafin1c());
        re2.setEndDate(fd.getFechainicio2c());
        this.fecha.getJCalendar().getDayChooser().addDateEvaluator(re2);
    }
    
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

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        // TODO add your handling code here:
        backButton.setContentAreaFilled(true);
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        backButton.setContentAreaFilled(false);
    }//GEN-LAST:event_backButtonMouseExited

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        RegistroDeReserva rdr = new RegistroDeReserva(b);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        //VALIDACIONES
        if(tabla.getRowCount() == 0){
            ErrorTableEmpty ete = new ErrorTableEmpty();
            ete.setVisible(true);
        }else{
            if(cantAlumnos.getValue().equals(0)){
                ErrorValueCero evc = new ErrorValueCero();
                evc.setVisible(true);
            }else{
                if(ComboDocente.getSelectedItem().toString().equals("Seleccione un docente de la lista")){
                    ErrorSeleccDocente esc = new ErrorSeleccDocente();
                    esc.setVisible(true);
                }else{
                    if(comboTipo.getSelectedIndex()==0){
                       ErrorSeleccTipo est = new ErrorSeleccTipo();
                       est.setVisible(true);
                    }else{
                       if(selecTipo()){
                           ErrorCamposVacios ecv = new ErrorCamposVacios();
                           ecv.setVisible(true);
                       }else{
                           registrarReserva();
                       } 
                    }
                }
            }    
        }
    }//GEN-LAST:event_aceptarActionPerformed
    public boolean selecTipo(){
        
        switch(comboTipo.getSelectedItem().toString()){
            case "Curso":
                    if(text1.getText().equals("")){
                        return true;
                    }else{
                        return false;
                    }
            case "Seminario":
                    if(text1.getText().equals("") || text2.getText().equals("")){
                        return true;
                    }else{
                        return false;
                    }
            case "Carrera de grado":
                 if(text1.getText().equals("") || text3.getText().equals("")){
                        return true;
                    }else{
                        return false;
                    }
            default:    return true;
        }
    }
    private void registrarReserva(){
        //CREO OBJETOS NECESARIOS PARA RESERVA
        Docente doc = docentes.get(this.ComboDocente.getSelectedIndex()-1);
        Actividad act = this.getActividad(this.text1.getText().substring(0, this.text1.getText().length()-1 ));
        List aulasPTodas = gdr.validarReservaEsporadica(this.modelo.getDataVector(), Integer.parseInt(this.cantAlumnos.getValue().toString()), this.tipoDeAula.getSelectedItem().toString());
        List<Integer> contador = new ArrayList();
        for(int i=0; i<aulasPTodas.size(); i+=2){
            if (aulasPTodas.get(i+1)!=null){
                RegistroEsporadica esta = this;
                this.setEnabled(false);
                this.setAlwaysOnTop(true);
                AulasDisponibles aulasd = new AulasDisponibles(((Vector)aulasPTodas.get(i)),((List<Aula>)aulasPTodas.get(i+1)), this.gdr, contador, (aulasPTodas.size()/2), b, act, doc, Integer.parseInt(this.cantAlumnos.getValue().toString()), this);
                aulasd.addWindowListener(new WindowAdapter(){
                    public void windowClosed(WindowEvent e){
                        esta.cantAlumnos.requestFocus();
                    }
                });
            }
            else{
                RegistroEsporadica esta = this;
                esta.setAlwaysOnTop(true);
                this.setEnabled(false);
                ErrorNoExisteAula enea = new ErrorNoExisteAula(((Vector)aulasPTodas.get(i)), this.gdr, contador, (aulasPTodas.size()/2), b, act, doc, Integer.parseInt(this.cantAlumnos.getValue().toString()), this);
                enea.addWindowListener(new WindowAdapter(){
                    public void windowClosed(WindowEvent e){
                        esta.cantAlumnos.requestFocus();
                    }
                });
            }
        }
        this.modelo.setRowCount(0);
    }
    private Actividad getActividad (String nombre){
        
        for (Actividad a: this.actividades){
                    if (a.getNombre().equals(nombre)){
                        return a;
                    }
        }
        return null;
    }
    
    private void hora_inicioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hora_inicioStateChanged
        SimpleDateFormat sdf = new SimpleDateFormat(this.fecha.getDateFormatString());
        Date today = new Date();
        String seleccionada = sdf.format(this.fecha.getDate());
        String hoy = sdf.format(today);
        if (hoy.equals(seleccionada)){
            sdf = new SimpleDateFormat("HH:mm");
            Date h_i = null;
            try {
                h_i = sdf.parse(this.hora_inicio.getValue().toString());
                Date hora_hoy = sdf.parse(today.getHours() + ":" + today.getMinutes());
                while(h_i.before(hora_hoy)){
                    this.hora_inicio.setValue(this.hora_inicio.getNextValue());
                    h_i = sdf.parse(this.hora_inicio.getValue().toString());
                }
            } catch (ParseException ex) {
                Logger.getLogger(RegistroEsporadica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.hora_finStateChanged(evt);
    }//GEN-LAST:event_hora_inicioStateChanged

    private void cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarActionPerformed
        
        if(fecha.getDate() == null){
            ErrorFechaEmpty efe = new ErrorFechaEmpty();
            efe.setVisible(true);
        }else{
        
        String datos[] = new String [4];
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = sdf.format(fecha.getDate().getTime());
        String horaIn = hora_inicio.getValue().toString(), horaFin = hora_fin.getValue().toString();
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha.getDate());
        String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("es", "ES")).toUpperCase();
        
        datos[0] = date1;
        datos[1] = dayOfWeek;
        datos[2] = horaIn;
        datos[3] = horaFin;
        
        if(datos[1].equals("DOMINGO")){
            this.setEnabled(false);
            RegistroEsporadica esta = this;
            this.setAlwaysOnTop(true);
            ErrorReservaDomingo erd = new ErrorReservaDomingo();
            erd.addWindowListener(new WindowAdapter(){
                public void windowClosed(WindowEvent e){
                    esta.setEnabled(true);
                    esta.cantAlumnos.requestFocus();
                }
            });
            return ;
        }
        
        
        if(gdr.existe(date1, horaIn, horaFin, modelo)){
            this.setEnabled(false);
            RegistroEsporadica esta = this;
            this.setAlwaysOnTop(true);
            ErrorRepiteHorario erh = new ErrorRepiteHorario();
            erh.addWindowListener(new WindowAdapter(){
                public void windowClosed(WindowEvent e){
                    esta.setEnabled(true);
                    esta.cantAlumnos.requestFocus();
                }
            });
            return ;
        }
        
        if (!horaIn.equals(horaFin) && !gdr.existe(date1, horaIn, horaFin, modelo)){
            modelo.addRow(datos);
        }
        
        }
    }//GEN-LAST:event_cargarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (this.tabla.getSelectedRow()>=0)
            modelo.removeRow(this.tabla.getSelectedRow());
    }//GEN-LAST:event_eliminarActionPerformed

    private void hora_finStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hora_finStateChanged
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date h_f, h_i;
        try {
            h_f = sdf.parse(hora_fin.getValue().toString());
            h_i = sdf.parse(hora_inicio.getValue().toString());
            if (h_f.before(h_i) || h_f.equals(h_i)){
                hora_fin.setValue(hora_inicio.getNextValue());
            }
            int aux = h_f.getMinutes() - h_i.getMinutes();
            if (this.prevValFin.equals(this.hora_fin.getNextValue())){ //DECREMENTE EL SPINNER
                if (aux%30!=0){
                    if(!hora_fin.getPreviousValue().equals(hora_inicio.getValue())){
                        hora_fin.setValue(hora_fin.getPreviousValue());
                    }else{
                        hora_fin.setValue(hora_fin.getNextValue());
                    }
                }
            }else{
                if (aux%30!=0){
                    if (this.prevValIn.equals(this.hora_inicio.getNextValue())){
                        hora_fin.setValue(hora_fin.getPreviousValue());
                    }else{
                        hora_fin.setValue(hora_fin.getNextValue());
                    }
                }
            }
        } catch (ParseException ex) {
            System.out.println("Error parseo.");
        }
        this.prevValIn=this.hora_inicio.getValue();
        this.prevValFin=this.hora_fin.getValue();
    }//GEN-LAST:event_hora_finStateChanged

    private void ComboDocenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboDocenteItemStateChanged

        String mailDoc=gd.getDocenteEmail(ComboDocente.getSelectedItem().toString());
        if(mailDoc.isEmpty() || ComboDocente.getSelectedIndex()==0){
            emailprofe.setText("Seleccione un docente de la lista");
        }else{
            emailprofe.setText(mailDoc);
        }
    }//GEN-LAST:event_ComboDocenteItemStateChanged


    
    private void cantAlumnosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantAlumnosFocusGained
        this.setAlwaysOnTop(false);
    }//GEN-LAST:event_cantAlumnosFocusGained

    private void tipoDeAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDeAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoDeAulaActionPerformed

    private void comboTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTipoItemStateChanged

        text2.setVisible(true);
        if (comboTipo.getSelectedIndex()==0){
            text1.setVisible(false);
            text2.setVisible(false);
            text3.setVisible(false);
            carrera.setVisible(false);
        }
        switch(comboTipo.getSelectedItem().toString()){
            case "Curso":
                text2.setVisible(false);
                info1.setText("Nombre:");
                text1.setVisible(true);
                info2.setText("Carrera:");
                carrera.setVisible(true);
                this.a1.setDictionary(this.curso);
                carrera.setModel(new DefaultComboBoxModel(this.car.toArray()));
            break;
            case "Seminario":
                carrera.setVisible(false);
                text3.setVisible(false);
                info1.setText("Nombre:");
                info2.setText("Tema:");
                text1.setVisible(true);
                text2.setVisible(true);
                this.a1.setDictionary(this.sem);
                this.a2.setDictionary(this.themes);
            break;
            case "Carrera de grado":
                text2.setVisible(false);
                info1.setText("Cátedra:");
                text1.setVisible(true);
                info2.setText("Carrera:");
                carrera.setVisible(true);
                info3.setText("Comisión:");
                text3.setVisible(true);
                ArrayList <String> cat =ga.getCatedras();
                this.a1.setDictionary(cat);
                carrera.setModel(new DefaultComboBoxModel(this.carr.toArray()));
                this.a3.setDictionary(this.com);
            break;
        }
    }//GEN-LAST:event_comboTipoItemStateChanged

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboDocente;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton backButton;
    private javax.swing.JSpinner cantAlumnos;
    private javax.swing.JButton cargar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel emailprofe;
    private javax.swing.JButton exitButton;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JSpinner hora_fin;
    private javax.swing.JSpinner hora_inicio;
    private javax.swing.JLabel info1;
    private javax.swing.JLabel info2;
    private javax.swing.JLabel info3;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lapel;
    private javax.swing.JLabel lcant;
    private javax.swing.JLabel lmail;
    private javax.swing.JLabel ltipo;
    private javax.swing.JLabel ltipoa;
    private javax.swing.JButton minimizeButton;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    private javax.swing.JTextField text3;
    private javax.swing.JComboBox<String> tipoDeAula;
    // End of variables declaration//GEN-END:variables
}
