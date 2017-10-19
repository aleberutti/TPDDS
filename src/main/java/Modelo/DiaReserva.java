/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author juani
 */
public class DiaReserva {
    private int idDiaReserva;
    private DiaSemana dia;
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;
    private Aula aula;
    private Reserva reserva;
}