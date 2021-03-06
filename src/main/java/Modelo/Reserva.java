package Modelo;
// Generated Oct 23, 2017 11:09:42 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Reserva generated by hbm2java
 */
public class Reserva  implements java.io.Serializable {


     private Integer reservaId;
     private Actividad actividad;
     private Bedel bedel;
     private Docente docente;
     private int cantAlumnos;
     private Date fechaSolicitud;
     private String periodo;
     private Periodica periodica;
     private Set diareservas = new HashSet(0);
     private Esporadica esporadica;

    public Reserva() {
    }

	
    public Reserva(Actividad actividad, Bedel bedel, Docente docente, int cantAlumnos, Date fechaSolicitud, String periodo) {
        this.actividad = actividad;
        this.bedel = bedel;
        this.docente = docente;
        this.cantAlumnos = cantAlumnos;
        this.fechaSolicitud = fechaSolicitud;
        this.periodo = periodo;
    }
    
    public Reserva(Actividad actividad, Bedel bedel, Docente docente, int cantAlumnos, Date fechaSolicitud, Set diareservas) {
        this.actividad = actividad;
        this.bedel = bedel;
        this.docente = docente;
        this.cantAlumnos = cantAlumnos;
        this.fechaSolicitud = fechaSolicitud;
        this.diareservas = diareservas;
        this.periodo = "N/A";
    }
    
    public Reserva(Actividad actividad, Bedel bedel, Docente docente, int cantAlumnos, Date fechaSolicitud, Set diareservas, String periodo) {
        this.actividad = actividad;
        this.bedel = bedel;
        this.docente = docente;
        this.cantAlumnos = cantAlumnos;
        this.fechaSolicitud = fechaSolicitud;
        this.diareservas = diareservas;
        this.periodo = periodo;
    }
    
    public Reserva(Actividad actividad, Bedel bedel, Docente docente, int cantAlumnos, Date fechaSolicitud, String periodo, Periodica periodica, Set diareservas, Esporadica esporadica) {
       this.actividad = actividad;
       this.bedel = bedel;
       this.docente = docente;
       this.cantAlumnos = cantAlumnos;
       this.fechaSolicitud = fechaSolicitud;
       this.periodo = periodo;
       this.periodica = periodica;
       this.diareservas = diareservas;
       this.esporadica = esporadica;
    }
   
    public Integer getReservaId() {
        return this.reservaId;
    }
    
    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }
    public Actividad getActividad() {
        return this.actividad;
    }
    
    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    public Bedel getBedel() {
        return this.bedel;
    }
    
    public void setBedel(Bedel bedel) {
        this.bedel = bedel;
    }
    public Docente getDocente() {
        return this.docente;
    }
    
    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    public int getCantAlumnos() {
        return this.cantAlumnos;
    }
    
    public void setCantAlumnos(int cantAlumnos) {
        this.cantAlumnos = cantAlumnos;
    }
    public Date getFechaSolicitud() {
        return this.fechaSolicitud;
    }
    
    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    public String getPeriodo() {
        return this.periodo;
    }
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public Periodica getPeriodica() {
        return this.periodica;
    }
    
    public void setPeriodica(Periodica periodica) {
        this.periodica = periodica;
    }
    public Set getDiareservas() {
        return this.diareservas;
    }
    
    public void setDiareservas(Set diareservas) {
        this.diareservas = diareservas;
    }
    public Esporadica getEsporadica() {
        return this.esporadica;
    }
    
    public void setEsporadica(Esporadica esporadica) {
        this.esporadica = esporadica;
    }
  




}


