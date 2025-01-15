# Build stage
FROM gradle:8.1.1-jdk17 AS build
COPY --chown=gradle:gradle . /home/app/
WORKDIR /home/app
RUN ./gradlew clean assemble  # Gradle 빌드 실행

# Package stage
FROM openjdk:21-ea-17-slim-buster
COPY --from=build /home/app/build/libs/springboot-boilerplate-v1.jar /usr/local/lib/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]