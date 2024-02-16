
# Proyecto Spring Boot

Este proyecto es una aplicación web desarrollada con Spring Boot, diseñada para mostrar cómo implementar y probar un sistema básico de gestión de usuarios, incluyendo registro y autenticación con JWT (JSON Web Tokens).

## Comenzando

Sigue estas instrucciones para obtener una copia del proyecto en funcionamiento en tu entorno local para desarrollo y pruebas.

### Prerrequisitos

Necesitas tener instalado:

- JDK 8 o superior
- Maven

### Instalación

Compila el proyecto y ejecuta las pruebas:

```bash
mvn clean install
```

Ejecuta la aplicación:

```bash
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`.

### Ejecutar Pruebas

Para ejecutar las pruebas unitarias y de integración:

```bash
mvn test
```

## Uso

Una vez que la aplicación esté ejecutándose, podrás:

- Registrar un nuevo usuario enviando una petición `PUT` a `/user`.

## Construido con

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework para aplicaciones Java basadas en Spring.
- [Maven](https://maven.apache.org/) - Manejador de dependencias.
- [JUnit](https://junit.org/junit5/) - Framework para pruebas unitarias en Java.
