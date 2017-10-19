/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Aula;
import java.awt.List;

/**
 *
 * @author juani
 */
public class GestorDeAula {
    
public void buscarAula(Aula a){

}

public void modificarAula(Aula a){

}

public void guardarBusqueda(){ //¿???????????? parametro que iría: Busqueda b?

}

public boolean validarAula(Aula a){
    return false;
}

public boolean validarDisponibilidad(Aula a){
    return false;
}

public void notificarError(){
    
}

public List obtenerAula(String num, String tipo, String cap){ //YO CAMBIE LOS PARAMETROS, este es para BuscarAula
    return new List();
}

public Aula obtenerAula(String num, int piso, String tipo, String cap, String estado){ //Este lo cree yo, es para ModifciarOEliminarAula
    return new Aula();
}

public void eliminarAula(Aula a){
    
}
}