# 📓 SastaCab Journal API

A backend journal logging system built with Spring Boot.

> 🚀 **Live Demo (Phase 1)**: [Your Deployment Link](https://your-backend-url)

## 🧾 Features

- CRUD operations for user journals
- RESTful API design
- DTO-based responses
- Phase 1: No authentication (open access)
- Ready for further development

## ⚙️ Tech Stack

- Java 17+
- Spring Boot
- Maven
- JPA (Hibernate)
- H2/MySQL (choose your setup)

## 📬 API Endpoints

| Method | Endpoint                  | Description               |
|--------|---------------------------|---------------------------|
| GET    | `/api/users`              | Get all users             |
| GET    | `/api/users/{username}`   | Get user by username      |
| GET    | `/api/journals/{username}`| Get all journals of user  |
| POST   | `/api/journals/{username}`| Create a new journal      |
| PUT    | `/api/journals/{id}`      | Update a journal          |
| DELETE | `/api/journals/id/{id}`   | Delete journal by ID      |

## 🧪 Postman

Use this sample journal payload:

```json
{
  "title": "My Day",
  "content": "Today I deployed my first Spring Boot app!"
}
