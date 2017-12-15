/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Aula;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author juani
 */
public class AulasDAO {

    private HibernateUtil HU;
    private Session SS;
    
    public AulasDAO() {
    }
    
    public List<Aula> getPosibles (String tipo, int cant){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia;
        Query query;
        List<Aula> lista = new ArrayList();
        switch (tipo){
            case "Multimedios":
                sentencia = "SELECT A.* FROM aulamultimedios AM, aula A WHERE AM.aulaID=A.aulaID "
                        + "AND A.capacidad>=" + cant + " AND A.estado='ACTIVA';";
                query = SS.createSQLQuery(sentencia).addEntity(Aula.class);
                lista = query.list();
                SS.getTransaction().commit();
                SS.close();
                break;
            case "Informática":
                sentencia = "SELECT A.* FROM aulainformatica AI, aula A WHERE AI.aulaID=A.aulaID "
                        + "AND A.capacidad>=" + cant + " AND A.estado='ACTIVA';";
                query = SS.createSQLQuery(sentencia).addEntity(Aula.class);
                lista = query.list();
                SS.getTransaction().commit();
                SS.close();
                break;
            case "Sin Recursos Adicionales":
                sentencia = "SELECT A.* FROM aulasra ASRA, aula A WHERE ASRA.aulaID=A.aulaID "
                        + "AND A.capacidad>=" + cant + " AND A.estado='ACTIVA';";
                query = SS.createSQLQuery(sentencia).addEntity(Aula.class);
                lista = query.list();
                SS.getTransaction().commit();
                SS.close();
                break;
        }
        return lista;
    }
    
}
