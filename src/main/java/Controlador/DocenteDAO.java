/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Docente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author juani
 */
public class DocenteDAO extends GenericDAO{

    private HibernateUtil HU;
    private Session SS;
    
    public DocenteDAO() {
    }
    
    public List<Docente> readAll(){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM docente;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Docente.class);
        List<Docente> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
    public List<Docente> readMail(int ID){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM docente WHERE docenteID=" + ID;
        Query query = SS.createSQLQuery(sentencia).addEntity(Docente.class);
        List<Docente> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
    public Docente readObj(String email){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM docente D WHERE D.email='" + email + "' LIMIT 0,1;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Docente.class);
        List<Docente> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        if (!lista.isEmpty())
            return lista.get(0);
        else
            return null;
    }
    
}
