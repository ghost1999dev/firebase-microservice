FROM openjdk:17-jdk-slim

COPY target/firebasemicroservice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 5050
ENTRYPOINT [ "java","-jar","/app.jar" ]