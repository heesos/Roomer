FROM openjdk:17-jdk-alpine
MAINTAINER Milosz Marzec
RUN echo "This is an image of the Roomer server"
COPY app/target/*.jar roomer.jar
ENTRYPOINT ["java","-jar","/roomer.jar"]
