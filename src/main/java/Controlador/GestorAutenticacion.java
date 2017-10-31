/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Admin;
import Modelo.Bedel;
import Modelo.Clave;
import Modelo.Usuario;
import Vista.ErrorBbdd;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPasswordField;

/**
 *
 * @author juani
 */
public class GestorAutenticacion {

    UsuarioDAO ud = new UsuarioDAO();
    
    public GestorAutenticacion() {
    }
    
//    public GestorAutenticacion(List<Usuario> uap) {
//        this.uap=uap;
//    }

    public Usuario autenticarUsuario(String user, String contra){
        if (user.equals("bedel") && contra.equals("bedel")){
            Clave c = new Clave("bedel");
            Usuario us = new Usuario(1, c, "bedel", "bedel", "bedel");
            Bedel b = new Bedel (us, "Mañana", "asdasd@me.com");
            return b;
        }else{
            if(user.equals("admin") && contra.equals("admin")){
                Clave c = new Clave("admin");
                Usuario us = new Usuario(1, c, "admin", "admin", "admin");
                Admin adm = new Admin (us);
                return adm;
            }else{
                return ud.exists(user, contra);
            }
        }
    }

}
