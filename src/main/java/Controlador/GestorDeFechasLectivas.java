/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.FechalectivasId;

/**
 *
 * @author juani
 */
public class GestorDeFechasLectivas {
    private FechasLectivasDAO fld;
    public GestorDeFechasLectivas() {
        this.fld= new FechasLectivasDAO();
    }
    
    public FechalectivasId obtenerFechas(){
        return this.fld.readFechas();
    }

    public void notificarError(){

    }
}