# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim-buster

# Set the working directory to /app
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/TodoApp-0.0.1-SNAPSHOT.jar /app/your-spring-boot-app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "your-spring-boot-app.jar"]
