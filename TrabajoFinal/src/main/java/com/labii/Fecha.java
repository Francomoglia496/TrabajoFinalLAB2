package com.labii;

/**
 * Created by francomoglia on 11/28/16.
 */

public class Fecha {

    //      ATRIBUTOS
    private int dia;
    private int mes;
    private int anio;
    private int hora;
    private int minutos;


    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public Fecha(int dia, int mes, int anio, int hora, int minutos){

        if (dia > 0 && dia < 31) {
            this.dia = dia;
        }else {
            throw new IllegalArgumentException("Dia Invalido");
        }

        if (mes > 0 && mes <= 12) {
            this.mes = mes;
        }else {
            throw new IllegalArgumentException("Mes Invalido");
        }

        if (anio > 0) {
            this.anio = anio;
        }else {
            throw new IllegalArgumentException("Año Invalido");
        }

        if (hora >= 0 && hora < 24) {
            this.hora = hora;
        }else {
            throw new IllegalArgumentException("Hora Invalida");
        }

        if (minutos >= 0 && minutos < 60) {
            this.minutos = minutos;
        }else {
            throw new IllegalArgumentException("Minutos Invalidos");
        }
    }

    @Override
    public String toString() {

        if (minutos > 0 && minutos < 10) {
            return "Fecha: " + dia + "/" + mes + "/" + anio + "\n" +
                    "Hora: " + hora + ":0" + minutos;
        } else return "Fecha: " + dia + "/" + mes + "/" + anio + "\n" +
                "Hora: " + hora + ":" + minutos;
    }
}