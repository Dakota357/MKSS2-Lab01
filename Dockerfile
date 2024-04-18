FROM openjdk:17-jdk-alpine
LABEL authors="malte"
EXPOSE 8080
MAINTAINER hsbremen.mkss.lab
COPY target/lab-0.0.1-SNAPSHOT.jar lab-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/lab-0.0.1-SNAPSHOT.jar"]