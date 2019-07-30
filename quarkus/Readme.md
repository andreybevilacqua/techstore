# TechStore
This application runs with:
- Java 8
- Quarkus 0.19.1
    - quarkus-resteasy
    - quarkus-resteasy-jsonb
    - quarkus-jdbc-h2
- Lombok 1.18.8
- H2 Database
- Quarkus Hibernate Panache
- Junit 5

## Docker

To build Docker container: `docker build -f src/main/docker/Dockerfile.jvm .`
To run Docker container: `docker run -i -p 8080:8080 quarkus/techstore`
