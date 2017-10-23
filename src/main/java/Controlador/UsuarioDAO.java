/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Admin;
import Modelo.Bedel;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author juani
 */
public class UsuarioDAO extends GenericDAO{

    private HibernateUtil HU;
    private Session SS;
    
    public UsuarioDAO() {
    }
    
    public void create(Usuario u){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.save(u);
        SS.getTransaction().commit();
        SS.close();
    }
    
    public List<Integer> readAll(){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT userID FROM usuario;";
        Query query = SS.createSQLQuery(sentencia);
        List<Integer> lista = query.list();
        if (lista.isEmpty()){
            //ERROR
            SS.getTransaction().commit();
            SS.close();
            return new ArrayList();
        }else{
            SS.getTransaction().commit();
            SS.close();
            return lista;
        }
    }
    
    public ArrayList readAllUserPass(){
//        SS = HU.getSessionFactory().openSession();
//        SS.beginTransaction();
//        String sentencia = "SELECT usuario.userID, nombreUsuario, valor FROM usuario, clave WHERE usuario.claveID=clave.claveID;";
//        Query query = SS.createSQLQuery(sentencia);
//        List lista = query.list();
//        System.out.println(((Usuario)lista.get(0)).getNombreUsuario());
//        ArrayList up = new ArrayList();
//        for (int i=0; i<lista.size(); i++){
//            ArrayList aux = new ArrayList(3);
//            for(int j=0; j<3;j++){
//                aux.add(lista.get(i));
//                i++;
//            }
//            up.add(aux);
//        }
//        if (lista.isEmpty()){
//            //ERROR
//            SS.getTransaction().commit();
//            SS.close();
//            return new ArrayList();
//        }else{
//            SS.getTransaction().commit();
//            SS.close();
//            return up;
//        }
        return new ArrayList(); 
    }
    
    public Usuario isAoB(Integer id){
//        SS = HU.getSessionFactory().openSession();
//        SS.beginTransaction();
//        String sentencia = "SELECT userID FROM bedel WHERE userID=" + id.toString() + ";";
//        Query query = SS.createSQLQuery(sentencia);
//        List lista = query.list();
//        int i;
//        if (lista.isEmpty()){
//            sentencia = "SELECT userID FROM bedel WHERE userID=" + id.toString() + ";";
//            query = SS.createSQLQuery(sentencia);
//            lista = query.list();
//            if (lista.isEmpty()){
//                SS.getTransaction().commit();
//                SS.close();
//                return null;
//            }else{
//                SS.getTransaction().commit();
//                SS.close();
//                return new Admin();
//            }
//        }else{
//            SS.getTransaction().commit();
//            SS.close();
//            return new Bedel();
//        }
        return new Bedel();
    }
        
}
