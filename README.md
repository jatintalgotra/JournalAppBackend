# 📓 Journal API — Spring Boot

A simple journal logging API built with Spring Boot, focused on clean structure and RESTful design.  
S
## ✅ Features (Phase 1)

- User registration & journal entries
- DTO-based responses to avoid recursion
- CRUD endpoints for journal management
- Minimal, open API (no auth for now)

---

## 📦 Tech Stack

- Java 21
- Spring Boot
- Maven
- Spring Web, JPA
- MySQL

---

## 📬 Sample Endpoints

| Method | Endpoint                     | Description                     |
|--------|------------------------------|---------------------------------|
| GET    | `/api/users`                 | Get all users                   |
| GET    | `/api/users/{username}`      | Get user by username            |
| GET    | `/api/journals/{username}`   | Get all journals of a user      |
| POST   | `/api/journals/{username}`   | Add journal entry for user      |
| PUT    | `/api/journals/{id}`         | Update journal entry by ID      |
| DELETE | `/api/journals/id/{id}`      | Delete journal entry by ID      |

---

## 📌 Notes

- No authentication yet (for quick deployment/demo)
- Response objects use DTOs for clarity
- Journal count included in user DTO for performance

---

## 📅 Upcoming (Phase 2 Plan)

- JWT Authentication
- Swagger/OpenAPI docs
- Role-based access
- Caching with Redis
- Deployment via Docker

---

## 👤 Author

**Jatin Talgotra**

> This is a Phase 1 demo for testing.  
