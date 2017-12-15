/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Bedel;
import org.hibernate.Session;

/**
 *
 * @author juani
 */
public class GenericDAO {
    
    private HibernateUtil HU;
    private Session SS;
    
    public GenericDAO(){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.getTransaction().commit();
        SS.close();
    }

    public void create(Object o){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.save(o);
        SS.getTransaction().commit();
        SS.close();
    }
    
    
    public Object read(Object o, int id){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        Class c = o.getClass();
        Object obj = SS.get(c, id);
        SS.getTransaction().commit();
        SS.close();
        return obj;
    }
    public void update(Object o){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.update(o);
        SS.getTransaction().commit();
        SS.close();
    }

    public void delete(Object o){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.delete(o);
        SS.getTransaction().commit();
        SS.close();
    }    
}