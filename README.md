# challenge
PARA EJECUTAR ESTA APLICACION
SE NECESITA 
#.JAVA 11
#.SPRING BOOT VERSION 2.7.10
#.PARA LA BASE DE DATOS
  EL CONECTOR MYSQL EN ESTE CASO  
  EN LA VERSION 8.0.32
#MAVEN 
    HERRAMIENTA DE GESTION DE DEPENDENCIAS Y COMPILACION.
    
    

*   [Resumen](#resumen)
    *   [Filosofía](#filosofía)
    *   [HTML en línea](#html-en-línea)
    *   [Escape automático para Caracteres Especiales](#escape-automático-para-caracteres-especiales)     
    
    
#http://localhost:8080/swagger-ui/index.html#/    
#endpoints para pruebas una vez que el proyecto corre
ESTADISTICAS ENDPOINT
#http://localhost:8080/persona/estadisticas GET
CREAR ENDPOINT  
#http://localhost:8080/persona/crear  POST
ejemplo de BODY
{
    
    "nombre":"juanca",
    "apellido":"123456",
    "tipoDoc":"dni",
    "numeroDoc":"3519937",
    "sexo":"hombre",
    "paisNac":"arge",
    "nacionalidad":"argentino",
    "fechaNac":"1991-01-18 ",
    "email":"nico.gmail.com",
    "telefono":"444"
    
}
ELIMINAR ENDPOINT /n
#http://localhost:8080/persona/eliminar/{id}
LISTAR ENDPOINT /n
#http://localhost:8080/persona/listarPersonas
ACTUALIZAR ENDPOINT /n
#http://localhost:8080/persona/actualizar/{id}
ejemplo de persona en el body a actualizar
{
    
    "nombre":"juanca",
    "apellido":"123456",
    "tipoDoc":"dni",
    "numeroDoc":"3519937",
    "sexo":"hombre",
    "paisNac":"arge",
    "nacionalidad":"argentino",
    "fechaNac":"1991-01-18 ",
    "email":"nico.gmail.com",
    "telefono":"444"
    
}

