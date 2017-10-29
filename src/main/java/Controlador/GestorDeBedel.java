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
//import Vista.ConfirmacionGuardarCambios;
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
    UsuarioDAO ud;
    ClaveDAO cd;
    
    public GestorDeBedel() {
        PoliticasContraseniaDAO pcd = new PoliticasContraseniaDAO();
        try{
            this.pc = pcd.read();
        }catch(Exception e){
            e.printStackTrace();
            ErrorBbdd eb = new ErrorBbdd();
        }
        ud = new UsuarioDAO();
        cd = new ClaveDAO();
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

    public int validar(String username, String email, String id, String contra, String contra2){
        //    0 Correcto
        //    1 errorusername
        //    2 emailInvalido
        //    3 coincidenciaID
        //    4 politicas
        //    5 Confirmacion
        int idAux = parseInt(id);
        Usuario us = new Usuario();
        UsuarioDAO ud = new UsuarioDAO();
        try{
            us = ud.readUsername(username);
        }catch(Exception e){
            e.printStackTrace();
            ErrorBbdd eb = new ErrorBbdd();
        }
        if (!(us == null)){
            return 1;
        }
        if (!email.contains("@") || !email.contains("."))
            return 2;
        try{
            us = ud.read(Usuario.class, idAux);
        }catch(Exception e){
            e.printStackTrace();
            ErrorBbdd eb = new ErrorBbdd();
        }
        if (!(us == null))
            return 3;
        if (!(this.validarPass(contra) == 0)){
            return 4;
        }
        if (!this.matchPass(contra, contra2)){
            return 5;
        }
        return 0;
    }
    
    public Usuario newUser(int id, Clave cl, String username, String name, String last){
        Usuario u = new Usuario(id, cl, username, name, last);
        return u;
    }
    
    public Clave newClave(Politicascontrasenia pc, String clave){
        Clave C = new Clave(pc, clave);
        return C;
    }

    public int validarPass(String pass){
        //    0 Correcta
        //    1 MinLength
        //    2 SignosEspeciales
        //    3 Digito
        //    4 LetraMay
        //    5 Repetida
        boolean flagAux = false;
        if (!(pass.length()>=pc.getLongMin())){
            return 1;
        }
        if (pc.isSignosEspeciales()){
            if (pass.contains("$") || pass.contains("%") || pass.contains("&") || pass.contains("*") || pass.contains("@") || pass.contains("#") || pass.contains("(") || pass.contains(")")){
                flagAux = true;
            }
            if (!flagAux){
                return 2;
            }
        }
        if (pc.isDigito()){
            flagAux = false;
            for (int i=0; i<pass.length(); i++){
                if (pass.charAt(i)>=48 && pass.charAt(i)<=57){
                    flagAux = true;
                }
            }
            if (!flagAux){
                return 3;
            }
        }
        if(pc.isLetraMay()){
            flagAux = false;
            for (int i=0; i<pass.length(); i++){
                if (pass.charAt(i)>=65 && pass.charAt(i)<=90){
                    flagAux = true;
                }
            }
            if (!flagAux){
                return 4;
            }
        }
        if(pc.isPassIgual()){
            Clave rdo = new Clave();
            try{
            ClaveDAO cd = new ClaveDAO();
            rdo = cd.readPass(pass);
            }catch(Exception e){
                e.printStackTrace();
                ErrorBbdd eb = new ErrorBbdd();
            }
            if (!(rdo == null)){
                return 5;
            }
        }
        return 0;
    }

    public void eliminarBedel(Bedel b){

    }

    public boolean matchPass(String ap, String pass){
        return ap.equals(pass);
    }

    public void modificarDatosBedel(Politicascontrasenia pc, String pass, Clave c, String username, String name, String last, Usuario us, String turno, String email, Bedel b){
        if (!(c.getValor().equals(pass) && c.getPoliticascontrasenia().equals(pc))){
            Clave nueva = new Clave(c.getClaveId(), pass, pc, us);
            try{
                cd.update(nueva);
            }catch (Exception e){
                e.printStackTrace();
                ErrorBbdd eb = new ErrorBbdd();
            }
        }
        if (!(us.getNombreUsuario().equals(username) && us.getNombre().equals(name) && us.getApellido().equals(last))){
            Usuario u = new Usuario(us.getUserId(), c, username, name, last);
            try{
            ud.update(u);
            }catch (Exception e){
                e.printStackTrace();
                ErrorBbdd eb = new ErrorBbdd();
            }
        }
        if (!(b.getTurno().equals(turno) && b.getEmail().equals(email))){
            Bedel nuevo = new Bedel(us, turno, email);
            ud.update(nuevo);
        }
        
    }

    public void guardar(Politicascontrasenia pc, String pass, int id, String username, String name, String last, String turno, String email){
        Clave cl = this.newClave(pc, pass);
        Usuario u = this.newUser(id, cl, username, name, last);
        this.registrarBedel(cl, u, turno, email);
    }
    
    public void registrarBedel(Clave c, Usuario u, String turno, String email){
        try{
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

    public boolean camposVacios(String username, String name, String last, String email, String id, String turno, String contra, String contra2){
        return name.isEmpty() && username.isEmpty() && last.isEmpty() && email.isEmpty() && turno.isEmpty() && id.isEmpty() && contra.isEmpty() && contra2.isEmpty();
    }
    
    public boolean camposLlenos(String username, String name, String last, String email, String id, String turno, String contra, String contra2){
        if (!this.camposVacios(username, name, last, email, id, turno, contra, contra2)){
            return !name.isEmpty() && !username.isEmpty() && !last.isEmpty() && !email.isEmpty() && !turno.isEmpty() && !id.isEmpty() && !contra.isEmpty() && !contra2.isEmpty();
        }else{
            return false;
        }
    }
}