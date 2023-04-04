package com.challenge.controller;

import com.challenge.dto.RequestDtoPersona;
import com.challenge.model.Persona;
import com.challenge.servicePersona.ServicePersonaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;


@RestController
@RequestMapping("/persona")
public class ControllerPersona {

    @Autowired
    ServicePersonaImpl servicePersona;

    @PostMapping("/crear")
    public ResponseEntity<String> crearPersona(@Valid @RequestBody RequestDtoPersona persona) {
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
}
