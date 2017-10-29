/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clave;
import Modelo.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Fausto
 */
public class ClaveDAO extends GenericDAO{
    
    private HibernateUtil HU;
    private Session SS;
    
    public ClaveDAO(){
    }
    
    public void create(Clave c){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.save(c);
        SS.getTransaction().commit();
        SS.close();
    }
    
    public Clave readPass (String pass){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM clave C WHERE C.valor='" + pass + "';";
        Query query = SS.createSQLQuery(sentencia).addEntity(Clave.class);
        List<Clave> lista = query.list();
        if (lista.isEmpty()){
            SS.getTransaction().commit();
            SS.close();
            return null;
        }else{
            SS.getTransaction().commit();
            SS.close();
            return lista.get(0);
        }
    }
    
    public void update(Clave c, Usuario u){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String id = u.getUserId().toString();
        String sentencia = "SELECT userID FROM usuario WHERE nombreUsuario='" + id + "';";
        Query query = SS.createSQLQuery(sentencia);
        List lista = query.list();
        int i;
        if (lista.isEmpty())
            i=0;//ERROR
        else
            u.setUserId((Integer)lista.get(0));
        c.setUsuario(u);
        SS.update(c);
        SS.getTransaction().commit();
        SS.close();
    }
}
