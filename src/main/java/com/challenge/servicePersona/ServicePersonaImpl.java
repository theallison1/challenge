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

import java.time.LocalDate;
import java.time.Period;
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

        ResponseEntity<String> stringResponseEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        if (esMayor(persona.getFechaNac())) {
            //buscar por dni si existe la persona
            Optional<Persona> persoExist = repositoryPersona.findByDni(persona.getNumeroDoc());

            if (persoExist.isPresent()) {
                stringResponseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("La persona ya existe , no puede ser creada nuevamente");
            } else if(tieneDatoContacto(persona)) {
                Persona persona1 = repositoryPersona.save(buildPersonaToRequestPersona(persona));
                stringResponseEntity = ResponseEntity.status(HttpStatus.OK).body("La persona con dni :" + persona1.getNumeroDoc()
                        + " fue creada con exito");
                logger.info("la persona con dni Nº :" + persona.getNumeroDoc() + " se creo exitosamente");
            }else {
                stringResponseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("Debe tener al menos un dato de contacto , email o telefono!!");
            }
        } else {
            stringResponseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("La persona debe ser mayor a 18 años para poder crearse");
        }


        return stringResponseEntity;
    }

    @Override
    public ResponseEntity<String> actualizarPersona(Long idPesona, RequestDtoPersona requestDtoPersona) {
        ResponseEntity<String> stringResponseEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        Optional<Persona> persona = repositoryPersona.findById(idPesona);
        if (persona.isPresent()) {
            if (tieneDatoContacto(requestDtoPersona)){
                Persona personaUpdate = buildPersonaToRequestPersona(requestDtoPersona);
                personaUpdate.setId(idPesona);
                repositoryPersona.save(personaUpdate);
                stringResponseEntity = ResponseEntity.status(HttpStatus.OK).body("La persona fue actualizada correctamente ");
                logger.info("la persona  se actualizo exitosamente");
            }else {
                stringResponseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("Debe tener al menos un dato de contacto , email o telefono!!");
            }

        } else {
            stringResponseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("La persona no se encontro !");
        }
        return stringResponseEntity;
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

    private Persona buildPersonaToRequestPersona(RequestDtoPersona requestDtoPersona) {
        Persona persona = new Persona.PersonaBuilder()
                .nombre(requestDtoPersona.getNombre())
                .paisNac(requestDtoPersona.getPaisNac())
                .numeroDoc(requestDtoPersona.getNumeroDoc())
                .apellido(requestDtoPersona.getApellido())
                .fechaNac(requestDtoPersona.getFechaNac())
                .sexo(requestDtoPersona.getSexo())
                .nacionalidad(requestDtoPersona.getNacionalidad())
                .tipoDoc(requestDtoPersona.getTipoDoc())
                .email(requestDtoPersona.getEmail())
                .telefono(requestDtoPersona.getTelefono())
                .build();
        return persona;
    }

    private Boolean esMayor(LocalDate fechaNac1) {
        Boolean mayor = false;

        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac1, ahora);
        System.out.printf("Tu edad es: %s años, %s meses y %s días",
                periodo.getYears(), periodo.getMonths(), periodo.getDays());
        if (periodo.getYears() >= 18) {
            mayor = true;
        }
        return mayor;
    }
    private Boolean tieneDatoContacto(RequestDtoPersona requestDtoPersona){
        Boolean datosContacto = false;
        if (requestDtoPersona.getTelefono()!=null&& requestDtoPersona.getEmail()!=null&&
            !requestDtoPersona.getTelefono().equals("")&& !requestDtoPersona.getEmail().equals("")){
            datosContacto=true;

        }
        return datosContacto;
    }
}
