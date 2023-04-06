package com.challenge.service;

import com.challenge.model.ETipoRelaciones;
import com.challenge.model.PersonaRelaciones;
import com.challenge.repository.RepositoryPersona;
import com.challenge.repository.RepositoryRelaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.challenge.model.Persona;


import javax.persistence.EnumType;
import javax.persistence.Persistence;
import java.lang.annotation.ElementType;
import java.util.Optional;

@Service
public class ServiceRelaciones {

    @Autowired
    RepositoryRelaciones  repositoryRelaciones;
    @Autowired
    RepositoryPersona repositoryPersona;
 public ResponseEntity<String> guardarRelaciones(String id1, String eTipoRelaciones ,String id2){

     Optional<Persona> persona1 =repositoryPersona.findById(Long.valueOf(id1));
     Optional<Persona> persona2 =repositoryPersona.findById(Long.valueOf(id2));
     PersonaRelaciones personaRelaciones =repositoryRelaciones.save(buildPersonaRela(id1,eTipoRelaciones,id2));


     return ResponseEntity.status(HttpStatus.OK).body("se guardo bien la relacion entre el id 1 :"+id1
             +"/n la persona con id :"+id2+"/n y la relacion es: "+eTipoRelaciones);
 }
 public ResponseEntity<String> mostrarRelaciones(String id){

     Optional<PersonaRelaciones> personaRelaciones =repositoryRelaciones.findByPersona1(id);



     Optional<Persona> persona1 =repositoryPersona.findById(Long.valueOf(personaRelaciones.get().getPersona1()));
     Optional<Persona> persona2 =repositoryPersona.findById(Long.valueOf(personaRelaciones.get().getPersona2()));



     return ResponseEntity.status(HttpStatus.OK).body("la persona : "+ persona1.get().getNombre()
     + " es :"+personaRelaciones.get().geteTipoRelaciones()+" de  "+persona2.get().getNombre());
 }

 private PersonaRelaciones buildPersonaRela(String id1,String eTipoRelaciones,String id2){
        PersonaRelaciones personaRelaciones = new PersonaRelaciones.PersonaRelacionesBuilder()
                .persona1(id1)
                .persona2(id2)
                .eTipoRelaciones(eTipoRelaciones)
                .build();
     return personaRelaciones;
 }
}

