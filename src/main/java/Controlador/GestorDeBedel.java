/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Bedel;
import Modelo.Clave;
import Modelo.Politicascontrasenia;
import Modelo.Usuario;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JPasswordField;
import org.hibernate.Query;

/**
 *
 * @author juani
 */
public class GestorDeBedel {

    public GestorDeBedel() {
    }
    
    public void seleccionarOpcion(){

    }
    
    public Politicascontrasenia getPoliticas(){
        PoliticasContraseniaDAO pcd = new PoliticasContraseniaDAO();
        return pcd.read();
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
        for (int i=0; i<pass2.getPassword().length; i++){
            a= pass2.getPassword()[i];
            contra = contra + a;
        }
        for (int i=0; i<pass1.getPassword().length; i++){
            a= pass1.getPassword()[i];
            contra2 = contra2 + a;
        }
        if (this.matchPass(contra, contra2)){ //BUSCAR POLITICAS EN LA BD
            if (this.validarPass(contra)){
                UsuarioDAO ud = new UsuarioDAO();
                List lista = ud.readAll();
                if(!lista.isEmpty()){
                    int idAux = parseInt(id);
                    for (int i=0; i<lista.size(); i++){
                        if (lista.get(i).equals(idAux))
                            return "coincidencia";
                    }
                }
            }else{
                return "politicas";
            }
        }else{
            return "confirmacion";
        }
        Clave c = new Clave(contra);
        Usuario u = new Usuario(c, username, name, last);
        this.registrarBedel(c, u, turno, email);
        return "exito";
    }

    public boolean validarPass(String pass){
        PoliticasContraseniaDAO pcd = new PoliticasContraseniaDAO();
        Politicascontrasenia pc = pcd.read();
        if (pass.length()>=pc.getLongMin()){
            if (pc.isSignosEspeciales()){
                //??????????????
                if (pc.isDigito()){
                    //??????????????????
                    if(pc.isLetraMay()){
                        //????????????????
                        if(pc.isPassIgual()){
                            //??????????????
                            return true;
                        }else
                            return false;
                    }else
                        return false;
                }else
                    return false;
            }else
                return false;
        }else
            return false;
    }

    public void eliminarBedel(Bedel b){

    }

    public boolean matchPass(String ap, String pass){
        return ap.equals(pass);
    }

    public void modificarDatosBedel(Bedel b){

    }

    public void registrarBedel(Clave c, Usuario u, String turno, String email){
        ClaveDAO cd = new ClaveDAO();
        UsuarioDAO ud = new UsuarioDAO();
        try{
            cd.create(c);
            ud.create(u);
            cd.update(c, u);
            Bedel b = new Bedel(u, turno, email);
            ud.create(b);
        }catch(Exception e){
            
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

}