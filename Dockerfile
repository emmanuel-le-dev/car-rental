#Generate Build
FROM maven:3.9.5-eclipse-temurin-17-alpine as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -Dmaven.test.skip=true

#Dockerize
FROM eclipse-temurin:17-jdk-ubi9-minimal
WORKDIR /app
COPY --from=build /app/target/car_rental_management-0.0.1-SNAPSHOT.jar ./car_rental.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "car_rental.jar" ]
