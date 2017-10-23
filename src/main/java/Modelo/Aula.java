package Modelo;
// Generated Oct 22, 2017 10:44:08 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Aula generated by hbm2java
 */
public class Aula  implements java.io.Serializable {


     private Integer aulaId;
     private String nombre;
     private Integer capacidad;
     private Integer piso;
     private String estado;
     private Boolean aireacond;
     private String pizarron;
     private Integer ventiladores;
     private Set diareservas = new HashSet(0);
     private Aulasra aulasra;
     private Aulainformatica aulainformatica;
     private Aulamultimedios aulamultimedios;

    public Aula() {
    }

    public Aula(String nombre, Integer capacidad, Integer piso, String estado, Boolean aireacond, String pizarron, Integer ventiladores, Set diareservas, Aulasra aulasra, Aulainformatica aulainformatica, Aulamultimedios aulamultimedios) {
       this.nombre = nombre;
       this.capacidad = capacidad;
       this.piso = piso;
       this.estado = estado;
       this.aireacond = aireacond;
       this.pizarron = pizarron;
       this.ventiladores = ventiladores;
       this.diareservas = diareservas;
       this.aulasra = aulasra;
       this.aulainformatica = aulainformatica;
       this.aulamultimedios = aulamultimedios;
    }
   
    public Integer getAulaId() {
        return this.aulaId;
    }
    
    public void setAulaId(Integer aulaId) {
        this.aulaId = aulaId;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCapacidad() {
        return this.capacidad;
    }
    
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    public Integer getPiso() {
        return this.piso;
    }
    
    public void setPiso(Integer piso) {
        this.piso = piso;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Boolean getAireacond() {
        return this.aireacond;
    }
    
    public void setAireacond(Boolean aireacond) {
        this.aireacond = aireacond;
    }
    public String getPizarron() {
        return this.pizarron;
    }
    
    public void setPizarron(String pizarron) {
        this.pizarron = pizarron;
    }
    public Integer getVentiladores() {
        return this.ventiladores;
    }
    
    public void setVentiladores(Integer ventiladores) {
        this.ventiladores = ventiladores;
    }
    public Set getDiareservas() {
        return this.diareservas;
    }
    
    public void setDiareservas(Set diareservas) {
        this.diareservas = diareservas;
    }
    public Aulasra getAulasra() {
        return this.aulasra;
    }
    
    public void setAulasra(Aulasra aulasra) {
        this.aulasra = aulasra;
    }
    public Aulainformatica getAulainformatica() {
        return this.aulainformatica;
    }
    
    public void setAulainformatica(Aulainformatica aulainformatica) {
        this.aulainformatica = aulainformatica;
    }
    public Aulamultimedios getAulamultimedios() {
        return this.aulamultimedios;
    }
    
    public void setAulamultimedios(Aulamultimedios aulamultimedios) {
        this.aulamultimedios = aulamultimedios;
    }




}


