package com.challenge.service;

import com.challenge.dto.RequestDtoPersona;
import com.challenge.model.Persona;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServicePersona {
    public ResponseEntity<List<Persona>> listarPersonas();

    ResponseEntity<String> crearPersona(RequestDtoPersona persona);

    public ResponseEntity<String> actualizarPersona(Long idPesona,RequestDtoPersona requestDtoPersona);
    public ResponseEntity<String>   eliminarPersona(Long idPersona);
}
