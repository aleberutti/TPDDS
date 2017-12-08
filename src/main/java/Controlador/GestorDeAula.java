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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

/**
 *
 * @author juani
 */
public class GestorDeAula {

    public GestorDeAula() {
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

    public boolean validarDisponibilidad(Date fecha, Date h_inicio, Date h_fin, String tipoDeAula, int cantAlumnos, Periodo periodo){
        AulasDAO adao = new AulasDAO();
        DiaReservaDAO drdao = new DiaReservaDAO();
        boolean aulaDisponible=false;
        int cont = -1;
        List<Aula> listaAulas = adao.getPosibles(tipoDeAula, cantAlumnos);
        if (!listaAulas.isEmpty()){
            if(fecha==null){//Periodica
                boolean aulaDisponibleAux=true;
                while(!aulaDisponible || cont<listaAulas.size()){
                    cont++;
                    Date fechaCiclo;
                    FechalectivasId fl = new FechalectivasId();
                    switch (periodo){
                        case PRIMERC:
                            fechaCiclo = fl.getFechafin1c();
                            break;
                        default:
                            fechaCiclo = fl.getFechafin2c();
                            break;
                    }
                    while(aulaDisponibleAux && fecha.before(fechaCiclo)){
                        Calendar c = Calendar.getInstance();
                        c.setTime(fecha);
                        c.add(Calendar.DATE, 7);
                        fecha=c.getTime();
                        List<Diareserva> reservas = drdao.getReservas(listaAulas.get(cont).getAulaId(), fecha, h_inicio, h_fin);
                        if (!reservas.isEmpty()){
                            aulaDisponibleAux=false;
                        }
                    }
                }
            }else{//Esporadica
                while(!aulaDisponible || cont<listaAulas.size()){
                    cont++;
                    List<Diareserva> reservas = drdao.getReservas(listaAulas.get(cont).getAulaId(), fecha, h_inicio, h_fin);
                    if (reservas.isEmpty()){
                        aulaDisponible=true;
                    }
                }
                return aulaDisponible;
            }
        }else{
            //NO HAY AULA DE ESE TIPO Y CANTIDAD
            return false;
        }
        return false;
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