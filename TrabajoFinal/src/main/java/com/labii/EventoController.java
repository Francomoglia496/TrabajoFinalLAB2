package com.labii;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by francomoglia on 12/2/16.
 */

@RestController
public class EventoController {

    @RequestMapping(value = "/evento", method = RequestMethod.GET)
    public Collection<Evento> getEvento(){
        return EventoSource.getListaEventos();
    }

    @RequestMapping(value = "/evento/{idEvento}", method = RequestMethod.GET)
    public Evento getEventoPorID(@PathVariable("idEvento") Integer idEvento){
        return EventoSource.getEventos(idEvento) ;
    }

    //Alta
    @RequestMapping(value = "/evento/alta", method = RequestMethod.POST)
    public void altaEvento(@RequestBody Evento input, int dia, int mes, int anio, int hora, int minuto, String color){
        EventoSource.altaEvento(input.getNombre(), input.getDescripcion(), input.getIdCalendario(), dia,mes,anio,hora,minuto, color);
    }

    //Baja
    @RequestMapping(value = "/evento/{idEvento}/baja", method = RequestMethod.DELETE)
    public void bajaEvento(@PathVariable(value = "idEvento") Integer idEvento){
        EventoSource.bajaEvento(idEvento);
    }

    //Modificar
    @RequestMapping(value = "/evento/{idEvento}/modificar", method = RequestMethod.PUT)
    public void modificarEvento(@PathVariable(value = "idEvento") Integer idEvento, @RequestBody Evento evento){
        EventoSource.modificarEvento(idEvento, evento.getNombre(), evento.getDescripcion());
    }

}
