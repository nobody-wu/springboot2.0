FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD spring-boot-docker-2.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]