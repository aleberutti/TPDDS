package Modelo;
// Generated Oct 23, 2017 11:09:42 PM by Hibernate Tools 4.3.1



/**
 * Catedra generated by hbm2java
 */
public class Catedra extends Actividad implements java.io.Serializable {


     private int actividadId;
     private Actividad actividad;
     private String carrera;
     private String comision;

    public Catedra() {
    }

    public Catedra(Actividad actividad, String carrera, String comision) {
       this.actividad = actividad;
       this.carrera = carrera;
       this.comision = comision;
    }
   
    @Override
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
    public String getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public String getComision() {
        return this.comision;
    }
    
    public void setComision(String comision) {
        this.comision = comision;
    }




}

