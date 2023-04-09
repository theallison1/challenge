package com.challenge.service;

import com.challenge.dto.RelacionesPersonaDtoResponse;
import com.challenge.model.Persona;
import com.challenge.model.PersonaRelaciones;
import com.challenge.repository.RepositoryPersona;
import com.challenge.repository.RepositoryRelaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class ServiceRelaciones {

    @Autowired
    RepositoryRelaciones repositoryRelaciones;
    @Autowired
    RepositoryPersona repositoryPersona;

    public ResponseEntity<String> guardarRelaciones(String id1, String eTipoRelaciones, String id2) {
        ResponseEntity<String> response ;
        if (!validatorPersonaById(id1)) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("la persona que intenta relacionar con el id :" + id1 + " no existe");
        } else if (!validatorPersonaById(id2)) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("la persona que intenta relacionar con el id :" + id2 + " no existe");
        } else {

            repositoryRelaciones.save(buildPersonaRela(id1, eTipoRelaciones, id2));
            response = ResponseEntity.status(HttpStatus.OK).body("se guardo bien la relacion entre el id 1 :" + id1
                    + "y la persona con id :" + id2 + "  la relacion es: " + eTipoRelaciones);
        }

        return response;
    }

    public ResponseEntity<?> mostrarRelaciones(String id) {

        List<PersonaRelaciones> personaRelaciones = repositoryRelaciones.findByPersona1(id);
        List<PersonaRelaciones> personaRelaciones2 = repositoryRelaciones.findByPersona2(id);

        List<RelacionesPersonaDtoResponse> listaRelaciones ;

        ResponseEntity<?> response ;

        if (personaRelaciones2.isEmpty() && personaRelaciones.isEmpty()) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("debe indicar un id valido para listar relaciones!");
        } else if (!personaRelaciones.isEmpty() && personaRelaciones2.isEmpty()) {

            listaRelaciones = buildLisResponse(personaRelaciones, true);
            response = ResponseEntity.status(HttpStatus.OK).body(listaRelaciones);

        } else if (personaRelaciones.isEmpty() ) {
            listaRelaciones = buildLisResponse(personaRelaciones2, false);
            response = ResponseEntity.status(HttpStatus.OK).body(listaRelaciones);

        } else {
            listaRelaciones=buildLisResponseComplete(personaRelaciones,personaRelaciones2);
            response = ResponseEntity.status(HttpStatus.OK).body(listaRelaciones);
        }


        return response;
    }


    private PersonaRelaciones buildPersonaRela(String id1, String eTipoRelaciones, String id2) {
        return new PersonaRelaciones.PersonaRelacionesBuilder()
                .persona1(id1)
                .persona2(id2)
                .eTipoRelaciones(eTipoRelaciones)
                .build();
    }

    private String validarRelaciones(String relacion) {
        String relaFinal = "";
        String esHijo = " hijo";
        switch (relacion.toLowerCase()) {
            case "padre":
            case "madre":
                relaFinal = esHijo;
                break;
            case "tio":
            case "tia":
                relaFinal = " sobrino";
                break;
        }
        return relaFinal;
    }

    private Boolean validatorPersonaById(String id) {
        Optional<Persona> personaToFind = findById(Long.valueOf(id));


        return personaToFind.isPresent();
    }

    private Optional<Persona> findById(Long id) {
        return repositoryPersona.findById(id);
    }

    private List<RelacionesPersonaDtoResponse> buildLisResponse(List<PersonaRelaciones> list, boolean flag) {

        List<RelacionesPersonaDtoResponse> listaRelaciones = new ArrayList<RelacionesPersonaDtoResponse>();
        for (PersonaRelaciones p : list) {
            RelacionesPersonaDtoResponse relacionesPersonaDtoResponse = new RelacionesPersonaDtoResponse();

            if (flag) {
                relacionesPersonaDtoResponse.seteTipoRelaciones(p.geteTipoRelaciones());
                relacionesPersonaDtoResponse.setPersona1(p.getPersona1());
                relacionesPersonaDtoResponse.setPersona2(p.getPersona2());
            } else {
                relacionesPersonaDtoResponse.seteTipoRelaciones(validarRelaciones(p.geteTipoRelaciones()));
                relacionesPersonaDtoResponse.setPersona1(p.getPersona2());
                relacionesPersonaDtoResponse.setPersona2(p.getPersona1());
            }
            listaRelaciones.add(relacionesPersonaDtoResponse);

        }
        return listaRelaciones;
    }

    private List<RelacionesPersonaDtoResponse> buildLisResponseComplete(List<PersonaRelaciones> list,List<PersonaRelaciones> list2) {

        List<RelacionesPersonaDtoResponse> listaRelaciones = new ArrayList<RelacionesPersonaDtoResponse>();
        for (PersonaRelaciones p : list) {
            RelacionesPersonaDtoResponse relacionesPersonaDtoResponse = new RelacionesPersonaDtoResponse();
            relacionesPersonaDtoResponse.seteTipoRelaciones(p.geteTipoRelaciones());
            relacionesPersonaDtoResponse.setPersona1(p.getPersona1());
            relacionesPersonaDtoResponse.setPersona2(p.getPersona2());

            listaRelaciones.add(relacionesPersonaDtoResponse);

        }
        for (PersonaRelaciones p : list2) {
            RelacionesPersonaDtoResponse relacionesPersonaDtoResponse = new RelacionesPersonaDtoResponse();
            relacionesPersonaDtoResponse.seteTipoRelaciones(validarRelaciones(p.geteTipoRelaciones()));
            relacionesPersonaDtoResponse.setPersona1(p.getPersona2());
            relacionesPersonaDtoResponse.setPersona2(p.getPersona1());

            listaRelaciones.add(relacionesPersonaDtoResponse);

        }
        return listaRelaciones;
    }
}

