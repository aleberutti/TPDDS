/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Aula;
import Modelo.Periodo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public List<Aula> getAulasPyE(String dia, Date h_inicio, Date h_fin, Periodo periodo){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String hi, hf;
 
        hi = sdf.format(h_inicio);
        hf = sdf.format(h_fin);
       
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        List<Aula> lista = new ArrayList();
        String sentencia;
        Query query;
        String sentencia2;
        Query query2;
        sentencia = "SELECT a.* FROM diareserva dr, aula a, periodica p, reserva r "+
                " WHERE dr.aulaID=a.aulaID AND dr.reservaID=p.reservaID AND r.reservaID=p.reservaID AND "+
                "dr.horainicio='"+hi+"' AND dr.horafin='"+hf+"' AND dr.diaSemana='"+dia+"'"+
                " AND (r.periodo='"+periodo+"' OR r.periodo='ANUAL');";
        query = SS.createSQLQuery(sentencia).addEntity(Aula.class);
        lista.addAll(query.list());
        if(periodo.equals(Periodo.ANUAL)){
            sentencia2 = "SELECT a.* FROM diareserva dr, aula a, esporadica e, reserva r"+
                " WHERE dr.aulaID=a.aulaID AND dr.reservaID=e.reservaID AND "+
                "dr.horainicio='"+hi+"' AND dr.horafin='"+hf+"' AND dr.diaSemana='"+dia+"';";
        }
        else {
            sentencia2 = "SELECT a.* FROM diareserva dr, aula a, esporadica e, reserva r"+
                " WHERE dr.aulaID=a.aulaID AND dr.reservaID=e.reservaID AND r.reservaID=e.reservaID AND "+
                "dr.horainicio='"+hi+"' AND dr.horafin='"+hf+"' AND dr.diaSemana='"+dia+"'"
                    +" AND r.periodo='"+periodo+"';";
        }
        query2 = SS.createSQLQuery(sentencia2).addEntity(Aula.class);
        lista.addAll(query2.list());
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
}
