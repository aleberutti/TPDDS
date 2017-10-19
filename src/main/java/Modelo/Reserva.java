/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author juani
 */
public class Reserva {
    private int idReserva;
    private int cantidadAlumnos;
    private Date fechaSolicitud;
    private Periodo periodo;
    private Docente docente;
    private DiaReserva[] dias;
    private Actividad actividad;
    private FechasLectivas fechasLectivas;
}
