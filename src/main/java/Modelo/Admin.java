package Modelo;
// Generated Oct 22, 2017 10:44:08 PM by Hibernate Tools 4.3.1



/**
 * Admin generated by hbm2java
 */
public class Admin extends Usuario implements java.io.Serializable {


     private Integer userId;
     private Usuario usuario;

    public Admin() {
    }

    public Admin(Usuario usuario) {
       this.usuario = usuario;
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




}


