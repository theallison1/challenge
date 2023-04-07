package com.challenge.controller;

import com.challenge.dto.RequestDtoPersona;
import com.challenge.model.ETipoRelaciones;
import com.challenge.model.Persona;
import com.challenge.service.ServiceRelaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerRelaciones {

    @Autowired
    ServiceRelaciones serviceRelaciones;
    @PostMapping("/personas/{id1}/vinculos/{vinculo}/{id2}")
    public ResponseEntity<String> crearPersona(@Valid @PathVariable String id1,@PathVariable String vinculo,@PathVariable String id2) {

        return serviceRelaciones.guardarRelaciones(id1,vinculo,id2);
    }
    @GetMapping("/relaciones/{id}")
    public ResponseEntity<?> listarRelaciones(@PathVariable String id) {

        return serviceRelaciones.mostrarRelaciones(id);

    }
}
