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

    public List<Aula> validarDisponibilidad(Date fecha, Date h_inicio, Date h_fin, String tipoDeAula, int cantAlumnos, Periodo periodo){
        AulasDAO adao = new AulasDAO();
        DiaReservaDAO drdao = new DiaReservaDAO();
        FechasLectivasDAO fld = new FechasLectivasDAO();
        int cont = -1;
        List<Aula> listaAulas = adao.getPosibles(tipoDeAula, cantAlumnos);
        List<Aula> resultado = new ArrayList();
        if (!listaAulas.isEmpty()){
            if(!(periodo==null)){//Periodica
                boolean aulaDisponibleAux;
                Date fechaAux = fecha;
                while(cont<listaAulas.size()-1){
                    cont++;
                    aulaDisponibleAux=true;
                    Date fechaCiclo;
                    FechalectivasId fl = fld.readFechas();
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
                        List<Diareserva> reservas = drdao.getReservas(listaAulas.get(cont).getAulaId(), fechaAux, h_inicio, h_fin);
                        if (!reservas.isEmpty()){ // SI LA LISTA ES VACIA SIGNIFICA QUE NO EXISTEN RESERVAS QUE COINCIDAN CON LA FECHA Y HORA EN ESE AULA, ES DECIR, ESTA DISPONIBLE
                            aulaDisponibleAux=false;
                        }
                    }
                    if (fechaAux.after(fechaCiclo)){
                        resultado.add(listaAulas.get(cont));
                    }
                }
                return resultado;
            }else{//Esporadica
                while(cont<listaAulas.size()-1){
                    cont++;
                    List<Diareserva> reservas = drdao.getReservas(listaAulas.get(cont).getAulaId(), fecha, h_inicio, h_fin);
                    if (reservas.isEmpty()){
                        resultado.add(listaAulas.get(cont));
                    }
                }
                return resultado;
            }
        }else{
            //NO HAY AULA DE ESE TIPO Y CANTIDAD
            return null;
        }
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