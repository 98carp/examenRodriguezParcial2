FROM openjdk:17
LABEL authors="carodriguez"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} examenRodriguez.jar
ENTRYPOINT ["java", "-jar","examenRodriguez.jar"]