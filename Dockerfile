FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/app.jar /app/app.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]