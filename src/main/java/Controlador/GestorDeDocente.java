/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Docente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juani
 */
public class GestorDeDocente {
    private DocenteDAO dd;
    
    public GestorDeDocente() {
        this.dd=new DocenteDAO();
    }

    public Docente obtenerDocente(int idDocente){
        return new Docente();
    }
    
    public List<Docente> getDocentes(){
        return this.dd.readAll();
    }
    public String getDocenteEmail(String nombre){
        String mailDoc="";
        if (nombre.equals("Seleccione un docente de la lista")){
            return mailDoc;
        }
        else{
            List<Docente> doc = this.dd.readAll();
            
            for (Docente d: doc) {
                if ((d.getApellido()+", "+ d.getNombre()).equals(nombre)){
                    mailDoc = d.getEmail();
                }
            }
        }
        return mailDoc;
    }
    public ArrayList <String> getApellidoNombre(){


        List<Docente> docentes = dd.readAll();
        
        ArrayList <String> datos= new ArrayList();
        
        datos.add("Seleccione un docente de la lista");
        
        for(int i=0;i<docentes.size();i++){
                datos.add(docentes.get(i).getApellido()+", "+docentes.get(i).getNombre()); 
        }
       
        if (datos.isEmpty()){
            return null;
        }
       return datos; 
    }

    public void notificarError(){

    }

    public void listarDocentes(){

    }    
}