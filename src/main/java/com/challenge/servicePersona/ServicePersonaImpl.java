package com.challenge.servicePersona;

import com.challenge.dto.RequestDtoPersona;
import com.challenge.model.Persona;
import com.challenge.repository.RepositoryPersona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicePersonaImpl implements ServicePersona {
    @Autowired
    RepositoryPersona repositoryPersona;
    Logger logger = LoggerFactory.getLogger(ServicePersona.class);

    @Override
    public ResponseEntity<List<Persona>> listarPersonas() {
        logger.info("servicio de listar personas ");
        ResponseEntity<List<Persona>> listResponseEntity = new ResponseEntity<List<Persona>>(HttpStatus.BAD_REQUEST);
        List<Persona> listaPersona = new ArrayList<Persona>();

        listaPersona = repositoryPersona.findAll();
        if (listaPersona.isEmpty()) {
            logger.info("la lista se encuentra vacia ");
            listResponseEntity = ResponseEntity.status(HttpStatus.FOUND).body(listaPersona);
        } else {
            listResponseEntity = ResponseEntity.status(HttpStatus.OK).body(listaPersona);
            logger.info("lista de personas , la cantidad de personas es:  " + listaPersona.size());
        }


        return listResponseEntity;


    }

    @Override
    public ResponseEntity<String> crearPersona(RequestDtoPersona persona) {
        //buscar por dni si existe la persona
        Optional<Persona> persoExist = repositoryPersona.findByDni(persona.getNumeroDoc());
        ResponseEntity<String> stringResponseEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        if (persoExist.isPresent()) {
            stringResponseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("La persona ya existe , no puede ser creada nuevamente");
        }else{
            Persona persona1 = repositoryPersona.save(buildPersonaToRequestPersona(persona));
            stringResponseEntity = ResponseEntity.status(HttpStatus.OK).body("La persona con dni :" + persona1.getNumeroDoc()
                    + " fue creada con exito");
            logger.info("la persona con dni Nº :" + persona.getNumeroDoc() + " se creo exitosamente");
        }

        return stringResponseEntity;
    }

    @Override
    public Persona actualizarPersona(Long idPesona) {
        return null;
    }

    @Override
    public ResponseEntity<String> eliminarPersona(Long idPersona) {


        ResponseEntity<String> personaEliminada = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

        Optional<Persona> persona = repositoryPersona.findById(idPersona);
        if (persona.isPresent()) {
            repositoryPersona.deleteById(idPersona);
            personaEliminada = ResponseEntity.status(HttpStatus.OK).body("La persona ha sido borrada correctamente");
        } else {
            logger.error("la persona no existe con el id: " + idPersona);
            personaEliminada = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La persona que intenta borrar no existe");
        }


        return personaEliminada;
    }
    private Persona buildPersonaToRequestPersona(RequestDtoPersona requestDtoPersona){
        Persona persona= new Persona.PersonaBuilder()
                .setNombre(requestDtoPersona.getNombre())
                .setPaisNac(requestDtoPersona.getPaisNac())
                .setNumeroDoc(requestDtoPersona.getNumeroDoc())
                .setApellido(requestDtoPersona.getApellido())
                .setFechaNac(requestDtoPersona.getFechaNac())
                .setSexo(requestDtoPersona.getSexo())
                .nacionalidad(requestDtoPersona.getNacionalidad())
                .setTipoDoc(requestDtoPersona.getTipoDoc())
                .build();


        return persona;
    }
}
