# Use a base image with JDK 17 or 11
#Replace your-spring-app.jar with the actual name of your JAR file in the target directory.
FROM eclipse-temurin:23-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the application JAR file into the container
#
COPY target/your-spring-app.jar /app/app.jar

# Expose the port the app will run on
EXPOSE 8080

# Specify the command to run the application
CMD ["java", "-jar", "/app/app.jar"]
