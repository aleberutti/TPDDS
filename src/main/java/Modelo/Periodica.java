package Modelo;
// Generated Oct 23, 2017 11:09:42 PM by Hibernate Tools 4.3.1



/**
 * Periodica generated by hbm2java
 */
public class Periodica extends Reserva implements java.io.Serializable {


     private Integer reservaId;
     private Reserva reserva;
     private String tipoReservaPeriodica;

    public Periodica() {
    }

    public Periodica(Reserva reserva, String tipoReservaPeriodica) {
       this.reserva = reserva;
       this.tipoReservaPeriodica = tipoReservaPeriodica;
    }
   
    public Integer getReservaId() {
        return this.reservaId;
    }
    
    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }
    public Reserva getReserva() {
        return this.reserva;
    }
    
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public String getTipoReservaPeriodica() {
        return this.tipoReservaPeriodica;
    }
    
    public void setTipoReservaPeriodica(String tipoReservaPeriodica) {
        this.tipoReservaPeriodica = tipoReservaPeriodica;
    }




}


