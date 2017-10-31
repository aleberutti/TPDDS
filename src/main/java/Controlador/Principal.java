/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Autenticacion;
import Vista.ErrorBbdd;
import Vista.Logos;
import javax.swing.ImageIcon;
/**
 *
 * @author Fausto
 */



public class Principal {

    public static void main(String[] args) {

        Logos cp = new Logos();
        cp.setVisible(true);
        try{
        GenericDAO gd = new GenericDAO();
        Autenticacion au = new Autenticacion();
        }catch(Exception e){
            e.printStackTrace();
            cp.dispose();
            ErrorBbdd eb = new ErrorBbdd();
        }
        cp.dispose();
    }
    
}
