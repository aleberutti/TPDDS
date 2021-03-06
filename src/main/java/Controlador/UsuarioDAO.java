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
import org.hibernate.Hibernate;
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
    
    public Usuario read(Class u, int id){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
//        Bedel b = new Bedel();
//        Admin adm = new Admin();
//        if (u.equals(b.getClass())){
//            b = (Bedel) SS.get(Bedel.class, id);
//            Hibernate.initialize(b.getUsuario());
//            Hibernate.initialize(b.getUsuario().getClave());
//            SS.getTransaction().commit();
//            SS.close();
//            return b;
//        }
//        if (u.equals(adm.getClass())){
//            adm = (Admin) SS.get(Admin.class, id);
//            Hibernate.initialize(adm.getUsuario()); //Para que cargue lo definido en el lazy load
//            Hibernate.initialize(adm.getUsuario().getClave());
//            SS.getTransaction().commit();
//            SS.close();
//            return adm;
//        }else{
//            Usuario us = new Usuario();
//            if (u.equals(us.getClass())){
                Usuario us = (Usuario) SS.get(Usuario.class, id);
                SS.getTransaction().commit();
                SS.close();
                return us;
//            }
//            SS.getTransaction().commit();
//            SS.close();
//            return us;
//        }
    }
    
    public Usuario readUsername (String username){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM usuario U WHERE U.nombreUsuario='" + username + "';";
        Query query = SS.createSQLQuery(sentencia).addEntity(Usuario.class);
        List<Usuario> lista = query.list();
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
    
    public List<Bedel> readBedel(String apellido, String turno){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = null;
        if (!(apellido == null) && !(turno ==null)){
            sentencia = "SELECT B.* FROM bedel B, usuario U WHERE U.userID=B.userID "
                        + "AND U.apellido LIKE '%" + apellido + "%' AND B.turno ='" + turno +"';";
        }else{
            if (!(apellido == null) && (turno ==null)){
                sentencia = "SELECT B.* FROM bedel B, usuario U WHERE U.userID=B.userID "
                            + "AND U.apellido LIKE '%" + apellido + "%';";
            }else{
                if ((apellido == null) && !(turno ==null)){
                    sentencia = "SELECT B.* FROM bedel B, usuario U WHERE U.userID=B.userID "
                                + "AND B.turno ='" + turno +"';";
                }
            }
        }
        if (!(sentencia == null)){
            Query query = SS.createSQLQuery(sentencia).addEntity(Bedel.class);
            List<Bedel> lista = query.list();
            if (lista.isEmpty()){
                SS.getTransaction().commit();
                SS.close();
                return null;
            }else{
                for (int i=0; i<lista.size(); i++){
                    Hibernate.initialize(lista.get(i).getUsuario());
                    Hibernate.initialize(lista.get(i).getUsuario().getClave());
                }
                SS.getTransaction().commit();
                SS.close();
                return lista;
            }
        }else{
            return null;
        }
    }
    
    public Usuario exists(String user, String contra){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT B.* FROM usuario U, clave C, bedel B WHERE U.nombreUsuario='" + user + "' AND C.valor='" + contra + "'"
                + " AND U.claveID=C.claveID AND B.userID=U.userID LIMIT 0,1;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Bedel.class);
        List lista = query.list();
        if (lista.isEmpty()){
            sentencia = "SELECT A.* FROM usuario U, clave C, admin A WHERE U.nombreUsuario='" + user + "' AND C.valor='" + contra + "'"
                    + " AND U.claveID=C.claveID AND A.userID=U.userID LIMIT 0,1;";
            query = SS.createSQLQuery(sentencia).addEntity(Admin.class);
            lista = query.list();
            if (lista.isEmpty()){
                SS.getTransaction().commit();
                SS.close();
                return null;
            }else{
                Hibernate.initialize(((Admin)lista.get(0)).getUsuario());
                SS.getTransaction().commit();
                SS.close();
                return (Admin)lista.get(0);
            }
        }else{
            Hibernate.initialize(((Bedel)lista.get(0)).getUsuario());
            SS.getTransaction().commit();
            SS.close();
            return (Bedel)lista.get(0);
        }
    }
/*  La query guarda los atributos del select en listas de Objetos SIEMPRE, se debe Castear el objeto para poder darle el uso que se quiera
    Cuando los argumentos de SELECT son mas de uno, query.list() devuelve una lista de arreglos de objetos, es decir, List<Object[]>, un ejemplo
    seria para la sentencia que esta arriba, la query va a devolver una lista de arreglo de objetos de manera que en todas las posiciones de la
    lista se encontrará un arreglo de 3 componentes correspondientes a objetos que refieren en primer lugar [0] a userID, eb segundo lugar [1] a
    nombreUsuario y en tercer lugar [2] a valor (String de la clave); la primer posicion de la lista lista.get(0) va a contener los valores de la
    primer celda obtenida como resultado de la consulta establecida y así sucesivamente. Por ejemplo, este system.out.println, va a devolver 4
    valores, los 3 correspondientes al primer resultado y el primero de la segunda fila resultante. El orden siempre será el determinado en el
    argumento de SELECT ...
        System.out.println(((Object[])lista.get(0))[0] + " " + ((Object[])lista.get(0))[1] + " " + ((Object[])lista.get(0))[2] + " " + ((Object[])lista.get(1))[0]);
        */
    
}
