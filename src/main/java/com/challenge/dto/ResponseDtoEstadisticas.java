package com.challenge.dto;

public class ResponseDtoEstadisticas {
    private Integer cantidadHombre;
    private  Integer cantidadMujeres;
    private Integer porcentajeArgentinos;

    public ResponseDtoEstadisticas(Integer cantidadHombre, Integer cantidadMujeres, Integer porcentajeArgentinos) {
        this.cantidadHombre = cantidadHombre;
        this.cantidadMujeres = cantidadMujeres;
        this.porcentajeArgentinos = porcentajeArgentinos;
    }

    public Integer getCantidadHombre() {
        return cantidadHombre;
    }

    public void setCantidadHombre(Integer cantidadHombre) {
        this.cantidadHombre = cantidadHombre;
    }

    public Integer getCantidadMujeres() {
        return cantidadMujeres;
    }

    public void setCantidadMujeres(Integer cantidadMujeres) {
        this.cantidadMujeres = cantidadMujeres;
    }

    public Integer getPorcentajeArgentinos() {
        return porcentajeArgentinos;
    }

    public void setPorcentajeArgentinos(Integer porcentajeArgentinos) {
        this.porcentajeArgentinos = porcentajeArgentinos;
    }
}
