FROM openjdk:8-jdk-alpine

COPY target/*.jar /server.jar

RUN ls /

ENTRYPOINT ["java", "-jar","/server.jar"]
