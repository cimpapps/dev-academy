FROM openjdk:8-jdk-alpine

COPY target/*.jar /server.jar

ENTRYPOINT ["java", "-jar","/server.jar"]
