FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD user_service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=prod","-c"]
