package Modelo;
// Generated Oct 22, 2017 10:44:08 PM by Hibernate Tools 4.3.1



/**
 * Seminario generated by hbm2java
 */
public class Seminario extends Actividad implements java.io.Serializable {


     private int actividadId;
     private Actividad actividad;
     private String tema;

    public Seminario() {
    }

    public Seminario(Actividad actividad, String tema) {
       this.actividad = actividad;
       this.tema = tema;
    }
   
    public Integer getActividadId() {
        return this.actividadId;
    }
    
    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }
    public Actividad getActividad() {
        return this.actividad;
    }
    
    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    public String getTema() {
        return this.tema;
    }
    
    public void setTema(String tema) {
        this.tema = tema;
    }




}


