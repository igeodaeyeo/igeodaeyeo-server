FROM openjdk:21-slim
ARG JAR_FILE=build/libs/*.jar
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]