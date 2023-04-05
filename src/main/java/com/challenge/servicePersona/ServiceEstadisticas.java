package com.challenge.servicePersona;

import com.challenge.dto.ResponseDtoEstadisticas;
import com.challenge.repository.RepositoryPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceEstadisticas {

    @Autowired
    RepositoryPersona repositoryPersona;
    public ResponseEntity<ResponseDtoEstadisticas> cantidadHombres(){
        Integer cantHombre = repositoryPersona.findCantidadHombres();
        Integer cantMujeres = repositoryPersona.findCantidadMujeres();
        Integer cantArgentinos = repositoryPersona.findCantidadArgentinos();
        Integer porcentajeArgentinos = (cantArgentinos * 100)/ repositoryPersona.findCantidadPersonas();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDtoEstadisticas(cantHombre,cantMujeres,porcentajeArgentinos));
    }
}
