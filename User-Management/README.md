# User Management System

## Frameworks and Language Used
- Framework: Spring Boot
- Language: Java
- Database: MySQL (assumed based on Spring Data JPA usage)

## Data Flow

### 1. Controller
- **Controller Package:** `com.geekster.UserManagement.controller`

- Responsible for handling HTTP requests and responses.
- Defines RESTful API endpoints for user management.

### 2. Services
- **Service Package:** `com.geekster.UserManagement.service`

- Contains business logic for user management.
- Interacts with the Repository to perform CRUD operations.
- Provides services such as adding users, getting user details, updating user data, and deleting users.

### 3. Repository
- **Repository Interface:** `com.geekster.UserManagement.repo.IUserRepo`

- Extends Spring Data JPA's `JpaRepository` for handling database operations.
- Provides CRUD operations for the User entity.

### 4. Database Design
- The database design is not explicitly provided in the code.
- It's assumed to be a relational database, likely MySQL, based on Spring Data JPA usage.
- The User entity represents the schema for user-related data.

## Data Structure Used
- The project primarily uses the Java class `User` (com.geekster.UserManagement.model.User) as the data structure.
- This class maps to the database table for storing user data.
- Fields in the User class represent the data structure, including userId, name, userName, address, and phoneNumber.

## Project Summary
This project is a basic user management system built using the Spring Boot framework and Java language. It follows a typical layered architecture pattern with Controller, Services, and Repository components. The main functionality includes adding, retrieving, updating, and deleting user data through RESTful API endpoints. User data is stored in a relational database, and the User entity defines the data structure for this project.