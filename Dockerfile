# Use a base image with Java and Maven installed
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project descriptor files
COPY pom.xml .

# Copy the source code
COPY src ./src

# Build the application with Maven
RUN mvn clean package

# Create a new image with only the necessary files
FROM openjdk:17-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the previous stage
COPY --from=build /app/target/*.jar HelloWorldApplication.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "HelloWorldApplication.jar"]