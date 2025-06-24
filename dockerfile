FROM maven:3.9.4-eclipse-temurin-17-alpine AS build

WORKDIR /app


COPY pom.xml .
COPY src ./src


RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app


COPY --from=build /app/target/P_Search_Username-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
