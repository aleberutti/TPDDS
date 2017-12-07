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
import javax.swing.JOptionPane;
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
    
    public String revertMayus(String str){
        int spaces = 0;
        if (str.contains(" ")){
            String substr = str.substring(0, str.indexOf(" "));
            String rest = str.substring((str.indexOf(" ")+1));
            return substr.substring(0, 1).toUpperCase() + substr.substring(1).toLowerCase() + " " + revertMayus(rest);
        }else{
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
    }
    
    public String ignoreSpaces(String str){
        while (!str.isEmpty() && (str.charAt(0) == ' ')){
            try{
                str = str.substring(1);
            }catch(java.lang.StringIndexOutOfBoundsException e){
                str = "";
            }
        }
        while (!str.isEmpty() && (str.charAt(str.length()-1) == ' ')){
            str = str.substring(0, str.length()-1);
        }
        return str;
    }
    
    public boolean isEnieOAcento(java.awt.event.KeyEvent evt){
        //á = 225
        //é = 233
        //í = 237
        //ó = 243
        //ú = 250
        //Á = 193
        //E = 201
        //Í = 205
        //Ó = 211
        //Ú = 218
        //ñ = 241
        //Ñ = 209
        //' =39
        return (evt.getKeyChar()==225) || (evt.getKeyChar()==233) || (evt.getKeyChar()==237) || (evt.getKeyChar()==225) || (evt.getKeyChar()==243) || (evt.getKeyChar()==250) || (evt.getKeyChar()==241) || (evt.getKeyChar()==193)
                || (evt.getKeyChar()==201) || (evt.getKeyChar()==205) || (evt.getKeyChar()==211) || (evt.getKeyChar()==218) || (evt.getKeyChar()==209) || (evt.getKeyChar()==39);
    }
    
    public List<Bedel> buscarBedel(String apellido, String turno){
        return ud.readBedel(apellido, turno);
    }

    public int validar(String username, String email, String id, String contra, String contra2, Bedel bed){
        //    0 Correcto
        //    1 errorusername
        //    2 emailInvalido
        //    3 coincidenciaID
        //    4 politicas
        //    5 Confirmacion
        int idAux = parseInt(id);
        Usuario us = new Usuario();
        if (bed.getTurno().equals("#") || !username.equals(bed.getUsuario().getNombreUsuario())){
            try{
                us = ud.readUsername(username);
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error en la conexion o username duplicado - "+e.getMessage());
                ErrorBbdd eb = new ErrorBbdd();
            }
            if (!(us == null)){
                return 1;
            }
        }
        if (bed.getTurno().equals("#") || !email.equals(bed.getEmail())){
            if (!email.contains("@") || !email.contains("."))
                return 2;
        }
        if (bed.getTurno().equals("#")){
            try{
                us = ud.read(Usuario.class, idAux);
            }catch(Exception e){
                e.printStackTrace();
                ErrorBbdd eb = new ErrorBbdd();
            }
            if (!(us == null))
                return 3;
        }
        if (bed.getTurno().equals("#") || !contra.equals(bed.getUsuario().getClave().getValor())){
            if (!(this.validarPass(contra, idAux) == 0)){
                return 4;
        }
        }
        if (bed.getTurno().equals("#") || !contra2.equals(bed.getUsuario().getClave().getValor())){
            if (!this.matchPass(contra, contra2)){
                return 5;
            }
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

    public int validarPass(String pass, int ID){
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
            rdo = cd.readPassUsr(pass, ID);
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
        Clave nueva = c;
        Usuario u = us;
        if (!(c.getValor().equals(pass) && c.getPoliticascontrasenia().getPoliticaId().equals(pc.getPoliticaId()))){
            nueva = new Clave(c.getClaveId(), pass, pc, us);
            try{
                cd.create(nueva);
            }catch (Exception e){
                e.printStackTrace();
                ErrorBbdd eb = new ErrorBbdd();
            }
        }
        if (!(us.getNombreUsuario().equals(username) && us.getNombre().equals(name) && us.getApellido().equals(last))){
            u = new Usuario(us.getUserId(), nueva, username, name, last);
            try{
                ud.update(u);
            }catch (Exception e){
                e.printStackTrace();
                ErrorBbdd eb = new ErrorBbdd();
            }
        }else{
            if (!nueva.equals(c)){
                u = new Usuario(us.getUserId(), nueva, username, name, last);
                try{
                    ud.update(u);
                }catch (Exception e){
                    e.printStackTrace();
                    ErrorBbdd eb = new ErrorBbdd();
                }
            }
        }
        if (!(b.getTurno().equals(turno) && b.getEmail().equals(email))){
            Bedel nuevo = new Bedel(u, turno, email);
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