FROM openjdk:8-jre-alpine

ENV JAVA_OPTS=""

EXPOSE 8080

ADD *.jar /app.jar

CMD echo "TechStore application starting..." && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar
