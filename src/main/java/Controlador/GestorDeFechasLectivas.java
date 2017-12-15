/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.FechalectivasId;
import java.text.SimpleDateFormat;
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
    public FechalectivasId getFechas(){
        return fld.readFechas();
    }
    public String getPeriodo(Date fecha){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Parametro: "+sdf.format(fecha));
        FechalectivasId fechasLectivas = this.obtenerFechas();
        if (fecha.after(fechasLectivas.getFechainicio1c()) && fecha.before(fechasLectivas.getFechafin1c())){
            System.out.println(sdf.format(fecha));
            return "PRIMERC";
        }else{
            if (fecha.after(fechasLectivas.getFechainicio2c()) && fecha.before(fechasLectivas.getFechafin2c())){
                System.out.println(sdf.format(fecha));
                return "SEGUNDOC";
            }else
                System.out.println(sdf.format(fecha));
                return "ANUAL";
        }
    }
}