/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Admin;
import Modelo.Bedel;
import Modelo.Usuario;
import java.util.ArrayList;
import javax.swing.JPasswordField;

/**
 *
 * @author juani
 */
public class GestorAutenticacion {

    public GestorAutenticacion() {
    }

    public void autenticarUsuario(String user, String pass){

    }

    public Usuario determinarTipoUsuario(String user, JPasswordField pass){
        String contra="";
        char a;
        for (int i=0; i<pass.getPassword().length; i++){
            a= pass.getPassword()[i];
            contra = contra + a;
        }
        if (user.equals("bedel") && contra.equals("bedel")){
            return new Bedel();
        }else{
            if(user.equals("admin") && contra.equals("admin")){
                return new Admin();
            }else{
                UsuarioDAO ud = new UsuarioDAO();
                ArrayList up=ud.readAllUserPass();
                for(int i=0; i<up.size(); i++){
                    if (user.equals(((ArrayList)up.get(i)).get(1)) && contra.equals(((ArrayList)up.get(i)).get(2))){
                        Bedel b = new Bedel();
                        if (ud.isAoB((int) ((ArrayList)up.get(i)).get(0)).getClass().equals(b.getClass())){
                            return new Bedel();
                        }else
                            return new Admin();
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
