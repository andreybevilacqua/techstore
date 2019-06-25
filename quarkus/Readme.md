# TechStore
This application runs with:
- Quarkus 0.17.0

## Docker

To build Docker container: `docker build -f src/main/docker/Dockerfile.jvm .`
To run Docker container: `docker run -p 8080:8080 $IMAGE_ID`

## Documentation

### API Documentation
This application uses Swagger and Swagger UI.
To see the web dashboard, go to: http://localhost:8080/swagger-ui
