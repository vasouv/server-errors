# server-errors
Web application with endpoints for HTTP 200, 400 and 500. Useful for simple testing.

## Technologies
- Java 17
- Spring Boot 2.6.4

## Build and Run
Maven: `mvn spring-boot:run`

Java: `java -jar target\server-errors.jar`

## Endpoints
HTTP 200: `localhost:8080/errors/none`

HTTP 400: `localhost:8080/errors/client`

HTTP 500: `localhost:8080/errors/server`

HTTP random: `localhost:8080/errors/random`
