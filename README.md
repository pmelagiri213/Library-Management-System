# Library-Management-System

# 📚 Library Management System

This is a simple Library Management System developed using **Spring Boot** and **PostgreSQL**. The project follows a layered architecture and demonstrates how to perform CRUD operations using Spring Boot and Spring Data JPA.

---

## 🧩 Project Structure

All source code is located in the `src/main/java` directory and follows a clean layered architecture:


---

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

---

## 🗃️ Entity Classes

The following entities are created and mapped to PostgreSQL tables using JPA annotations:

- `Book`
- `Author`
- `Card`
- `Publisher`
- `User`

All entity classes are stored in the `entity` package.

---

## 📡 Controller Layer

All controller classes are placed under the `controller` package.  
They expose simple and commonly used **RESTful APIs** for CRUD operations on each entity.

---

## 🧠 Service Layer

The `service` package contains service classes that define the business logic for all CRUD operations.  
Controllers use these service classes to interact with the DAO layer.

---

## 🧩 DAO Layer

- The `dao` package contains interfaces that extend **JpaRepository** for each entity.
- These interfaces are responsible for direct interaction with the PostgreSQL database.
- Additional custom logic (if required) is implemented in the `daoImpl` package.

---

## 🗄️ Database Configuration

We use **PostgreSQL** as the database server.

Configuration is defined in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
