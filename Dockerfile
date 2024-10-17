# Use a base image that includes Java
FROM openjdk:17-jdk-slim

# Copy the JAR file into the container
COPY target/docker-0.0.1-SNAPSHOT.jar docker-0.0.1-SNAPSHOT.jar

# Expose the port the app runs on
EXPOSE 9090

# Run the application
CMD ["java", "-jar", "docker-0.0.1-SNAPSHOT.jar"]
