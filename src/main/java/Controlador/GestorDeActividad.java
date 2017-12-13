/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Actividad;
import Modelo.Catedra;
import Modelo.Curso;
import Modelo.Seminario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juani
 */
public class GestorDeActividad {
    private ActividadDAO ad;
    public GestorDeActividad() {
        this.ad= new ActividadDAO();
    }
    
    public Actividad obtenerActividad(){
        return new Actividad();
    }

    public void notificarError(){

    }
    
    public ArrayList <String> getCursos(){
        List<Actividad> lista = this.ad.readCursosNames();
        ArrayList <String> datos = new ArrayList();
        for (Actividad a: lista){
            datos.add(a.getNombre());
        }
        return datos;
    }
    
    public ArrayList <String> getSeminarios(){
        List<Actividad> lista = this.ad.readSeminariosNames();
        ArrayList <String> datos = new ArrayList();
        for (Actividad a: lista){
            datos.add(a.getNombre());
        }
        return datos;
    }
        
    public ArrayList <String> getCatedras(){
        List<Actividad> lista = this.ad.readCatedrasNames();
        ArrayList <String> datos = new ArrayList();
        for (Actividad a: lista){
            datos.add(a.getNombre());
        }
        return datos;
    }
    
    public ArrayList <String> getSeminariosThemes(){
        List<Seminario> lista = this.ad.readSeminariosThemes();
        ArrayList <String> datos = new ArrayList();
        for (Seminario a: lista){
            datos.add(a.getTema());
        }
        return datos;
    }
    public ArrayList <String> getCursosCarrera(){
        List<Curso> lista = this.ad.readCursosCarrera();
        ArrayList <String> datos = new ArrayList();
        for (Curso a: lista){
            if(!datos.contains(a.getCarrera())){ 
            datos.add(a.getCarrera());
        }
        }
        return datos;
    }

    public ArrayList <String> getCatedrasCarrera(){
        List<Catedra> lista = this.ad. readCatedras();
        ArrayList <String> datos = new ArrayList();
        for (Catedra a: lista){
            if(!datos.contains(a.getCarrera())){ 
            datos.add(a.getCarrera());
        }
        }
        return datos;
    }
  
    public ArrayList <String> getCatedrasComision(){
        List<Catedra> lista = this.ad. readCatedras();
        ArrayList <String> datos = new ArrayList();
        for (Catedra a: lista){
            if (!datos.contains(a.getComision())){
                datos.add(a.getComision());
            }
        }
        return datos;
    }
}