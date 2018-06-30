FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD springboot2.0.jar springboot2.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springboot2.0.jar"]