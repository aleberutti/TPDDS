package Modelo;
// Generated Oct 22, 2017 10:44:08 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer userId;
     private Clave clave;
     private String nombreUsuario;
     private String nombre;
     private String apellido;
     private Bedel bedel;
     private Set claves = new HashSet(0);
     private Admin admin;

    public Usuario() {
    }
	
    public Usuario(Clave clave, String nombreUsuario, String nombre, String apellido) {
        this.clave = clave;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Usuario(Clave clave, String nombreUsuario, String nombre, String apellido, Bedel bedel, Set claves, Admin admin) {
       this.clave = clave;
       this.nombreUsuario = nombreUsuario;
       this.nombre = nombre;
       this.apellido = apellido;
       this.bedel = bedel;
       this.claves = claves;
       this.admin = admin;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Clave getClave() {
        return this.clave;
    }
    
    public void setClave(Clave clave) {
        this.clave = clave;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Bedel getBedel() {
        return this.bedel;
    }
    
    public void setBedel(Bedel bedel) {
        this.bedel = bedel;
    }
    public Set getClaves() {
        return this.claves;
    }
    
    public void setClaves(Set claves) {
        this.claves = claves;
    }
    public Admin getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }




}


