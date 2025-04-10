# Build stage: compile and package the application using a Maven image
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src/ ./src/
RUN mvn clean package -DskipTests

LABEL maintainer="saulolv"

FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file from the build stage to the runtime stage
COPY --from=build /app/target/accounts-0.0.1-SNAPSHOT.jar ./accounts.jar

# Expose the port on which the application will run
EXPOSE 8081

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "accounts.jar"]