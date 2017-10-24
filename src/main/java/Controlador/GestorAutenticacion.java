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

    List uap = new ArrayList();
    UsuarioDAO ud = new UsuarioDAO();
    
    public GestorAutenticacion() {
    }
    
    public GestorAutenticacion(List uap) {
        this.uap=uap;
    }

    public Usuario autenticarUsuario(String user, JPasswordField pass){
        String contra="";
        char a;
        for (int i=0; i<pass.getPassword().length; i++){
            a= pass.getPassword()[i];
            contra = contra + a;
        }
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
                for(int i=0; i<uap.size(); i++){
                    if (user.equals(((ArrayList)uap.get(i)).get(1)) && contra.equals(((ArrayList)uap.get(i)).get(2))){
                        Usuario usObten = ud.isAoB((int) ((ArrayList)uap.get(i)).get(0));
                        return usObten;
                    }else {
                        return this.notificarError();
                    }
                }
            }
        }
        return this.notificarError();
    }

    public Usuario notificarError(){
        return new Usuario();
    }

}
