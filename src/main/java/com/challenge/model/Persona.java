package com.challenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String tipoDoc;
    @NotNull
    private String numeroDoc;
    @NotNull
    private String sexo;
    @NotNull
    private String paisNac;
    @NotNull
    private String nacionalidad;
    @NotNull
    private LocalDate fechaNac;
    private String email;
    private String telefono;





    public static class PersonaBuilder{
        private Long id ;
        private String nombre;
        private String apellido;
        private String tipoDoc;
        private String numeroDoc;
        private String sexo;
        private String paisNac;
        private String nacionalidad;
        private LocalDate fechaNac;
        private String email;
        private String telefono;





        public PersonaBuilder() {

        }

        public PersonaBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PersonaBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public PersonaBuilder setApellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public PersonaBuilder setTipoDoc(String tipoDoc) {
            this.tipoDoc = tipoDoc;
            return this;
        }

        public PersonaBuilder setNumeroDoc(String numeroDoc) {
            this.numeroDoc = numeroDoc;
            return this;
        }

        public PersonaBuilder setSexo(String sexo) {
            this.sexo = sexo;
            return this;
        }

        public PersonaBuilder setPaisNac(String paisNac) {
            this.paisNac = paisNac;
            return this;
        }

        public PersonaBuilder setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
            return this;
        }

        public PersonaBuilder setFechaNac(LocalDate fechaNac) {
            this.fechaNac = fechaNac;
            return this;
        }

        public PersonaBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public PersonaBuilder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Persona build() {
            return new Persona( this);
        }


    }


    public Persona(PersonaBuilder personaBuilder) {
        this.id = personaBuilder.id;
        this.nombre = personaBuilder.nombre;
        this.apellido = personaBuilder.apellido;
        this.tipoDoc = personaBuilder.tipoDoc;
        this.numeroDoc = personaBuilder.numeroDoc;
        this.sexo = personaBuilder.sexo;
        this.paisNac = personaBuilder.paisNac;
        this.nacionalidad = personaBuilder.nacionalidad;
        this.fechaNac = personaBuilder.fechaNac;
        this.email= personaBuilder.email;
        this.telefono= personaBuilder.telefono;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPaisNac() {
        return paisNac;
    }

    public void setPaisNac(String paisNac) {
        this.paisNac = paisNac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }


}
