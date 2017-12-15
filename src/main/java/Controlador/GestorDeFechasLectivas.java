/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.FechalectivasId;
import java.util.Date;

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

    public String getPeriodo(Date fecha){
        FechalectivasId fechasLectivas = this.obtenerFechas();
        if (fecha.after(fechasLectivas.getFechainicio1c()) && fecha.before(fechasLectivas.getFechafin1c())){
            return "PRIMERC";
        }else{
            if (fecha.after(fechasLectivas.getFechainicio2c()) && fecha.before(fechasLectivas.getFechafin2c())){
                return "PRIMERC";
            }else
                return "ANUAL";
        }
    }
}