package com.labii;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by francomoglia on 11/28/16.
 */

public class EventoSource {

    private static final Map<Integer, Evento> listaEventos = new HashMap<Integer, Evento>();
    private static final AtomicInteger contador = new AtomicInteger(0);

    static {

        Evento evento1 = new Evento(contador.incrementAndGet(), "limpiar" ,1, "Tengo que limpiar mi Pieza",
                new Fecha(10,01,2016,20,30), new Fecha(10,01,2016,21,30), "Rojo");
        Evento evento2 = new Evento(contador.incrementAndGet(), "Estudiar",1, "Tengo que estudiar para Lab",
                new Fecha(15,01,2016,15,30), new Fecha(15,01,2016,16,30), "Verde");
        Evento evento3 = new Evento(contador.incrementAndGet(), "trabajar",2, "Tengo que terminar mi desarrollo de la Api",
                new Fecha(9,1,2016,3,30), new Fecha(9,1,2016,4,30), "Azul");

        listaEventos.put(evento1.getIdEvento(), evento1);
        listaEventos.put(evento2.getIdEvento(), evento2);
        listaEventos.put(evento3.getIdEvento(), evento3);

    }

    public static Collection<Evento> getListaEventos() {
        return listaEventos.values();
    }

    public static Evento getEventos(Integer idEventos) {
        return listaEventos.get(idEventos);
    }

    /*
    public static Collection<Evento> listaEventosPorID(Integer idCalendario){
        HashMap<Integer, Evento> resul = new HashMap<Integer, Evento>();
        for (Evento list : listaEventos.values()){
            if (list.getCalendario().getId() == idCalendario){
                resul.put(list.getIdEvento(), list);
            }
        }
        return resul.values();
    }
    */

    //  ALTA
    public static void altaEvento(String nombre, String descripcion, Integer idCalendario, int dia, int mes, int anio, int hora, int minuto, String color){

        Evento evento = new Evento(contador.incrementAndGet(), nombre, idCalendario, descripcion,
                new Fecha(dia,mes,anio,hora,minuto), new Fecha(dia,mes,anio,hora,minuto), color);
        listaEventos.put(evento.getIdEvento(), evento);

    }

    // BAJA
    public static void bajaEvento(int idEvento){

        listaEventos.remove(idEvento);

    }

    //  MODIFICACION
    public static void modificarEvento(int idEvento, String nombre, String descripcion){

        if (listaEventos.get(idEvento) != null) {

            if (listaEventos.get(idEvento) != null) listaEventos.get(idEvento).setNombre(nombre);
            if (listaEventos.get(idEvento) != null) listaEventos.get(idEvento).setDescripcion(descripcion);

        }else throw new CustomExceptionUsuario("Evento no encontrado");

    }

}
