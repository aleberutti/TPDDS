package Controlador;

import Modelo.Aula;
import Modelo.Periodo;
import Modelo.Reserva;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juani
 */
public class GestorDeReserva {

    ReservaDAO rd;
    
    public GestorDeReserva() {
        rd = new ReservaDAO();
    }
    
    public List<Aula> registrarReservaEsporadica(Vector v, int cantAlumnos, String tipoDeAula){
        GestorDeAula gda = new GestorDeAula();
        ArrayList listaReservas = new ArrayList();
        for (int i=0; i<v.size(); i++){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = new Date();
            Date h_fin = new Date();
            Date h_inicio = new Date();
            try{
                fecha = sdf.parse((String)(((Vector)v.get(i)).get(0)));
                sdf = new SimpleDateFormat("HH:mm");
                h_inicio = sdf.parse((String)(((Vector)v.get(i)).get(2)));
                h_fin = sdf.parse((String)(((Vector)v.get(i)).get(3)));
            }catch(ParseException e){
                System.out.println("Excepcion.");
            }
            List<Aula> aulas = gda.validarDisponibilidad(fecha, h_inicio, h_fin, tipoDeAula, cantAlumnos, null);
            if (aulas!=null){ //ENCONTRO AULA LIBRE
                return aulas;
            }
            else{
                return null; 
            }
        }
        return null;
    }
    
    
    //Los list estos tiene java.awt porque sino me quiere hacer implementar los metodos abstractos
    //Necesito el java.util para el metodo de arriba NO SACAR
    public java.awt.List buscarReservaCurso(String curso){
        return new java.awt.List();
    }

    public java.awt.List buscarReservaDia(Date d){
        return new java.awt.List();
    }
    public void notificarError(){

    }

    public void listarCurso(java.awt.List curso){

    }

    public void listarDia(java.awt.List dia){

    }
    
    public boolean existe (String date1, String horaInS, String horaFinS, DefaultTableModel modelo){
        boolean existe=false;
        SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
        Date horaIn = new Date();
        Date horaFin = new Date();
        try{
            horaIn = sdfH.parse(horaInS);
            horaFin = sdfH.parse(horaFinS);            
        }catch(ParseException e){
            return false;
        }
        for (int i=0; i<modelo.getRowCount(); i++){
            if (!existe){
                Date fechaInFila=new Date(), fechaFinFila=new Date();
                try{
                    fechaInFila = sdfH.parse(modelo.getValueAt(i, 2).toString());
                    fechaFinFila = sdfH.parse(modelo.getValueAt(i, 3).toString());
                }catch(ParseException e){
                    System.out.println("Error en parseo. Vuelva a intentar");
                }
                if (date1.equals(modelo.getValueAt(i, 0)) && ((horaIn.after(fechaInFila) && horaIn.before(fechaFinFila)) || 
                        horaIn.equals(fechaInFila) || (horaFin.after(fechaInFila) && horaFin.before(fechaFinFila)))){
                    existe=true;
                }
            }
        }
        return existe;
    }
}