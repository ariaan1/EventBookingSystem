🎟️ Event Booking Platform

A backend application built with Java and Spring Boot that allows users to browse events, book tickets, and enables administrators to manage events.

📌 Project Description

This project simulates a real-world event booking system, following clean architecture principles and best practices in backend development.

Users can:

Browse available events
Book tickets
View their booking history

Administrators can:

Create new events
Update existing events
Delete events


🏗️ Architecture

The project follows a Layered Architecture:

Controller Layer → Handles HTTP requests and responses
Service Layer → Contains business logic
Repository Layer → Handles database operations
Entity & DTO Layer → Defines data structures and data transfer


🛠️ Technologies Used
Java 17+
Spring Boot
Spring Web
Spring Data JPA
Hibernate
PostgreSQL / MySQL
Lombok
Swagger (OpenAPI) for API documentation
Maven for dependency management


⚙️ Features
User registration and login (basic authentication)
Event management (CRUD operations)
Ticket booking system with validation (no overbooking)
Booking history tracking
Clean separation of concerns using DTOs
API documentation with Swagger


🗄️ Database Design

Main entities:

User
Event
Booking

Key relationships:

A user can have multiple bookings
An event can have multiple bookings
Each booking belongs to one user and one event



🚀 Getting Started
1. Clone the repository
git clone https://github.com/your-username/EventBookingSystem.git
cd EventBookingSystem
2. Configure the database

Update your application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/event_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3. Run the application
mvn spring-boot:run
4. Access Swagger UI
http://localhost:8080/swagger-ui.html
📖 API Examples
Create Event
POST /api/events
Get All Events
GET /api/events
Book Tickets
POST /api/bookings


🧠 Learning Goals

This project was built to:

Understand layered architecture in Spring Boot
Learn how to design RESTful APIs
Practice database relationships (One-to-Many, Many-to-One)
Implement business logic in the service layer
Use DTOs instead of exposing entities
Work with real-world backend scenarios


📌 Future Improvements
JWT Authentication & Authorization
Role-based access control (ADMIN / USER)
Payment integration
Email notifications
Frontend integration (Vue.js)


👨‍💻 Author

Arian Aliu
