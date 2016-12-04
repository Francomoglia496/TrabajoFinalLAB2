package com.labii;

/**
 * Created by francomoglia on 11/28/16.
 */

public class Evento {

    private int idEvento;
    private String nombre;
    private Calendario calendario;
    private String descripcion;
    private Fecha fechaInicio;
    private Fecha fechaFin;
    private String color;
    private int idCalendario;

    public Evento(int idEvento, String nombre, int idCalendario, String descripcion, Fecha fechaInicio, Fecha fechaFin, String color) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.calendario = CalendarioSource.getCalendario(idCalendario);
        this.idCalendario = idCalendario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.color = color;

        //System.out.println(this.calendario.getNombre());
    }

    public Evento(){

    }

    public int getIdEvento() {
        return idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdCalendario() {
        return idCalendario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
