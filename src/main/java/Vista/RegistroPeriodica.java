/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.AutoSuggestor;
import Controlador.*;
import Modelo.Actividad;
import Modelo.Aula;
import Modelo.Bedel;
import Modelo.Docente;
import Modelo.Periodo;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author Fausto
 */
public class RegistroPeriodica extends javax.swing.JFrame {

    /**
     * Creates new form RegistroPeriodica
     */
    ButtonGroup bgPer = new ButtonGroup();
    ButtonGroup bgCuat = new ButtonGroup();
    Bedel b;
    private Object prevValInL;
    private Object prevValFinL;
    private Object prevValInM;
    private Object prevValFinM;
    private Object prevValInX;
    private Object prevValFinX;
    private Object prevValInJ;
    private Object prevValFinJ;
    private Object prevValInV;
    private Object prevValFinV;
    private AutoSuggestor a1;
    private AutoSuggestor a2;
    private AutoSuggestor a3;
    private JComboBox carrera;
    private List <Actividad> actividades;
    private List<Docente> docentes;
    private GestorDeDocente gd= new GestorDeDocente();
    private GestorDeActividad ga= new GestorDeActividad();
    private GestorDeAula gda = new GestorDeAula();
    private GestorDeReserva gdr = new GestorDeReserva();
    private ArrayList <String> curso = ga.getCursos();
    private ArrayList <String> car = ga.getCursosCarrera();
    private ArrayList <String> sem =ga.getSeminarios();
    private ArrayList <String> themes =ga.getSeminariosThemes();
    private ArrayList <String> carr =ga.getCatedrasCarrera();
    private ArrayList <String> com =ga.getCatedrasComision();
    
