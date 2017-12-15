/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Actividad;
import Modelo.Catedra;
import Modelo.Curso;
import Modelo.Seminario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author juani
 */
public class ActividadDAO extends GenericDAO{
    private HibernateUtil HU;
    private Session SS;
    public ActividadDAO() {
    }
    
    public List<Actividad> readAll(){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM actividad WHERE 1;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Actividad.class);
        List<Actividad> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
    public List<Actividad> readCursosNames(){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM actividad, curso WHERE actividad.actividadID=curso.actividadID;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Actividad.class);
        List<Actividad> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;        
    }
    
    public List<Actividad> readSeminariosNames(){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM actividad, seminario WHERE actividad.actividadID=seminario.actividadID;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Actividad.class);
        List<Actividad> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;        
    }
    
    public List<Actividad> readCatedrasNames(){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM actividad, catedra WHERE actividad.actividadID=catedra.actividadID;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Actividad.class);
        List<Actividad> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;        
    }
    
    public List<Seminario> readSeminariosThemes(){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM actividad, seminario WHERE actividad.actividadID=seminario.actividadID;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Seminario.class);
        List<Seminario> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;        
    }
        
    public List<Curso> readCursosCarrera(){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM actividad, curso WHERE actividad.actividadID=curso.actividadID;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Curso.class);
        List<Curso> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;        
    }
    
   public List<Catedra> readCatedras(){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM actividad, catedra WHERE actividad.actividadID=catedra.actividadID;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Catedra.class);
        List<Catedra> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;        
    }
}
