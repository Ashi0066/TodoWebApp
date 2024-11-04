
<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="80" alt="Java logo" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" height="80" alt="Spring logo" />
</div>

## Spring MVC with JSP Project

### Introduction

This project is a Todo Web App with CRUD functionality built using Spring MVC with JSP (JavaServer Pages) for the view layer. It is designed as a learning exercise to understand the fundamentals of building a fully functional Spring MVC application, including form handling, validation, dependency injection, and basic authentication.

### Features

* CRUD (Create, Read, Update, Delete) operations for entities.
* Use of JSP for front-end pages.
* Use of Spring Beans and Dependency Injection.
* Use of Basic Spring Security.

### Technologies Used

* **Java 17** (or any compatible version).
* **Spring Framework 3.3.5**.
* **Spring MVC**.
* **JavaServer Pages (JSP)** for views.
* **Maven** for dependency management.
* **JPA** for Object Relational Mapping (ORM).
* **SQL 8** as a database.
* **Docker** for containerization.

### Project Structure

The project follows a typical structure for a Spring Boot MVC application with JSP:

```
TodoWebApp/
├── .idea/
├── .mvn/
│   └── wrapper/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── webapp/
│   │   │           └── springboot/
│   │   │               └── TodoWebApp/
│   │   │                   ├── login/
│   │   │                   ├── Repository/
│   │   │                   ├── Security/
│   │   │                   └── Todo/
│   │   └── resources/
│   │       ├── META-INF/
│   │       │   └── resources/
│   │       │       └── WEB-INF/
│   │       │           └── jsp/
│   │       │               └── common/
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/
│           └── com/
│               └── webapp/
│                   └── springboot/
│                       └── TodoWebApp/
```

### Directory Details

- **.idea/**: IntelliJ IDEA project configuration files.
- **.mvn/wrapper/**: Maven wrapper files to ensure that the correct version of Maven is used to build the project.
- **src/main/java/**: Contains the Java source code.
    - **com/webapp/springboot/TodoWebApp/login/**: Handles login-related classes.
    - **com/webapp/springboot/TodoWebApp/Repository/**: Manages database operations.
    - **com/webapp/springboot/TodoWebApp/Security/**: Handles security and authentication.
    - **com/webapp/springboot/TodoWebApp/Todo/**: Manages the core Todo entity and its business logic.
- **src/main/resources/**:
    - **META-INF/resources/WEB-INF/jsp/common/**: Contains JSP files used as view templates.
    - **static/**: Stores static resources such as CSS, JavaScript, and images.
    - **templates/**: Additional template files (if using an alternative to JSP, e.g., Thymeleaf).


### Prerequisites

- **Java JDK 17** or later.
- **Maven 3** for build management.
- **IDE** (IntelliJ IDEA, Eclipse, or Visual Studio Code recommended).


### Running the Application

#### Step 1: Clone the Repository

```sh
git clone https://github.com/Ashi0066/TodoWebApp.git
cd TodoWebApp
```

#### Step 2: Configure Database

- Update the `application.properties` file with your database configuration:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
  spring.datasource.username=root
  spring.datasource.password=yourpassword
  spring.jpa.hibernate.ddl-auto=update
  ```

#### Step 3: Build and Run the Project

Use Maven to build the project and start the server:

```sh
mvn clean install
mvn spring-boot:run
```

Alternatively, you can package the WAR file and deploy it to an external Tomcat server.

#### Step 4: Access the Application

- Open your web browser and navigate to: `http://localhost:8080`

### Usage

- **Homepage**: Displays a list of available features and a brief overview.
- **CRUD Operations**: Access CRUD functionalities through specific URLs (e.g., `/list-todos` or `/add-todo`).


### Troubleshooting

- **Port already in use**: Ensure that port 8080 is not being used by another application.
- **Database connection issue**: Make sure that your MySQL server is running and the credentials are correct.


Thanks for checking out this project! Happy coding!

