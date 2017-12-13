/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.FechalectivasId;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author juani
 */
public class FechasLectivasDAO extends GenericDAO{

    private HibernateUtil HU;
    private Session SS;
    
    public FechasLectivasDAO() {
    }
    
    public FechalectivasId readFechas(){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM fechalectivas F ORDER BY fechainicio1C DESC LIMIT 0,1;";
        Query query = SS.createSQLQuery(sentencia);
        List lista = query.list();
        if (lista.isEmpty()){
            SS.getTransaction().commit();
            SS.close();
            return null;
        }else{
            SS.getTransaction().commit();
            SS.close();
            FechalectivasId fl = new FechalectivasId((Date)((Object[])lista.get(0))[0], (Date)((Object[])lista.get(0))[1], (Date)((Object[])lista.get(0))[2], (Date)((Object[])lista.get(0))[3]);
            return fl;
        }
    }
    
}
