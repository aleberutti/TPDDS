/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Diareserva;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Fausto
 */
public class DiaReservaDAO extends GenericDAO{

    private HibernateUtil HU;
    private Session SS;
    
    public DiaReservaDAO() {
    }
    
    public List<Diareserva> getReservas(int aulaID, Date fecha, Date h_in, Date h_fin){ // DEVUELVE LAS RESERVAS QUE MATCHEEN CON LOS PARAMETROS
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String fechaS, h_inicioS, h_finS;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fechaS = sdf.format(fecha);
        sdf = new SimpleDateFormat("HH:mm");
        h_inicioS = sdf.format(h_in);
        h_finS = sdf.format(h_fin);
        String sentencia = "SELECT * FROM diareserva D WHERE D.aulaID='" + aulaID + "' AND D.fecha='" + fechaS + "' "
                + "AND ((D.horainicio<='" + h_inicioS + "' AND D.horafin>'" + h_inicioS + "') OR (D.horainicio<'" + h_finS + "' "
                + "AND D.horafin>='" + h_finS + "'));";
        Query query = SS.createSQLQuery(sentencia).addEntity(Diareserva.class);
        List<Diareserva> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
}
