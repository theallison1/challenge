package com.challenge.controller;

import com.challenge.dto.ResponseDtoPersona;
import com.challenge.model.Persona;
import com.challenge.servicePersona.ServicePersonaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/persona")
public class ControllerPersona {

    @Autowired
    ServicePersonaImpl servicePersona;
    @PostMapping("/crear")
    public ResponseEntity<ResponseDtoPersona> crearPersona(@Valid @RequestBody Persona persona) {
        return servicePersona.crearPersona(persona);
    }

}
