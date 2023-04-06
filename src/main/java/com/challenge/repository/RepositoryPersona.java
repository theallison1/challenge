package com.challenge.repository;

import com.challenge.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryPersona extends JpaRepository<Persona,Long> {
    @Query("SELECT p FROM Persona p WHERE p.numeroDoc = ?1  ")
    Optional<Persona>findByDni(String dni);
    @Query("SELECT count(*) FROM Persona Where sexo like '%hombre%'")
    int findCantidadHombres();
    @Query("SELECT count(*) FROM Persona Where sexo like '%mujer%'")
    int findCantidadMujeres();
    @Query("SELECT count(*) FROM Persona Where nacionalidad like '%argentino%'")
    int findCantidadArgentinos();
    @Query("SELECT count(*) FROM Persona ")
    int findCantidadPersonas();
}
