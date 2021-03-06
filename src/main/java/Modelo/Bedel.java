package Modelo;
// Generated Oct 23, 2017 11:09:42 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Bedel generated by hbm2java
 */
public class Bedel extends Usuario implements java.io.Serializable {


     private Integer userId;
     private Usuario usuario;
     private String turno;
     private String email;
     private Set reservas = new HashSet(0);

    public Bedel() {
    }

	
    public Bedel(Usuario usuario, String email) {
        this.usuario = usuario;
        this.email = email;
    }
    
    public Bedel(Usuario usuario, String turno, String email) {
       this.userId = usuario.getUserId();
       this.usuario = usuario;
       this.turno = turno;
       this.email = email;
    }
    
    public Bedel (int a){
        Clave c = new Clave(new Politicascontrasenia(), "#");
        this.usuario = new Usuario(0, c, "#", "#", "#");
        this.userId = 0;
        this.turno = "#";
        this.email = "#";
    }
    
    public Bedel(Usuario usuario, String turno, String email, Set reservas) {
       this.usuario = usuario;
       this.turno = turno;
       this.email = email;
       this.reservas = reservas;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getTurno() {
        return this.turno;
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getReservas() {
        return this.reservas;
    }
    
    public void setReservas(Set reservas) {
        this.reservas = reservas;
    }




}


