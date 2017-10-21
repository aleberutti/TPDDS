/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Bedel;
import javax.swing.JPasswordField;

/**
 *
 * @author juani
 */
public class GestorDeBedel {
    
public void seleccionarOpcion(){

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

public String validar(String id, JPasswordField pass1, JPasswordField pass2){
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
    if (this.validarPass(contra, contra2)){ //BUSCAR POLITICAS EN LA BD
        if (this.matchPass(contra, contra2)){
//            if (ID EXISTENTE)
//                return "id_existente";
//            else
//                return "exito";
        }else{
            return "confirmacion";
        }
    }else
        return "politica";
    return "asd"; //PARA QUE NO JODA EL ERROR DE LA ADVERTENCIA QUE NO ESPECIFICAMOS RETORNO.
}

public boolean validarPass(String ap, String pass){
    //BUSCAR EN BD POLITICAS
    PoliticasContraseniaDAO pcd = new PoliticasContraseniaDAO();
    return false;
}

public void eliminarBedel(Bedel b){

}

public boolean matchPass(String ap, String pass){
    if (ap.equals(pass))
        return true;
    else return false;
}

public void modificarDatosBedel(Bedel b){

}

public void registrarBedel(Bedel b){

}

public boolean camposVacios(String username, String name, String last, String id, String turno, JPasswordField pass1, JPasswordField pass2){
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
    if (!(name.isEmpty() && username.isEmpty() && last.isEmpty() && turno.isEmpty() && id.isEmpty() && contra.equals("") && contra2.equals(""))){
        return false;
    }
    return true;
}

}