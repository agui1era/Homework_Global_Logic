# Spring Boot Project

This project is a web application developed with Spring Boot, designed to demonstrate the implementation and testing of a basic user management system, including registration and JWT (JSON Web Token) generation.
## Getting Started

To get a working copy of the project in a local environment for development and testing, follow these instructions.

### Prerequisites

You must have installed:

- JDK 8 or higher
- Maven

### Installation

To compile the project and run tests, run:

```bash
mvn clean install
```

To start the application, use:

```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

### Run Tests

To run unit and integration tests, run:

```bash
mvn test
```

## API Documentation with Swagger UI

API documentation is available through Swagger UI, making it easy to test and visualize the available endpoints. Swagger UI can be accessed by visiting `http://localhost:8080/swagger-ui.html`, providing an interactive interface for exploring the API's functionality.

## Postman Collection

A Postman collection (`BCI.postman_collection.json`) has been included in the project root. This collection contains preconfigured examples of API requests, allowing you to easily test the various operations available. To use it, simply import the `BCI.postman_collection.json` file into Postman.

## Usage

Once the application is running, you can:

- Register a new user by sending a `PUT` request to `/user`.

## Built with

- [Spring Boot](https://spring.io/projects/spring-boot) - The framework used for Spring-based Java applications.
- [Maven](https://maven.apache.org/) - The dependency manager.
- [JUnit](https://junit.org/junit5/) - The framework used for unit testing.
