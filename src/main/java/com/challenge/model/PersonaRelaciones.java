package com.challenge.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "relaciones")
public class PersonaRelaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String persona1;
    private String persona2;
    private String eTipoRelaciones;

    public static class PersonaRelacionesBuilder{

        private Long id;
        private String persona1;
        private String persona2;
        private String eTipoRelaciones;

        public PersonaRelacionesBuilder() {
        }

        public PersonaRelacionesBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PersonaRelacionesBuilder setPersona1(String persona1) {
            this.persona1 = persona1;
            return this;
        }

        public PersonaRelacionesBuilder setPersona2(String persona2) {
            this.persona2 = persona2;
            return this;

        }

        public PersonaRelacionesBuilder seteTipoRelaciones(String eTipoRelaciones) {
            this.eTipoRelaciones = eTipoRelaciones;
            return this;
        }
        public PersonaRelaciones build() {
            return new PersonaRelaciones( this);
        }
    }


    public PersonaRelaciones(PersonaRelacionesBuilder personaRelacionesBuilder) {
        this.id = personaRelacionesBuilder.id;
        this.persona1 = personaRelacionesBuilder.persona1;
        this.persona2 = personaRelacionesBuilder.persona2;
        this.eTipoRelaciones = personaRelacionesBuilder.eTipoRelaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersona1() {
        return persona1;
    }

    public void setPersona1(String persona1) {
        this.persona1 = persona1;
    }

    public String getPersona2() {
        return persona2;
    }

    public void setPersona2(String persona2) {
        this.persona2 = persona2;
    }

    public String geteTipoRelaciones() {
        return eTipoRelaciones;
    }

    public void seteTipoRelaciones(String eTipoRelaciones) {
        this.eTipoRelaciones = eTipoRelaciones;
    }
}
