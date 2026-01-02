# InfinitCart – E-Commerce Backend Project Overview

## 📌 Project Description

InfinitCart is a backend-driven **E-Commerce application** developed using **Spring Boot** that provides core online shopping functionalities such as user management, product handling, cart operations, and secure authentication. The project is designed with clean architecture principles, focusing on scalability, security, and real-world backend practices.

This project simulates how a real e-commerce platform works behind the scenes and serves as a strong foundation for building full-stack or production-ready systems.

---

## 🛠️ Tech Stack Used

* **Java** – Core programming language
* **Spring Boot** – Backend framework
* **Spring Data JPA (Hibernate)** – ORM & database interaction
* **Spring Security** – Password encryption and security configuration
* **MySQL** – Relational database
* **Swagger UI** – API documentation and testing
* **Postman** – API testing
* **Maven** – Dependency management

---

## 🧩 Project Architecture

The project follows a **layered architecture**:

* **Controller Layer** – Handles HTTP requests and responses
* **Service Layer** – Contains business logic
* **Repository Layer** – Handles database operations using JPA
* **Entity Layer** – Represents database tables
* **DTO Layer (where applicable)** – Used to safely transfer data between client and server

This separation ensures maintainability, readability, and scalability.

---

## 🔐 Security Features

* Password encryption using **BCryptPasswordEncoder**
* Secure user registration
* Sensitive fields protected from direct exposure
* Ready for JWT / role-based authentication extension

---

## 👤 User Module

* User registration
* Secure password storage
* Fetching user details
* UUID-based primary keys for better security

---

## 📦 Product Module

* Add new products
* Fetch all products
* Fetch product by ID
* Structured product entity with pricing and inventory support

---

## 🛒 Cart Module

* Create cart for users
* Add products to cart
* Update item quantity
* Remove items from cart
* Automatic price calculation

The cart system is designed using **Cart** and **CartItem** entities to follow real-world e-commerce design patterns.

---

## 📄 API Documentation

* Integrated **Swagger UI** for easy API exploration
* All endpoints are documented and testable directly from the browser

---

## 🎯 Project Goals

* Understand real-world backend development
* Learn Spring Boot best practices
* Implement clean architecture
* Gain hands-on experience with REST APIs
* Build a strong portfolio-ready backend project

---

## 🚀 Future Enhancements

* JWT authentication & role-based authorization
* Order & payment modules
* Admin dashboard
* Product search & filtering
* Pagination & sorting
* Frontend integration (React / Angular)

---
