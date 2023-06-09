package com.challenge.controller;

import com.challenge.service.ServiceRelaciones;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ControllerRelaciones {

    @Autowired
    ServiceRelaciones serviceRelaciones;
    @ApiOperation(value = "crear vinculos entre personas ", response = ResponseEntity.class)
    @PostMapping("/personas/{id1}/vinculos/{vinculo}/{id2}")
    public ResponseEntity<String> crearPersona(@Valid @PathVariable String id1,@PathVariable String vinculo,@PathVariable String id2) {

        return serviceRelaciones.guardarRelaciones(id1,vinculo,id2);
    }
    @ApiOperation(value = "buscar relaciones de personas por id ", response = ResponseEntity.class)
    @GetMapping("/relaciones/{id}")
    public ResponseEntity<?> listarRelaciones(@PathVariable String id) {

        return serviceRelaciones.mostrarRelaciones(id);

    }
}
