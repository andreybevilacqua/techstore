# TechStore
This application runs with:
- Java 8
- Spring Boot 2.1.5.RELEASE
- Spring Data JPA
- H2 Database
- Lombok 1.18.8
- Junit 5

## Docker

To build Docker container: `docker build -f src/main/docker/Dockerfile.jvm .`
To run Docker container: `docker run -p 8080:8080 $IMAGE_ID`
