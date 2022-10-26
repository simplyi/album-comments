FROM openjdk:17-alpine
VOLUME /tmp 
COPY target/album-comments-0.0.1-SNAPSHOT.jar album-comments-microservice.jar 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/album-comments-microservice.jar"] 
