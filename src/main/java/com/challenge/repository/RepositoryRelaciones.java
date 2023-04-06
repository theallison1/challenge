package com.challenge.repository;

import com.challenge.model.PersonaRelaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryRelaciones extends JpaRepository<PersonaRelaciones,Long> {

    @Query("SELECT p FROM PersonaRelaciones p  WHERE p.persona1 =  ?1  ")
    Optional<PersonaRelaciones> findByPersona1( String id);
}
