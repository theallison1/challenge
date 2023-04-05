package com.challenge.controller;

import com.challenge.dto.RequestDtoPersona;
import com.challenge.model.Persona;
import com.challenge.servicePersona.ServicePersona;
import com.challenge.servicePersona.ServicePersonaImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;


@RestController
@RequestMapping("/persona")
public class ControllerPersona {

    @Autowired
    ServicePersonaImpl servicePersona;
    Logger logger = LoggerFactory.getLogger(ControllerPersona.class);

    @PostMapping("/crear")
    public ResponseEntity<String> crearPersona(@Valid @RequestBody RequestDtoPersona persona, Errors errors) {
        logger.info("Endpoint crear persona ejecutandose....");
        if (errors.hasErrors()) {
            logger.error("faltan datos en los siguientes campos " +errors.getFieldError().toString());
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear persona!!! todos los campos son obligatorios");
        }
        return servicePersona.crearPersona(persona);
    }

    @GetMapping("/listarPersonas")
    public ResponseEntity<List<Persona>> listarPersonas() {

       return servicePersona.listarPersonas();

    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String>  borrarPersona(@NotBlank @PathVariable Long id) {

        return servicePersona.eliminarPersona(id);

    }

    @PutMapping(value = "/actualizar/{id}")
    public ResponseEntity<String> updatePersona(@RequestBody RequestDtoPersona person, @PathVariable("id") Long id ) {
        return   servicePersona.actualizarPersona(id,person);

    }
}
