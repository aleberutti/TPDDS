package Modelo;
// Generated Oct 22, 2017 10:44:08 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Diareserva generated by hbm2java
 */
public class Diareserva  implements java.io.Serializable {


     private Integer diaReservaId;
     private Aula aula;
     private Reserva reserva;
     private String diaSemana;
     private Date fecha;
     private Date horainicio;
     private Date horafin;

    public Diareserva() {
    }

    public Diareserva(Aula aula, Reserva reserva, String diaSemana, Date fecha, Date horainicio, Date horafin) {
       this.aula = aula;
       this.reserva = reserva;
       this.diaSemana = diaSemana;
       this.fecha = fecha;
       this.horainicio = horainicio;
       this.horafin = horafin;
    }
   
    public Integer getDiaReservaId() {
        return this.diaReservaId;
    }
    
    public void setDiaReservaId(Integer diaReservaId) {
        this.diaReservaId = diaReservaId;
    }
    public Aula getAula() {
        return this.aula;
    }
    
    public void setAula(Aula aula) {
        this.aula = aula;
    }
    public Reserva getReserva() {
        return this.reserva;
    }
    
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public String getDiaSemana() {
        return this.diaSemana;
    }
    
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getHorainicio() {
        return this.horainicio;
    }
    
    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }
    public Date getHorafin() {
        return this.horafin;
    }
    
    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }




}


