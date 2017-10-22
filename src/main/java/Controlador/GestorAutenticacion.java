/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Admin;
import Modelo.Bedel;
import Modelo.Usuario;
import Vista.OpcionesDelAdministrador;
import Vista.OpcionesDelBedel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
                }if(user.equals("admin") && contra.equals("admin")){
                    return new Admin();
                }else{
                    return this.notificarError();
                }
    }

    public Usuario notificarError(){
        return null;
    }

}