    public RegistroPeriodica(Bedel b) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.a1 = new AutoSuggestor(this.text1, this, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f);
        this.a2 = new AutoSuggestor(this.text2, this, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f);
        this.a3 = new AutoSuggestor(this.text3, this, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f);
        bgPer.add(anual);
        bgPer.add(cuatrimestral);
        bgCuat.add(primero);
        bgCuat.add(segundo);
        this.b=b;
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
        this.actividades=this.ga.obtenerActividad();
        this.setVisible(true);
        emailprofe.setText("Seleccione un docente de la lista");
        this.prevValInL = inicioL.getValue();
        this.prevValFinL = finL.getValue();
        this.prevValInM = inicioM.getValue();
        this.prevValFinM = finM.getValue();
        this.prevValInX = inicioX.getValue();
        this.prevValFinX = finX.getValue();
        this.prevValInJ = inicioJ.getValue();
        this.prevValFinJ = finJ.getValue();
        this.prevValInV = inicioV.getValue();
        this.prevValFinV = finV.getValue();
    }
    
    public void setDocentes(){
        //seteo el combobox con nombre y apellido de los docentes de la bd
        ArrayList <String> datos = new ArrayList();
        this.docentes=this.gd.getDocentes();
        datos.addAll(this.gd.getApellidoNombre());


        if(datos.isEmpty()){
            JOptionPane.showMessageDialog(null,"No se encuentran docentes en la BD"); 
            ComboDocente.setEnabled(false);
            emailprofe.setText("No existen docentes en la BD");
        }else{
            emailprofe.setText("Seleccione un docente de la lista");
            ComboDocente.setModel(new DefaultComboBoxModel(datos.toArray()));  
        }      
    }
    private Actividad getActividad (String nombre){
        
        for (Actividad a: this.actividades){
                    if (a.getNombre().equals(nombre)){
                        return a;
                    }
        }
        return null;
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cuatrimestral = new javax.swing.JRadioButton();
        anual = new javax.swing.JRadioButton();
        primero = new javax.swing.JRadioButton();
        segundo = new javax.swing.JRadioButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        inicioL = new javax.swing.JSpinner();
        lunes = new javax.swing.JCheckBox();
        finL = new javax.swing.JSpinner();
        inicioM = new javax.swing.JSpinner();
        finM = new javax.swing.JSpinner();
        martes = new javax.swing.JCheckBox();
        inicioX = new javax.swing.JSpinner();
        miercoles = new javax.swing.JCheckBox();
        finX = new javax.swing.JSpinner();
        finJ = new javax.swing.JSpinner();
        inicioJ = new javax.swing.JSpinner();
        jueves = new javax.swing.JCheckBox();
        viernes = new javax.swing.JCheckBox();
        inicioV = new javax.swing.JSpinner();
        finV = new javax.swing.JSpinner();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cantAlumnos = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        tipoDeAula = new javax.swing.JComboBox<>();
        apellidoNombre = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        tipo = new javax.swing.JLabel();
        info2 = new javax.swing.JLabel();
        text2 = new javax.swing.JTextField();
        info1 = new javax.swing.JLabel();
        text1 = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        emailprofe = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        exitButton1 = new javax.swing.JButton();
        minimizeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        ComboDocente = new javax.swing.JComboBox<>();
        text3 = new javax.swing.JTextField();
        info3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));

        cuatrimestral.setBackground(new java.awt.Color(153, 153, 153));
        cuatrimestral.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cuatrimestral.setText("Cuatrimestral");
        cuatrimestral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatrimestralActionPerformed(evt);
            }
        });

        anual.setBackground(new java.awt.Color(153, 153, 153));
        anual.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        anual.setText("Anual");
        anual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anualActionPerformed(evt);
            }
        });

        primero.setBackground(new java.awt.Color(153, 153, 153));
        primero.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        primero.setText("1°");
        primero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primeroActionPerformed(evt);
            }
        });

        segundo.setBackground(new java.awt.Color(153, 153, 153));
        segundo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        segundo.setText("2°");
        segundo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                segundoActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel10.setText("Hora de inicio:");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel11.setText("Hora de fin:");

        inicioL.setModel(new javax.swing.SpinnerListModel(new String[] {"07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15"}));
        inicioL.setEnabled(false);
        inicioL.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inicioLStateChanged(evt);
            }
        });

        lunes.setBackground(new java.awt.Color(153, 153, 153));
        lunes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lunes.setText("Lunes");
        lunes.setEnabled(false);
        lunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lunesActionPerformed(evt);
            }
        });

        finL.setModel(new javax.swing.SpinnerListModel(new String[] {"07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45"}));
        finL.setEnabled(false);
        finL.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                finLStateChanged(evt);
            }
        });

        inicioM.setModel(new javax.swing.SpinnerListModel(new String[] {"07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15"}));
        inicioM.setEnabled(false);
        inicioM.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inicioMStateChanged(evt);
            }
        });

        finM.setModel(new javax.swing.SpinnerListModel(new String[] {"07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45"}));
        finM.setEnabled(false);
        finM.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                finMStateChanged(evt);
            }
        });

        martes.setBackground(new java.awt.Color(153, 153, 153));
        martes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        martes.setText("Martes");
        martes.setEnabled(false);
        martes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                martesActionPerformed(evt);
            }
        });

        inicioX.setModel(new javax.swing.SpinnerListModel(new String[] {"07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15"}));
        inicioX.setEnabled(false);
        inicioX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inicioXStateChanged(evt);
            }
        });

        miercoles.setBackground(new java.awt.Color(153, 153, 153));
        miercoles.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        miercoles.setText("Miércoles");
        miercoles.setEnabled(false);
        miercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miercolesActionPerformed(evt);
            }
        });

        finX.setModel(new javax.swing.SpinnerListModel(new String[] {"07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45"}));
        finX.setEnabled(false);
        finX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                finXStateChanged(evt);
            }
        });

        finJ.setModel(new javax.swing.SpinnerListModel(new String[] {"07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45"}));
        finJ.setEnabled(false);
        finJ.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                finJStateChanged(evt);
            }
        });

        inicioJ.setModel(new javax.swing.SpinnerListModel(new String[] {"07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15"}));
        inicioJ.setEnabled(false);
        inicioJ.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inicioJStateChanged(evt);
            }
        });

        jueves.setBackground(new java.awt.Color(153, 153, 153));
        jueves.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jueves.setText("Jueves");
        jueves.setEnabled(false);
        jueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juevesActionPerformed(evt);
            }
        });

        viernes.setBackground(new java.awt.Color(153, 153, 153));
        viernes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        viernes.setText("Viernes");
        viernes.setEnabled(false);
        viernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viernesActionPerformed(evt);
            }
        });

        inicioV.setModel(new javax.swing.SpinnerListModel(new String[] {"07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15"}));
        inicioV.setEnabled(false);
        inicioV.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inicioVStateChanged(evt);
            }
        });

        finV.setModel(new javax.swing.SpinnerListModel(new String[] {"07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45"}));
        finV.setEnabled(false);
        finV.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                finVStateChanged(evt);
            }
        });

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));

        aceptar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file.png"))); // NOI18N
        jLabel4.setText("Reserva Periódica");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel5.setText("Cantidad de Alumnos:");

        cantAlumnos.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        cantAlumnos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cantAlumnosFocusGained(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel6.setText("Tipo de Aula:");

        tipoDeAula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Multimedios", "Informática", "Sin Recursos Adicionales" }));

        apellidoNombre.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        apellidoNombre.setText("Apellido y nombre:");

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

        tipo.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        tipo.setText("Tipo:");

        info2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        info2.setText("Información:");

        info1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        info1.setText("Información:");

        email.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        email.setText("E-mail:");

        emailprofe.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        emailprofe.setText("email");

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));

        exitButton1.setBackground(new java.awt.Color(55, 64, 70));
        exitButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/closed.png"))); // NOI18N
        exitButton1.setBorder(null);
        exitButton1.setBorderPainted(false);
        exitButton1.setContentAreaFilled(false);
        exitButton1.setFocusPainted(false);
        exitButton1.setFocusable(false);
        exitButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButton1MouseExited(evt);
            }
        });
        exitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton1ActionPerformed(evt);
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

        ComboDocente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  ", "Docente 1", "Docente 2", "Docente 3" }));
        ComboDocente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboDocenteItemStateChanged(evt);
            }
        });

        info3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        info3.setText("Información:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lunes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(finL)
                            .addComponent(inicioL, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(martes, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(miercoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(finM, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(finX))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(inicioM, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inicioX)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jueves, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(viernes, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(inicioJ, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inicioV, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(finJ, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(finV, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator10)
                            .addComponent(jSeparator5)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(cuatrimestral)
                                .addGap(78, 78, 78)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(primero)
                                            .addComponent(segundo))))
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)
                                .addComponent(anual))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel4)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(285, 285, 285))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(tipo)
                                    .addComponent(info2)
                                    .addComponent(apellidoNombre)
                                    .addComponent(email)
                                    .addComponent(info1)
                                    .addComponent(info3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tipoDeAula, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailprofe)
                                        .addComponent(text2)
                                        .addComponent(text1)
                                        .addComponent(comboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ComboDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(text3))
                                    .addComponent(cantAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(minimizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton))
                    .addComponent(exitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(anual))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(cuatrimestral))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(primero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(segundo))
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(martes)
                    .addComponent(lunes)
                    .addComponent(miercoles)
                    .addComponent(jueves)
                    .addComponent(viernes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(inicioM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inicioX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inicioJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inicioV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inicioL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cantAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipoDeAula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoNombre)
                    .addComponent(ComboDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(emailprofe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(info1)
                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(info2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(info3)
                    .addComponent(text3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboDocenteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ComboDocenteFocusGained

    }//GEN-LAST:event_ComboDocenteFocusGained

    private void ComboDocenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboDocenteItemStateChanged
        String mailDoc=gd.getDocenteEmail(ComboDocente.getSelectedItem().toString());
        if(mailDoc.isEmpty() || ComboDocente.getSelectedIndex()==0){
            emailprofe.setText("Seleccione un docente de la lista");
        }else{
            emailprofe.setText(mailDoc);
        }
    }//GEN-LAST:event_ComboDocenteItemStateChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        RegistroDeReserva rdr = new RegistroDeReserva(b);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        // TODO add your handling code here:
        backButton.setContentAreaFilled(false);
    }//GEN-LAST:event_backButtonMouseExited

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        // TODO add your handling code here:
        backButton.setContentAreaFilled(true);
    }//GEN-LAST:event_backButtonMouseEntered

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

    private void exitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitButton1ActionPerformed

    private void exitButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButton1MouseExited
        // TODO add your handling code here:
        exitButton1.setContentAreaFilled(false);
    }//GEN-LAST:event_exitButton1MouseExited

    private void exitButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButton1MouseEntered
        // TODO add your handling code here:
        exitButton1.setContentAreaFilled(true);
    }//GEN-LAST:event_exitButton1MouseEntered

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

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

    
    public HashMap<String, ArrayList<String>> obtenerReservas(){
        HashMap<String, ArrayList<String>> reservas= new HashMap();
        ArrayList <String> horas= new ArrayList();
        if (this.lunes.isSelected()){
            horas.clear();
            horas.add(this.inicioL.getValue().toString());
            horas.add(this.finL.getValue().toString());
            reservas.put("LUNES", horas);
            
        }
        if (this.martes.isSelected()){
            horas.clear();
            horas.add(this.inicioM.getValue().toString());
            horas.add(this.finM.getValue().toString());
            reservas.put("MARTES", horas);

        }
        if (this.miercoles.isSelected()){
            horas.clear();
            horas.add(this.inicioX.getValue().toString());
            horas.add(this.finX.getValue().toString());
            reservas.put("MIÉRCOLES", horas);

        }
        if (this.jueves.isSelected()){
            horas.clear();
            horas.add(this.inicioJ.getValue().toString());
            horas.add(this.finJ.getValue().toString());
            reservas.put("JUEVES", horas);

        }
        if (this.viernes.isSelected()){
            horas.clear();
            horas.add(this.inicioV.getValue().toString());
            horas.add(this.finV.getValue().toString());
            reservas.put("VIERNES", horas);
        }
        return reservas;
        
    }
    public Periodo obtenerPeriodo(){
        if(cuatrimestral.isSelected() && primero.isSelected()){
            return Periodo.PRIMERC;
        }
        if(cuatrimestral.isSelected() && segundo.isSelected()){
            return Periodo.SEGUNDOC;
        }
        if(anual.isSelected()){
            return Periodo.ANUAL;
        }
        return null;
    }
    
    
    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if(!selecOption()){
            ErrorSeleccPeriodo esp = new ErrorSeleccPeriodo();
            esp.setVisible(true);
        }else{
            if(!(lunes.isSelected() || martes.isSelected() || miercoles.isSelected() || jueves.isSelected() || viernes.isSelected())){
                ErrorSeleccDia esd = new ErrorSeleccDia();
                esd.setVisible(true);
            }else{
                if(cantAlumnos.getValue().equals(0)){
                    ErrorValueCero evc = new ErrorValueCero();
                    evc.setVisible(true);
                }else{
                    if(ComboDocente.getSelectedItem().toString().equals("Seleccione un docente de la lista")){
                        ErrorSeleccDocente esd = new ErrorSeleccDocente();
                        esd.setVisible(true);
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
        }
    }//GEN-LAST:event_aceptarActionPerformed
    public boolean selecOption(){
        if(cuatrimestral.isSelected()){
            if(primero.isSelected() || segundo.isSelected()){
                return true;
            }else{
                return false;
            }
        }else{
            if(anual.isSelected()){
                return true;
            }else{
                return false;
            }
        }
    }
    
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
        if(this.verificarCampos()){
            Docente doc = docentes.get(this.ComboDocente.getSelectedIndex()-1);
            Actividad act = this.getActividad(this.text1.getText().substring(0, this.text1.getText().length()-1));
            HashMap<String, ArrayList<String>> r= this.obtenerReservas();
            List<Integer> contador = new ArrayList();
            for (HashMap.Entry<String, ArrayList<String>> entry : r.entrySet()){
                List <Aula> aulas = this.gdr.validarPeriodica(entry.getKey(), entry.getValue().get(0),entry.getValue().get(1) ,Integer.parseInt(this.cantAlumnos.getValue().toString()),this.tipoDeAula.getSelectedItem().toString(), this.obtenerPeriodo());
                RegistroPeriodica esta = this;
                this.setEnabled(false);
                this.setAlwaysOnTop(true);
                if (aulas!=null){
                    AulasDisponibles aulasd = new AulasDisponibles(entry.getKey(), entry.getValue().get(0), entry.getValue().get(1), this.obtenerPeriodo(), aulas,this.gdr,this.b, act, doc, Integer.parseInt(this.cantAlumnos.getValue().toString()),this, r.size(),contador);
                }else{
                    ErrorNoExisteAula enea = new ErrorNoExisteAula(entry.getKey(), entry.getValue().get(0), entry.getValue().get(1), this.obtenerPeriodo(), aulas,this.gdr,this.b, act, doc, Integer.parseInt(this.cantAlumnos.getValue().toString()),this, r.size(),contador);
                }
            }
        }
    }
    private boolean verificarCampos(){
        switch(comboTipo.getSelectedItem().toString()){
            case "Curso":
               return (this.curso.contains(this.text1.getText().substring(0, this.text1.getText().length()-1)));
            case "Seminario":
                return (this.sem.contains(this.text1.getText().substring(0, this.text1.getText().length()-1)) && this.themes.contains(this.text2.getText().substring(0, this.text2.getText().length()-1)));
            case "Carrera de grado":
                return (this.carr.contains(this.text1.getText().substring(0, this.text1.getText().length()-1)) && this.com.contains(this.text3.getText().substring(0, this.text3.getText().length()-1)));
            default:
                return false;
        }
    }
    
    private void viernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viernesActionPerformed
        if (!this.viernes.isSelected()){
            this.inicioV.setEnabled(false);
            this.finV.setEnabled(false);
        }else{
            this.inicioV.setEnabled(true);
            this.finV.setEnabled(true);
        }
    }//GEN-LAST:event_viernesActionPerformed

    private void juevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juevesActionPerformed
        if (!this.jueves.isSelected()){
            this.inicioJ.setEnabled(false);
            this.finJ.setEnabled(false);
        }else{
            this.inicioJ.setEnabled(true);
            this.finJ.setEnabled(true);
        }
    }//GEN-LAST:event_juevesActionPerformed

    private void miercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miercolesActionPerformed
        if (!this.miercoles.isSelected()){
            this.inicioX.setEnabled(false);
            this.finX.setEnabled(false);
        }else{
            this.inicioX.setEnabled(true);
            this.finX.setEnabled(true);
        }
    }//GEN-LAST:event_miercolesActionPerformed

    private void martesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_martesActionPerformed
        if (!this.martes.isSelected()){
            this.inicioM.setEnabled(false);
            this.finM.setEnabled(false);
        }else{
            this.inicioM.setEnabled(true);
            this.finM.setEnabled(true);
        }
    }//GEN-LAST:event_martesActionPerformed

    private void lunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lunesActionPerformed
        if (!this.lunes.isSelected()){
            this.inicioL.setEnabled(false);
            this.finL.setEnabled(false);
        }else{
            this.inicioL.setEnabled(true);
            this.finL.setEnabled(true);
        }
    }//GEN-LAST:event_lunesActionPerformed

    private void segundoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_segundoActionPerformed
        this.lunes.setEnabled(true);
        this.martes.setEnabled(true);
        this.miercoles.setEnabled(true);
        this.jueves.setEnabled(true);
        this.viernes.setEnabled(true);
    }//GEN-LAST:event_segundoActionPerformed

    private void primeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primeroActionPerformed
        this.lunes.setEnabled(true);
        this.martes.setEnabled(true);
        this.miercoles.setEnabled(true);
        this.jueves.setEnabled(true);
        this.viernes.setEnabled(true);
    }//GEN-LAST:event_primeroActionPerformed

    private void anualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anualActionPerformed
        this.primero.setEnabled(false);
        this.segundo.setEnabled(false);
        this.lunes.setEnabled(true);
        this.martes.setEnabled(true);
        this.miercoles.setEnabled(true);
        this.jueves.setEnabled(true);
        this.viernes.setEnabled(true);
    }//GEN-LAST:event_anualActionPerformed

    private void cuatrimestralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatrimestralActionPerformed
        this.primero.setEnabled(true);
        this.segundo.setEnabled(true);
    }//GEN-LAST:event_cuatrimestralActionPerformed

    private void cantAlumnosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantAlumnosFocusGained

    }//GEN-LAST:event_cantAlumnosFocusGained

    private void inicioLStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inicioLStateChanged
        this.validarSpinnerInicio("LUNES", inicioL);
        this.finLStateChanged(evt);
    }//GEN-LAST:event_inicioLStateChanged

    private void finLStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_finLStateChanged
        Object[] valoresPrevios = this.validarSpinerFin(prevValInL, prevValFinL, inicioL, finL);
        this.prevValInL=valoresPrevios[0];
        this.prevValFinL=valoresPrevios[1];
    }//GEN-LAST:event_finLStateChanged

    private void inicioMStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inicioMStateChanged
        this.validarSpinnerInicio("MARTES", inicioM);
        this.finMStateChanged(evt);
    }//GEN-LAST:event_inicioMStateChanged

    private void finMStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_finMStateChanged
        Object[] valoresPrevios = this.validarSpinerFin(prevValInM, prevValFinM, inicioM, finM);
        this.prevValInM=valoresPrevios[0];
        this.prevValFinM=valoresPrevios[1];
    }//GEN-LAST:event_finMStateChanged

    private void inicioXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inicioXStateChanged
        this.validarSpinnerInicio("MIÉRCOLES", inicioX);
        this.finXStateChanged(evt);
    }//GEN-LAST:event_inicioXStateChanged

    private void finXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_finXStateChanged
        Object[] valoresPrevios = this.validarSpinerFin(prevValInX, prevValFinX, inicioX, finX);
        this.prevValInX=valoresPrevios[0];
        this.prevValFinX=valoresPrevios[1];
    }//GEN-LAST:event_finXStateChanged

    private void inicioJStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inicioJStateChanged
        this.validarSpinnerInicio("JUEVES", inicioJ);
        this.finJStateChanged(evt);
    }//GEN-LAST:event_inicioJStateChanged

    private void finJStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_finJStateChanged
        Object[] valoresPrevios = this.validarSpinerFin(prevValInJ, prevValFinJ, inicioJ, finJ);
        this.prevValInJ=valoresPrevios[0];
        this.prevValFinJ=valoresPrevios[1];
    }//GEN-LAST:event_finJStateChanged

    private void inicioVStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inicioVStateChanged
        this.validarSpinnerInicio("VIERNES", inicioV);
        this.finVStateChanged(evt);
    }//GEN-LAST:event_inicioVStateChanged

    private void finVStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_finVStateChanged
        Object[] valoresPrevios = this.validarSpinerFin(prevValInV, prevValFinV, inicioV, finV);
        this.prevValInV=valoresPrevios[0];
        this.prevValFinV=valoresPrevios[1];
    }//GEN-LAST:event_finVStateChanged

    private void validarSpinnerInicio(String dia, JSpinner hora_inicio){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String seleccionada = sdf.format(this.gdr.getFechaSegunDia(dia));
        String hoy = sdf.format(today);
        if (hoy.equals(seleccionada)){
            sdf = new SimpleDateFormat("HH:mm");
            Date h_i = null;
            try {
                h_i = sdf.parse(hora_inicio.getValue().toString());
                Date hora_hoy = sdf.parse(today.getHours() + ":" + today.getMinutes());
                while(h_i.before(hora_hoy)){
                    hora_inicio.setValue(hora_inicio.getNextValue());
                    h_i = sdf.parse(hora_inicio.getValue().toString());
                }
            } catch (ParseException ex) {
                Logger.getLogger(RegistroEsporadica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Object[] validarSpinerFin(Object prevValIn, Object prevValFin, JSpinner hora_inicio, JSpinner hora_fin){
        Object[] valoresPrevios = new Object[2];
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date h_f, h_i;
        try {
            h_f = sdf.parse(hora_fin.getValue().toString());
            h_i = sdf.parse(hora_inicio.getValue().toString());
            if (h_f.before(h_i) || h_f.equals(h_i)){
                hora_fin.setValue(hora_inicio.getNextValue());
            }
            int aux = h_f.getMinutes() - h_i.getMinutes();
            if (prevValFin.equals(hora_fin.getNextValue())){ //DECREMENTE EL SPINNER
                if (aux%30!=0){
                    if(!hora_fin.getPreviousValue().equals(hora_inicio.getValue())){
                        hora_fin.setValue(hora_fin.getPreviousValue());
                    }else{
                        hora_fin.setValue(hora_fin.getNextValue());
                    }
                }
            }else{
                if (aux%30!=0){
                    if (prevValIn.equals(hora_inicio.getNextValue())){
                        hora_fin.setValue(hora_fin.getPreviousValue());
                    }else{
                        hora_fin.setValue(hora_fin.getNextValue());
                    }
                }
            }
        } catch (ParseException ex) {
            System.out.println("Error parseo.");
        }
        valoresPrevios[0]=hora_inicio.getValue();
        valoresPrevios[1]=hora_fin.getValue();
        return valoresPrevios;
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboDocente;
    private javax.swing.JButton aceptar;
    private javax.swing.JRadioButton anual;
    private javax.swing.JLabel apellidoNombre;
    private javax.swing.JButton backButton;
    private javax.swing.JSpinner cantAlumnos;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JRadioButton cuatrimestral;
    private javax.swing.JLabel email;
    private javax.swing.JLabel emailprofe;
    private javax.swing.JButton exitButton1;
    private javax.swing.JSpinner finJ;
    private javax.swing.JSpinner finL;
    private javax.swing.JSpinner finM;
    private javax.swing.JSpinner finV;
    private javax.swing.JSpinner finX;
    private javax.swing.JLabel info1;
    private javax.swing.JLabel info2;
    private javax.swing.JLabel info3;
    private javax.swing.JSpinner inicioJ;
    private javax.swing.JSpinner inicioL;
    private javax.swing.JSpinner inicioM;
    private javax.swing.JSpinner inicioV;
    private javax.swing.JSpinner inicioX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JCheckBox jueves;
    private javax.swing.JCheckBox lunes;
    private javax.swing.JCheckBox martes;
    private javax.swing.JCheckBox miercoles;
    private javax.swing.JButton minimizeButton;
    private javax.swing.JRadioButton primero;
    private javax.swing.JRadioButton segundo;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    private javax.swing.JTextField text3;
    private javax.swing.JLabel tipo;
    private javax.swing.JComboBox<String> tipoDeAula;
    private javax.swing.JCheckBox viernes;
    // End of variables declaration//GEN-END:variables
}
