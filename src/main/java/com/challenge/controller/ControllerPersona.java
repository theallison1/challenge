package com.challenge.controller;

import com.challenge.dto.RequestDtoPersona;
import com.challenge.dto.ResponseDtoEstadisticas;
import com.challenge.dto.ResponseDtoPersona;
import com.challenge.model.Persona;
import com.challenge.service.ServiceEstadisticas;
import com.challenge.service.ServicePersonaImpl;
import io.swagger.annotations.ApiOperation;
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
    @Autowired
    ServiceEstadisticas serviceEstadisticas;

    @ApiOperation(value = "crear persona ", response = String.class)
    @PostMapping("/crear")
    public ResponseEntity<String> crearPersona(@Valid @RequestBody RequestDtoPersona persona) {

        return servicePersona.crearPersona(persona);
    }
    @ApiOperation(value = "listar todas las  personas ", response = ResponseEntity.class)
    @GetMapping("/listarPersonas")
    public ResponseEntity<List<Persona>> listarPersonas() {

       return servicePersona.listarPersonas();

    }
    @ApiOperation(value = "buscar persona por id ", response = ResponseEntity.class)
    @GetMapping("/buscarPersona/{id}")
    public ResponseEntity<?> buscarPersona(@PathVariable Long id) {

        return servicePersona.buscarPersonaById(id);

    }
    @ApiOperation(value = "eliminar persona por id ", response = ResponseEntity.class)
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String>  borrarPersona(@NotBlank @PathVariable Long id) {

        return servicePersona.eliminarPersona(id);

    }
    @ApiOperation(value = "actualizar persona ", response = ResponseEntity.class)
    @PutMapping(value = "/actualizar/{id}")
    public ResponseEntity<String> updatePersona(@RequestBody RequestDtoPersona person, @PathVariable("id") Long id ) {
        return   servicePersona.actualizarPersona(id,person);

    }
    @ApiOperation(value = "mostrar estadisticas ", response = ResponseEntity.class)
    @GetMapping("/estadisticas")
    public ResponseEntity<ResponseDtoEstadisticas> listar() {

        return serviceEstadisticas.cantidadHombres();

    }


}
