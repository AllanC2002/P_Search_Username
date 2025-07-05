# Search by Username Microservice

## Project Overview

This project is a Spring Boot microservice designed to search for users by their email address. It utilizes Spring Data JPA for database interaction (configured for MySQL) and Spring Security for handling security aspects, though currently, all endpoints are permitted without authentication.

The service exposes a single RESTful API endpoint to perform the user search.

## Folder Structure

The project follows a standard Maven project structure. Key directories include:

-   **`.mvn/`**: Contains Maven wrapper files, allowing the project to be built with a specific Maven version without requiring a global installation.
-   **`.github/`**: Contains GitHub Actions workflow definitions, for example, `docker-publish.yml` suggests a CI/CD pipeline for building and publishing Docker images.
-   **`src/main/java/com/allan/P_Search_Username/`**: Contains the main Java source code for the application.
    -   **`PSearchUsernameApplication.java`**: The main Spring Boot application class that bootstraps the application.
    -   **`config/`**: Contains configuration classes, such as `SecurityConfig.java` for Spring Security settings.
    -   **`controller/`**: Contains Spring MVC controllers that handle incoming HTTP requests (e.g., `UserController.java`).
    -   **`model/`**: Contains JPA entity classes that represent the data structure (e.g., `User.java`).
    -   **`repository/`**: Contains Spring Data JPA repository interfaces for database operations (e.g., `UserRepository.java`).
    -   **`service/`**: Contains service classes that encapsulate business logic (e.g., `UserService.java`).
-   **`src/main/resources/`**: Contains application resources.
    -   **`application.properties`**: Configuration file for Spring Boot, including database connection details, server port, etc.
-   **`src/test/java/`**: Contains unit and integration tests for the application.
-   **`pom.xml`**: The Project Object Model (POM) file for Maven, defining project dependencies, build configurations, and other project information.
-   **`dockerfile`**: Instructions for building a Docker image for the application.
-   **`.env`**: Typically used for storing environment variables (e.g., database credentials). This file is listed in `.gitignore` and should not be committed to version control.

## Backend Design Pattern

The application employs a **Layered Architecture**, a common pattern in Spring Boot applications, which can be seen as a variation of the Model-View-Controller (MVC) pattern adapted for RESTful services:

1.  **Presentation Layer (Controller)**: Handles HTTP requests, request validation, and response generation (e.g., `UserController`).
2.  **Service Layer**: Encapsulates business logic and orchestrates calls between the controller and repository layers (e.g., `UserService`).
3.  **Data Access Layer (Repository)**: Manages data persistence and retrieval using Spring Data JPA (e.g., `UserRepository`).
4.  **Model**: Represents the application's data entities (e.g., `User`).

## Communication Architecture

The microservice uses a **RESTful API over HTTP** communication architecture. It exposes endpoints that clients can interact with using standard HTTP methods. Spring MVC is used to build these RESTful services.

## Folder Pattern (within `src/main/java`)

The source code within `src/main/java/com/allan/P_Search_Username/` is organized using a **Layer-Based (or Package-by-Layer)** pattern. Classes are grouped into packages based on their architectural role:
-   `config`
-   `controller`
-   `model`
-   `repository`
-   `service`

## API Endpoints

### Search User by Email

-   **Endpoint**: `POST /search-user`
-   **Description**: Searches for a user by their email address.
-   **Request Body**:
    ```json
    {
        "user_mail": "example@example.com"
    }
    ```
-   **Responses**:
    -   **`200 OK`**: If the user is found.
        ```json
        {
            "idUser": 1,
            "name": "John",
            "lastname": "Doe",
            "userMail": "example@example.com",
            "password": "hashedpassword", // Note: Actual password hash would be returned
            "status": 1
        }
        ```
    -   **`404 Not Found`**: If the user is not found.
        ```text
        User not found
        ```

## How to Run

1.  **Prerequisites**:
    *   Java 21 (as specified in `pom.xml`)
    *   Maven
    *   A running MySQL instance.
2.  **Configuration**:
    *   Ensure you have a `.env` file in the project root with the necessary environment variables, especially for the database connection (e.g., `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`). Alternatively, configure these in `src/main/resources/application.properties`.
    Example `application.properties` for database:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_db_user
    spring.datasource.password=your_db_password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```
3.  **Build the project**:
    ```bash
    ./mvnw clean install
    ```
4.  **Run the application**:
    ```bash
    java -jar target/P_Search_Username-0.0.1-SNAPSHOT.jar
    ```
    Or, using the Maven Spring Boot plugin:
    ```bash
    ./mvnw spring-boot:run
    ```
The application will typically start on port 8080. You can then send requests to the `/search-user` endpoint using a tool like Postman or curl.
