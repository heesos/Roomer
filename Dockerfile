FROM openjdk:17-jdk-alpine
MAINTAINER Milosz Marzec
COPY app/target/*.jar roomer.jar
ENTRYPOINT ["java","-jar","/roomer.jar"]
