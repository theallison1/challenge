package com.challenge.servicePersona;

import com.challenge.dto.ResponseDtoPersona;
import com.challenge.model.Persona;
import com.challenge.repository.RepositoryPersona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePersonaImpl implements ServicePersona {
    @Autowired
    RepositoryPersona repositoryPersona;
    Logger logger = LoggerFactory.getLogger(ServicePersona.class);

    @Override
    public List<Persona> listarPersonas() {

        List<Persona> listaPersona = repositoryPersona.findAll();
        if (listaPersona.isEmpty()) {
            System.out.println("no existen persona");
        }

        return listaPersona;
    }

    @Override
    public ResponseEntity<ResponseDtoPersona> crearPersona(Persona persona) {
        logger.info("Crear persona service con id :"+ persona.getId());
        try {
            repositoryPersona.save(persona);
            logger.info("la persona id :"+ persona.getId()+" se creo exitosamente");

        } catch (Exception ex) {
            logger.error(ex.getMessage());

        }


        ResponseDtoPersona responseDtoPersona = new ResponseDtoPersona(persona.getNombre(), persona.getApellido());
        return ResponseEntity.status(HttpStatus.OK).body(responseDtoPersona);
    }

    @Override
    public Persona actualizarPersona(Long idPesona) {
        return null;
    }

    @Override
    public ResponseDtoPersona eliminarPersona(Long idPersona) {
        return null;
    }
}
