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
    
    public List readPerType(String tipo){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia;
        Query query;
        List lista;
        switch (tipo){
            case "Curso":
                sentencia = "SELECT DISTINCT A.* FROM curso C, actividad A WHERE A.actividadID=C.actividadID;";
                query = SS.createSQLQuery(sentencia).addEntity(Actividad.class);
                lista = query.list();
                break;
            case "Seminario":
                sentencia = "SELECT DISTINCT A.* FROM seminario S, actividad A WHERE A.actividadID=S.actividadID;";
                query = SS.createSQLQuery(sentencia).addEntity(Actividad.class);
                lista = query.list();
                break;
            case "Carrera de grado":
                sentencia = "SELECT DISTINCT C.* FROM catedra C, actividad A WHERE A.actividadID=C.actividadID;";
                query = SS.createSQLQuery(sentencia).addEntity(Catedra.class);
                lista = query.list();
                break;
            default:
                sentencia = "SELECT DISTINCT * FROM actividad;";
                query = SS.createSQLQuery(sentencia).addEntity(Actividad.class);
                lista = query.list();
                break;
        }
        if (lista.isEmpty()){
            SS.getTransaction().commit();
            SS.close();
            return null;
        }else{
            SS.getTransaction().commit();
            SS.close();
            return lista;
        }
    }
    
    public List readCatedra(Catedra catedra){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT A.nombre FROM actividad A, catedra C WHERE C.actividadID=A.actividadID AND A.actividadID="+ catedra.getActividadId() +";";
        Query query = SS.createSQLQuery(sentencia);
        List lista = query.list();
        if (lista.isEmpty()){
            SS.getTransaction().commit();
            SS.close();
            return null;
        }else{
            SS.getTransaction().commit();
            SS.close();
            return lista;
        }
    }
    
}
