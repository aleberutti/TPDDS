/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Diareserva;
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
    
    public List<Diareserva> getReservas(int aulaID, Date fecha, Date h_in, Date h_fin){ // DEVUELVE LAS POSIBLES
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM diareserva D WHERE D.aulaID=" + aulaID + " AND D.fecha= " + fecha + " "
                + "AND ((D.horainicio<=" + h_in + " AND D.horafin>" + h_in + ") OR (D.horainicio<" + h_fin + " "
                + "AND D.horafin>=" + h_fin + "));";
        Query query = SS.createSQLQuery(sentencia).addEntity(Diareserva.class);
        List<Diareserva> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
}
