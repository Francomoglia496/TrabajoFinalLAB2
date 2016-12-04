package com.labii;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Scanner;


/**
 * Created by francomoglia on 11/28/16.
 */

@RestController
public class CalendarioController {

    @RequestMapping(value = "/calendario", method = RequestMethod.GET)
    public Collection<Calendario> getCalendario(){
        return CalendarioSource.getListaCalendarios();
    }

    @RequestMapping(value = "/calendario/{idCalendario}", method = RequestMethod.GET)
    public Calendario getCalendarioPorID(@PathVariable("idCalendario") Integer idCalendario){
        return CalendarioSource.getCalendario(idCalendario) ;
    }

    //Alta
    @RequestMapping(value = "/calendario/alta", method = RequestMethod.POST)
    public void altaCalendario(@RequestBody Calendario input){
        CalendarioSource.altaCalendario(input.getNombre(), input.getIdUsuario());
    }

    //Baja
    @RequestMapping(value = "/calendario/{idCalendario}/baja", method = RequestMethod.DELETE)
    public void bajaCalendario(@PathVariable(value = "idCalendario") Integer idCalendario){
        CalendarioSource.bajaCalendario(idCalendario);
    }

    //Modificar
    @RequestMapping(value = "/calendario/{idCalendario}/modificar", method = RequestMethod.PUT)
    public void modificarCalendario(@PathVariable(value = "idCalendario") Integer idCalendario, @RequestBody Calendario Calendario){
        CalendarioSource.modificarCalendario(idCalendario, Calendario.getNombre());
    }


}

