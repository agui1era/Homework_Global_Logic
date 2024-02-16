
# Proyecto Spring Boot

Este proyecto es una aplicación web desarrollada con Spring Boot, diseñada para demostrar la implementación y prueba de un sistema básico de gestión de usuarios, incluyendo el registro y la generación de JWT (JSON Web Tokens).
## Comenzando

Para obtener una copia del proyecto en funcionamiento en un entorno local para desarrollo y pruebas, se deben seguir las siguientes instrucciones.

### Prerrequisitos

Es necesario tener instalado:

- JDK 8 o superior
- Maven

### Instalación

Para compilar el proyecto y ejecutar las pruebas, se ejecuta:

```bash
mvn clean install
```

Para iniciar la aplicación, se utiliza:

```bash
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`.

### Ejecutar Pruebas

Para ejecutar las pruebas unitarias y de integración, se debe ejecutar:

```bash
mvn test
```

## Documentación API con Swagger UI

La documentación de la API se encuentra disponible a través de Swagger UI, lo que facilita la prueba y visualización de los endpoints disponibles. Se puede acceder a Swagger UI visitando `http://localhost:8080/swagger-ui.html`, proporcionando una interfaz interactiva para explorar la funcionalidad de la API.

## Colección de Postman

Se ha incluido una colección de Postman (`BCI.postman_collection.json`) en la raíz del proyecto. Esta colección contiene ejemplos preconfigurados de solicitudes a la API, permitiendo probar las diversas operaciones disponibles de manera fácil. Para utilizarla, solo se necesita importar el archivo `BCI.postman_collection.json` en Postman.

## Uso

Una vez la aplicación está ejecutándose, es posible:

- Registrar un nuevo usuario enviando una petición `PUT` a `/user`.

## Construido con

- [Spring Boot](https://spring.io/projects/spring-boot) - El framework utilizado para las aplicaciones Java basadas en Spring.
- [Maven](https://maven.apache.org/) - El gestor de dependencias.
- [JUnit](https://junit.org/junit5/) - El framework utilizado para las pruebas unitarias.
