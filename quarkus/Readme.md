# TechStore
This application runs with:
- Java 11
- Quarkus 0.20.0
    - quarkus-resteasy
    - quarkus-resteasy-jsonb
    - quarkus-jdbc-h2
- PostgreSQL
- Quarkus Hibernate Panache
- Lombok 1.18.8
- H2 Database during Maven test scope
- Junit 5
- Docker and Docker Compose

## Docker Compose
To build the solution:
    
    - mvn clean install -U
    - docker-compose up
