/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Politicascontrasenia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author juani
 */
public class PoliticasContraseniaDAO {

    private HibernateUtil HU;
    private Session SS;
    
    public PoliticasContraseniaDAO() {
    }
    
    public Politicascontrasenia read(){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM politicascontrasenia ORDER BY politicaID DESC LIMIT 0,1;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Politicascontrasenia.class);
        List<Politicascontrasenia> lista = query.list();
        int i;
        if (lista.isEmpty()){
            i=0;//ERROR
            return null;
        }else{
            Politicascontrasenia pc = new Politicascontrasenia(lista.get(0).getPoliticaId(), lista.get(0).getLongMin(), lista.get(0).isSignosEspeciales(), lista.get(0).isLetraMay(), lista.get(0).isDigito(), lista.get(0).isPassIgual());
            SS.getTransaction().commit();
            SS.close();
            return pc;
        }
    }
}
