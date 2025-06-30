# 🔐 Login & Registration System with Spring Security

A full-stack User Authentication System built using **Spring Boot**, **MySQL**, and a **simple HTML/CSS/JavaScript frontend**. This project now includes **Spring Security** integration for storing passwords securely using **BCrypt hashing**.

---

## ⚙️ Tech Stack

- Java 17  
- Spring Boot  
- Spring Web, Spring Data JPA  
- Spring Security ✅  
- MySQL  
- HTML, CSS, JavaScript  
- Lombok  
- Postman for API testing

---

## 🔧 Features

- 📝 User Registration with input validation
- 🔐 **Secure password storage with BCrypt encryption (Spring Security)**
- 🔐 Login with existing credentials
- ❌ Handles invalid login attempts with meaningful error messages
- 🔁 Redirects users to a new page upon successful login
- ✅ Prevents duplicate registrations using unique email check
- 🌐 CORS configured for frontend-backend communication
- 📄 Custom login form support (Spring Security override)
- 🚫 Default login page removed and replaced with project login page

---

## 🔐 Spring Security Integration

- Integrated `PasswordEncoder` using `BCryptPasswordEncoder`
- Passwords are now hashed before saving to the database
- Removed manual password matching logic — handled securely by Spring Security
- Custom login page configured instead of the default Spring login
- Public access allowed for registration and login endpoints
- Authenticated access required for protected endpoints

---

## 🧠 Skills Demonstrated

- RESTful API development with Spring Boot  
- Spring Security configuration and custom login form setup  
- Password encryption using BCrypt  
- User validation and exception handling  
- JavaScript fetch API for form submission  
- CORS handling for cross-origin frontend-backend integration  
- CRUD operations with MySQL via Spring Data JPA

---

## 📬 API Endpoints

| Method | Endpoint                  | Description                      |
|--------|---------------------------|----------------------------------|
| POST   | `/api/Auth/register`      | Register new user                |
| POST   | `/doLogin`                | Authenticate user (form login)   |
| GET    | `/api/Auth/registrations`| Get all registered users         |
| DELETE | `/api/Auth/delete/{id}`   | Delete user by ID                |

---

## ✅ Setup Instructions

1. Clone the repo  
2. Set up your MySQL database and update `application.properties`  
3. Run the Spring Boot app  
4. Serve your frontend from `http://127.0.0.1:5500` or similar  
5. Use Postman or frontend to test registration/login

---

