
# Use OpenJDK base image
FROM openjdk:17-jdk-slim
LABEL authors="bhavsharma"

#ENTRYPOINT ["top", "-b"]


# Set working directory
WORKDIR /app

# Copy JAR file from target folder
COPY target/springbootkafka-0.0.1-SNAPSHOT.jar app.jar

# Expose application port
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java","-jar","app.jar"]
