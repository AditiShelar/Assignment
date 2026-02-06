# Java Backend REST API - Assignment

## Overview
This is a **reactive Java backend application** implementing a **RESTful API** for managing a collection of items.
The project demonstrates **CRUD operations**, **input validation**, **reactive programming** using Spring WebFlux, and includes **API documentation** with Swagger/OpenAPI.

**Use Case:** E-commerce system (like Flipkart) or movie collection system (like Netflix).

---

## Features

### Item Model
Each item has:

- **id** (Long)
- **name** (String)
- **description** (String)

### Database
- Uses **H2 Database** (In-Memory) with **R2DBC** for reactive database access.
- The schema is automatically initialized on startup.

### RESTful API Endpoints

| Endpoint             | Method | Description              |
|----------------------|--------|--------------------------|
| `/api/items`         | POST   | Add a new item           |
| `/api/items/{id}`    | GET    | Get a single item by ID  |
| `/api/items`         | GET    | Get all items            |

### Input Validation
- Required fields must be present.
- Validates constraints like **non-empty `name`**.

### API Documentation
- **Swagger UI** is available at: `http://localhost:8080/swagger-ui.html`

---

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.asigmaventures.assignment/
│   │       ├── config/        # Configuration classes (OpenAPI, DB Init)
│   │       ├── controller/    # REST controllers
│   │       ├── entity/        # Item entity
│   │       ├── exception/     # Exception handling
│   │       ├── repository/    # R2DBC Repository
│   │       └── service/       # Business logic
│   └── resources/
│       └── application.properties
```

---

## Requirements
- **Java 17+**
- **Maven** (for building)

---

## Getting Started

1. **Clone the repository** (if applicable)

2. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access API Documentation:**
   Open your browser and navigate to:
   [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

5. **Test the API:**

   **Base URL:** `http://localhost:8080/api/items`

   **Example Requests:**

   *   **Add Item (POST `/api/items`):**
       ```json
       {
         "name": "Sample Item",
         "description": "This is a sample item."
       }
       ```

   *   **Get Item (GET `/api/items/{id}`):**
       ```json
       {
         "id": 1,
         "name": "Sample Item",
         "description": "This is a sample item."
       }
       ```

   *   **Get All Items (GET `/api/items`):**
       ```json
       [
         {
           "id": 1,
           "name": "Sample Item",
           "description": "This is a sample item."
         }
       ]
       ```

---

## Notes
- Data is stored in an in-memory H2 database and will be lost when the application stops.
- The application uses Spring WebFlux for non-blocking I/O.
