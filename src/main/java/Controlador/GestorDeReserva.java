package Controlador;

import Modelo.Actividad;
import Modelo.Aula;
import Modelo.Bedel;
import Modelo.Diareserva;
import Modelo.Docente;
import Modelo.Esporadica;
import Modelo.Reserva;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juani
 */
public class GestorDeReserva {

    ReservaDAO rd;
    Set<Diareserva> diaReservas = new HashSet();
    
    public GestorDeReserva() {
        rd = new ReservaDAO();
    }
    
    public List validarReservaEsporadica(Vector v, int cantAlumnos, String tipoDeAula){
        GestorDeAula gda = new GestorDeAula();
        List listaReservas = new ArrayList();
        for (int i=0; i<v.size(); i++){
            listaReservas.add(v.get(i));
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
            if (aulas!=null && !aulas.isEmpty()){ //ENCONTRO AULA LIBRE
                listaReservas.add(aulas);
            }
            else{
                listaReservas.add(null);
            }
        }
        return listaReservas;
    }
    
    public void registrarEsporadica(Aula aula, Vector v){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = new Date();
        Date h_fin = new Date();
        Date h_inicio = new Date();
        try{
            fecha = sdf.parse((String)(v.get(0)));
            sdf = new SimpleDateFormat("HH:mm");
            h_inicio = sdf.parse((String)(v.get(2)));
            h_fin = sdf.parse((String)(v.get(3)));
        }catch(ParseException e){
            System.out.println("Excepcion.");
        }
        Diareserva dr = new Diareserva(aula, (String)(v.get(1)), fecha, h_inicio, h_fin);
        System.out.println("Diareserva:");
        System.out.println("Aula: "+aula.getAulaId()+ " - Dia: "+(String)(v.get(2)) +" - Fecha: "+ (String)(v.get(0)) + " - h_inicio: " + (String)(v.get(2)) + " - h_fin: "+ (String)(v.get(3)));
        diaReservas.add(dr);
        System.out.println(diaReservas.size());
        System.out.println(" ---------- ");
    }
    
    public void registrarReserva(Bedel b, Actividad act, Docente doc, int cantAlumnos){
        Reserva rsv = new Reserva(act, b, doc, cantAlumnos, new Date(), diaReservas);
        Esporadica esp = new Esporadica(rsv);
        rsv.setEsporadica(esp);
        rd.createReserva(rsv);
        rd.createEsporadica(esp);
        System.out.println(diaReservas.size());
        diaReservas.forEach((e) ->  {
                                    System.out.println("Entra x;");
                                    e.setReserva(rsv); 
                                    rd.createDR(e);}
                            );
        this.diaReservas.clear();
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