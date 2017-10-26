/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Admin;
import Modelo.Bedel;
import Modelo.Clave;
import Modelo.Politicascontrasenia;
import Modelo.Usuario;
import Vista.ConfirmacionGuardarCambios;
import Vista.ErrorBbdd;
import Vista.OpcionesDelAdministrador;
import Vista.RegistrarBedel;
import Vista.RegistroExitoso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPasswordField;

/**
 *
 * @author juani
 */
public class GestorDeBedel {

    Politicascontrasenia pc;
    
    public GestorDeBedel() {
        try{
        PoliticasContraseniaDAO pcd = new PoliticasContraseniaDAO();
        this.pc = pcd.read();
        }catch(Exception e){
            e.printStackTrace();
            ErrorBbdd eb = new ErrorBbdd();
        }
    }
    
    public void seleccionarOpcion(){

    }
    
    public Politicascontrasenia getPoliticas(){
        return pc;
    }

    public boolean verificarOpcion(Object opc){
        return false;
    }

    public void confirmarEliminacion(){

    }

    public void cancelarModificacion(){

    }

    public boolean validarContrasenia(String nom, String ap, int id, String pass){ //NO SE USA
        return false;
    }

    public void notificarError(){

    }

    public void guardarModificacion(){

    }

    public String validar(String username, String name, String last, String email, String id, String turno, JPasswordField pass1, JPasswordField pass2){
        String contra="", contra2="";
        char a;
        for (int i=0; i<pass1.getPassword().length; i++){
            a= pass1.getPassword()[i];
            contra = contra + a;
        }
        for (int i=0; i<pass2.getPassword().length; i++){
            a= pass2.getPassword()[i];
            contra2 = contra2 + a;
        }
        int idAux = parseInt(id);
        if (this.validarPass(contra)){
            if (this.matchPass(contra, contra2)){
                List lista = new ArrayList();
                try{
                UsuarioDAO ud = new UsuarioDAO();
                lista = ud.readAllUsernames();
                }catch(Exception e){
                    e.printStackTrace();
                    ErrorBbdd eb = new ErrorBbdd();
                }
                if (!lista.isEmpty()){
                    for (int i=0; i<lista.size(); i++){
                        if (lista.get(i).equals(username.toUpperCase()))
                            return "errorusername";
                    }
                }
                try{
                UsuarioDAO ud = new UsuarioDAO();
                lista = ud.readAll();
                }catch(Exception e){
                    e.printStackTrace();
                    ErrorBbdd eb = new ErrorBbdd();
                }
                if(!lista.isEmpty()){
                    for (int i=0; i<lista.size(); i++){
                        if (lista.get(i).equals(idAux))
                            return "coincidencia";
                    }
                }
            }else{
                return "confirmacion";
            }
        }else{
            return "politicas";
        }
        return "exito";
    }

    public boolean validarPass(String pass){
        boolean flag = false;
        if (pass.length()>=pc.getLongMin()){
            flag = true;
            if (pc.isSignosEspeciales()){
                boolean flagAux = false;
                for (int i=0; i<pass.length(); i++){
                    if (pass.charAt(i)=='$' || pass.charAt(i)=='%' || pass.charAt(i)=='&' || pass.charAt(i)=='*' || pass.charAt(i)=='@' || pass.charAt(i)=='#' || pass.charAt(i)=='(' || pass.charAt(i)==')'){
                        flagAux = true;
                    }
                }
                if (!flagAux){
                    return false;
                }if (pc.isDigito()){
                    flagAux = false;
                    for (int i=0; i<pass.length(); i++){
                        if (pass.charAt(i)>=48 && pass.charAt(i)<=57){
                            flagAux = true;
                        }
                    }
                    if (!flagAux){
                        return false;
                    }if(pc.isLetraMay()){
                        flagAux = false;
                        for (int i=0; i<pass.length(); i++){
                            if (pass.charAt(i)>=48 && pass.charAt(i)<=57){
                                flagAux = true;
                            }
                        }
                        if (!flagAux){
                            return false;
                        }if(!pc.isPassIgual()){
                            flagAux = true;
                            List claves = new ArrayList();
                            try{
                            UsuarioDAO ud = new UsuarioDAO();
                            claves = ud.getAllClaves();
                            }catch(Exception e){
                                e.printStackTrace();
                                ErrorBbdd eb = new ErrorBbdd();
                            }
                            for (int i=0; i<claves.size(); i++){
                                if (claves.get(i).equals(pass)){
                                    flagAux = false;
                                }
                            }
                            return flagAux;
                        }
                    }
                }
            }
        }
        return flag;
    }

    public void eliminarBedel(Bedel b){

    }

    public boolean matchPass(String ap, String pass){
        return ap.equals(pass);
    }

    public void modificarDatosBedel(Bedel b){

    }

    public void registrarBedel(Clave c, Usuario u, String turno, String email){
        try{
            ClaveDAO cd = new ClaveDAO();
            UsuarioDAO ud = new UsuarioDAO();
            cd.create(c);
            ud.create(u);
            cd.update(c, u);
            Bedel b = new Bedel(u, turno, email);
            ud.create(b);
        }catch(Exception e){
            e.printStackTrace();
            ErrorBbdd eb = new ErrorBbdd();
        }
    }

    public boolean camposVacios(String username, String name, String last, String email, String id, String turno, JPasswordField pass1, JPasswordField pass2){
        String contra="", contra2="";
        char a;
        for (int i=0; i<pass2.getPassword().length; i++){
            a= pass2.getPassword()[i];
            contra = contra + a;
        }
        for (int i=0; i<pass1.getPassword().length; i++){
            a= pass1.getPassword()[i];
            contra2 = contra2 + a;
        }
        if (!(name.isEmpty() && username.isEmpty() && last.isEmpty() && email.isEmpty() && turno.isEmpty() && id.isEmpty() && contra.equals("") && contra2.equals(""))){
            return false;
        }
        return true;
    }
    
    public boolean camposLlenos(String username, String name, String last, String email, String id, String turno, JPasswordField pass1, JPasswordField pass2){
        if (!this.camposVacios(username, name, last, email, id, turno, pass1, pass2)){
            String contra="", contra2="";
            char a;
            for (int i=0; i<pass2.getPassword().length; i++){
                a= pass2.getPassword()[i];
                contra = contra + a;
            }
            for (int i=0; i<pass1.getPassword().length; i++){
                a= pass1.getPassword()[i];
                contra2 = contra2 + a;
            }
            return !name.isEmpty() && !username.isEmpty() && !last.isEmpty() && !email.isEmpty() && !turno.isEmpty() && !id.isEmpty() && !contra.equals("") && !contra2.equals("");
        }else{
            return false;
        }
    }
}