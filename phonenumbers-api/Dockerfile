FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
ADD sample.db sample.db
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080