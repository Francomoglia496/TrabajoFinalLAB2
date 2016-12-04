package com.labii;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Created by francomoglia on 11/30/16.
 */

@RestController
public class UsuarioController {

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public Collection<Usuario> getUsuarios(){
        return UsuarioSource.getUsuarios();
    }

    @RequestMapping(value = "/usuarios/{idUsuario}", method = RequestMethod.GET)
    public Usuario getUsuarioPorID(@PathVariable("idUsuario") int idUsuario){
        return UsuarioSource.getUsuario(idUsuario);
    }

    //Alta Calendario con un Usuario
    @RequestMapping(value = "/usuarios/{idUsuario}/altaCalendario", method = RequestMethod.POST)
    public void altaCalendarioUsaurio(@PathVariable("idUsuario") int idUsuario, @RequestBody Calendario calendario){

        CalendarioSource.altaCalendario(calendario.getNombre(), idUsuario);

    }

    //Alta Eventos de Calendario con un Usuario
    @RequestMapping(value = "/usuarios/{idUsuario}/{idCalendario}/altaEvento", method = RequestMethod.POST)
    public void altaEventoCalendarioUsuario(@PathVariable("idCalendario") int idCalendario, @RequestBody Evento evento,
                                            int dia, int mes, int anio, int hora, int minuto, String color){

        EventoSource.altaEvento(evento.getNombre(), evento.getDescripcion(), evento.getIdCalendario(), dia,mes,anio,hora,minuto, color);

    }

    //Alta
    @RequestMapping(value = "/usuarios/alta", method = RequestMethod.POST)
    public void altaUsuario(@RequestBody Usuario input){

        UsuarioSource.altaUsuario(input.getNombre(), input.getEmail());
        //return HttpStatus.OK;

    }

    @RequestMapping(value = "/usuarios/{idUsuario}/baja", method = RequestMethod.DELETE)
    public void bajaUsuario(@PathVariable(value = "idUsuario") Integer idUsuario){
        UsuarioSource.bajaUsuario(idUsuario);
    }

    @RequestMapping(value = "/usuarios/{idUsuario}/modificar", method = RequestMethod.PUT)
    public void modifUsuario(@PathVariable(value = "idUsuario") Integer idUsuario, @RequestBody Usuario usuario){
        UsuarioSource.modifUsuario(idUsuario, usuario.getEmail());
    }

    /*
    @RequestMapping(value = "/usuarios/filtro", method = RequestMethod.GET)
    public Collection<Usuario> getPorEmail(@RequestParam(value = "email", defaultValue = "all") String email){
        if (email.equals("all")){
            return UsuarioSource.getUsuarios();
        }else {
            Collection result = new ArrayList();
            for (Usuario aux : UsuarioSource.getUsuarios()){
                if (aux.getEmail().equals(email)){
                    result.add(aux);
                }
            }
            return result;
        }
    }
    */

}