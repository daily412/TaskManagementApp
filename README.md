# 🚀 Task Management API | Spring Boot 🛠️

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring--Boot-3.x-brightgreen)
![Build](https://img.shields.io/badge/Build-Gradle-important)
![Status](https://img.shields.io/badge/Status-Completed-success)

> **A clean, production-ready REST API for managing tasks.**  
> Built with **Spring Boot**, designed with best practices, DTOs, Exception Handling, JPA, Validation, and Unit Testing.

---

## ✨ Features
✅ Create a Task  
✅ Retrieve Task by ID  
✅ Input Validation (Status, Priority, Title, Due Date)  
✅ Custom Exception Handling  
✅ DTO Layer for Clean API Design  
✅ JPA + H2 / PostgreSQL  
✅ Ready for Extension (Search, Auth, Filtering)

---

## 📂 Project Structure
src/main/java/TaskManagerApp/TaskManager/
├── TaskManagerApplication.java
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── exception/
├── enums/

---

## 📄 API Endpoints

### ➕ Create a Task
POST /api/tasks

### ➕ Retrieve a Task 
GET /api/tasks/{id}

---

🛠️ Tech Stack

Java 17	Language

Spring Boot 3.x	Framework

Spring Data JPA	ORM / Database

H2 / PostgreSQL	Database

JUnit 5 / MockMvc	Unit Testing

Gradle	Build Tool
 ---

🏗️ Build & Run | 
🔨 Build

./gradlew clean build

🚀 Run

./gradlew bootRun

Or run via JAR:

java -jar build/libs/task-manager-0.0.1-SNAPSHOT.jar

🧪 Run Tests

./gradlew test

--- 

🔥 Sample Postman Endpoints
Action	URL	Status

Create Task	POST /api/tasks	201

Get Existing Task	GET /api/tasks/1	200

Get Non-Existing	GET /api/tasks/999	404

---

🚩 Future Improvements
Update / Delete endpoints

Authentication (JWT)

Filtering / Search / Pagination

PostgreSQL for Production

CI/CD Integration

