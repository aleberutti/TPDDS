/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Diareserva;
import Modelo.Esporadica;
import Modelo.Reserva;
import org.hibernate.Session;

/**
 *
 * @author juani
 */
public class ReservaDAO extends GenericDAO{

    private HibernateUtil HU;
    private Session SS;
    
    public ReservaDAO() {
    }
    
    public void createDR(Diareserva dr){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.save(dr);
        SS.getTransaction().commit();
        SS.close();
    }
    
    public void createReserva(Reserva rsv){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.save(rsv);
        SS.getTransaction().commit();
        SS.close();
    }
    
    public void createEsporadica (Esporadica esp){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.save(esp);
        SS.getTransaction().commit();
        SS.close();
    }
    
}
