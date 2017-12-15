/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Aula;
import Modelo.Diareserva;
import Modelo.FechalectivasId;
import Modelo.Periodo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author juani
 */
public class GestorDeAula {
    FechasLectivasDAO fld;
    AulasDAO adao;
    DiaReservaDAO drdao;
    public GestorDeAula() {
        this.drdao = new DiaReservaDAO();
        this.adao = new AulasDAO();  
    }
    
    public void buscarAula(Aula a){

    }

    public void modificarAula(Aula a){

    }

    public void guardarBusqueda(){ //¿???????????? parametro que iría: Busqueda b?

    }

    public boolean validarAula(Aula a){
        return false;
    }

    public List<Aula> validarDisponibilidad(Date fecha, Date h_inicio, Date h_fin, String tipoDeAula, int cantAlumnos, Periodo periodo){
        int cont = -1;
        GestorDeFechasLectivas gdfl = new GestorDeFechasLectivas();
        List<Aula> listaAulas = adao.getPosibles(tipoDeAula, cantAlumnos);
        List<Aula> resultado = new ArrayList();
        if (!listaAulas.isEmpty()){
            String diaFecha = obtenerDia(fecha);
            String periodoSolicitado;

//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            System.out.println(sdf.format(fecha));
            if(!(periodo==null)){//Periodica
                boolean aulaDisponibleAux;
                Date fechaAux = fecha;
                periodoSolicitado = periodo.toString();
                while(cont<listaAulas.size()-1){
                    cont++;
                    aulaDisponibleAux=true;
                    Date fechaCiclo;
                    FechalectivasId fl = gdfl.getFechas();
                    switch (periodo){
                        case PRIMERC:
                            fechaCiclo = fl.getFechafin1c();
                            break;
                        default:
                            fechaCiclo = fl.getFechafin2c();
                            break;
                    }
                    fechaAux = fecha;
                    while(aulaDisponibleAux && fechaAux.before(fechaCiclo)){
                        Calendar c = Calendar.getInstance();
                        c.setTime(fechaAux);
                        c.add(Calendar.DATE, 7);
                        fechaAux=c.getTime();
                        List<Diareserva> reservas = drdao.getReservas(listaAulas.get(cont).getAulaId(), fechaAux, h_inicio, h_fin, diaFecha, periodoSolicitado);
                        if (!reservas.isEmpty()){ // SI LA LISTA ES VACIA SIGNIFICA QUE NO EXISTEN RESERVAS QUE COINCIDAN CON LA FECHA Y HORA EN ESE AULA, ES DECIR, ESTA DISPONIBLE
                            aulaDisponibleAux=false;
                        }
                    }
                    if (fechaAux.after(fechaCiclo)){
                        resultado.add(listaAulas.get(cont));
                    }
                }
                System.out.println("Dia: " + diaFecha + " periodo: " + periodoSolicitado);
                return resultado;
            }else{//Esporadica
                periodoSolicitado = gdfl.getPeriodo(fecha);
                while(cont<listaAulas.size()-1){
                    cont++;
                    List<Diareserva> reservas = drdao.getReservas(listaAulas.get(cont).getAulaId(), fecha, h_inicio, h_fin, diaFecha, periodoSolicitado);
                    if (reservas.isEmpty()){
                        resultado.add(listaAulas.get(cont));
                    }
                }
                System.out.println("Dia: " + diaFecha + " periodo: " + periodoSolicitado);
                return resultado;
            }
            
        }else{
            //NO HAY AULA DE ESE TIPO Y CANTIDAD
            return null;
        }
        
    }
   
    public String obtenerDia(Date fecha){
        String diaFecha = null;
        switch(fecha.getDay()){
            case 0: diaFecha = "DOMINGO"; break;
            case 1: diaFecha = "LUNES"; break;
            case 2: diaFecha = "MARTES"; break;
            case 3: diaFecha = "MIERCOLES"; break;
            case 4: diaFecha = "JUEVES"; break;
            case 5: diaFecha = "VIERNES"; break;
            case 6: diaFecha = "SABADO"; break;
        } 
        
        return diaFecha;
    }
    
    public List<Diareserva> obtenerReservasSinPeriodicas(List<Diareserva> r, List<Diareserva> rp){
        java.util.List<Diareserva> reservas= null;
        for(int i=0; i<r.size(); i++){
            if(r.contains(rp.get(i))){
                reservas.add(rp.get(i));
            }
        }
        
        return reservas;
    }
    
    public void notificarError(){

    }

    public List obtenerAula(String num, String tipo, String cap){ //YO CAMBIE LOS PARAMETROS, este es para BuscarAula
        return new ArrayList();
    }

    public Aula obtenerAula(String num, int piso, String tipo, String cap, String estado){ //Este lo cree yo, es para ModifciarOEliminarAula
        return new Aula();
    }

    public void eliminarAula(Aula a){

    }
}
