FROM maven:3.9.6-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk

WORKDIR /app


COPY --from=builder /app/target/P_Search_Username-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
