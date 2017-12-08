package Controlador;

import Modelo.Reserva;
import java.awt.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juani
 */
public class GestorDeReserva {

    public GestorDeReserva() {
    }
    
    public void registrarReserva(Reserva r){

    }

    public List buscarReservaCurso(String curso){
        return new List();
    }

    public List buscarReservaDia(Date d){
        return new List();
    }
    public void notificarError(){

    }

    public void listarCurso(List curso){

    }

    public void listarDia(List dia){

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