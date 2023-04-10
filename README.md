# challenge
PARA EJECUTAR ESTA APLICACION
SE NECESITA <br>
*#.JAVA 11<br>
*#.SPRING BOOT VERSION 2.7.10 <br>
*#.PARA LA BASE DE DATOS <br>
  EL CONECTOR MYSQL EN ESTE CASO  
  EN LA VERSION 8.0.32 <br>
*#MAVEN 
    HERRAMIENTA DE GESTION DE DEPENDENCIAS Y COMPILACION.<br>
    

    
*#http://localhost:8080/swagger-ui/index.html#/    
*#endpoints para pruebas una vez que el proyecto corre<br>
*ESTADISTICAS ENDPOINT<br>
*#http://localhost:8080/persona/estadisticas GET<br>
*CREAR ENDPOINT  
*#http://localhost:8080/persona/crear  POST
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
    
}<br>
*ELIMINAR ENDPOINT <br>
*#http://localhost:8080/persona/eliminar/{id}<br>

*LISTAR ENDPOINT <br>
*#http://localhost:8080/persona/listarPersonas<br>
*BUSCAR PERSONA POR {ID} ENDPOINT <br>
*#http://localhost:8080/persona/buscarPersona/{id}<br>
*ACTUALIZAR ENDPOINT <br>
*#http://localhost:8080/persona/actualizar/{id}
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
<br>
ENDPOINT DE RELACIONES
  para crear las relaciones<br>
.#http://localhost:8080/personas/{id1}/vinculos/{vinculo}/{id2}<br>

para ver la o las relaciones <br>
.#http://localhost:8080/relaciones/{id}




