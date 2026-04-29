# 🎟️ Event Booking Platform

A backend application built with **Java and Spring Boot** that allows users to browse events, book tickets, and enables administrators to manage events.

---

## 📌 Project Description

This project simulates a real-world event booking system using **clean architecture principles** and best backend practices.

### 👤 Users can:

* Browse available events
* Book tickets
* View booking history

### 🛠️ Admins can:

* Create events
* Update events
* Delete events

---

## 🏗️ Architecture

The project follows a **Layered Architecture**:

* **Controller Layer** → Handles HTTP requests
* **Service Layer** → Contains business logic
* **Repository Layer** → Communicates with the database
* **DTO Layer** → Transfers clean data between layers

---

## 🛠️ Technologies Used

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* PostgreSQL / MySQL
* Lombok
* Swagger (OpenAPI)
* Maven

---

## ⚙️ Features

* User registration & login (basic)
* Event CRUD operations
* Ticket booking system (with validation)
* Booking history
* DTO-based clean API
* Swagger API documentation

---

## 🗄️ Database Design

### Main Entities:

* User
* Event
* Booking

### Relationships:

* One User → Many Bookings
* One Event → Many Bookings
* Each Booking → belongs to one User & one Event

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/EventBookingSystem.git
cd EventBookingSystem
```

---

### 2. Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/event_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3. Run the project

```bash
mvn spring-boot:run
```

---

### 4. Open Swagger UI

```
http://localhost:8080/swagger-ui.html
```

---

## 📖 API Endpoints

### Create Event

```
POST /api/events
```

### Get All Events

```
GET /api/events
```

### Book Tickets

```
POST /api/bookings
```

---

## 🧠 Learning Goals

* Understand Spring Boot architecture
* Build REST APIs
* Work with databases (JPA & relationships)
* Implement business logic correctly
* Use DTOs instead of entities

---

## 🔮 Future Improvements

* JWT Authentication
* Role-based authorization (ADMIN / USER)
* Payment integration
* Email notifications
* Frontend (Vue.js)

---

## 👨‍💻 Author

Arian Aliu
