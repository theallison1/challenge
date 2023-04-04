package com.challenge.servicePersona;

import com.challenge.dto.RequestDtoPersona;
import com.challenge.dto.ResponseDtoPersona;
import com.challenge.model.Persona;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ServicePersona {
    public ResponseEntity<List<Persona>> listarPersonas();

    ResponseEntity<String> crearPersona(RequestDtoPersona persona);

    public Persona actualizarPersona(Long idPesona);
    public ResponseEntity<String>   eliminarPersona(Long idPersona);
}
