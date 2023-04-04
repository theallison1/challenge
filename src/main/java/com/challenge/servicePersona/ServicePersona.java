package com.challenge.servicePersona;

import com.challenge.dto.ResponseDtoPersona;
import com.challenge.model.Persona;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ServicePersona {
    public List<Persona> listarPersonas();
    public ResponseEntity<ResponseDtoPersona> crearPersona(Persona persona);
    public Persona actualizarPersona(Long idPesona);
    public ResponseDtoPersona eliminarPersona(Long idPersona);
}
