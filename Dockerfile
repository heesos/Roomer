FROM openjdk:20
MAINTAINER Milosz Marzec
RUN echo "This is an image of the Roomer server"
COPY app/target/app-0.0.1-SNAPSHOT.jar roomer.jar
ENTRYPOINT ["java","-jar","/roomer.jar"]
