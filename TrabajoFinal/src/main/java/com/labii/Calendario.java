package com.labii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by francomoglia on 11/28/16.
 */

public class Calendario {

    private Integer idCalendario = 0;
    private String nombre;
    private Usuario usuario;
    private Integer idUsuario;

    //private ArrayList<Evento> eventos = new ArrayList<Evento>();
    private Map<Integer, Evento> eventos  = new HashMap<Integer, Evento>();

    public Calendario(int idCalendario, String nombre, int idUsuario) {

        this.idCalendario = idCalendario;
        this.nombre = nombre;
        this.usuario = UsuarioSource.getUsuario(idUsuario);

        //this.eventos.putAll(EventoSource.getListaEventos());
    }

    public Calendario(){

    }


    public Integer getidCalendario() {
        return idCalendario;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Map<Integer, Evento> getEventos() {
        return eventos;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}