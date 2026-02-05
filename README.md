# Java Backend REST API - Sample Task

## Overview
This is a **simple Java backend application** implementing a **RESTful API** for managing a collection of items.  
The project demonstrates **CRUD operations**, **input validation**, and includes **API documentation**.

**Use Case:** E-commerce system (like Flipkart) or movie collection system (like Netflix).

---

## Features

### Item Model
Each item has:

- **id** (Integer)  
- **name** (String)  
- **description** (String)  
- Additional fields can be added if needed.

### In-Memory Storage
- Uses an `ArrayList` to store items temporarily.

### RESTful API Endpoints

| Endpoint        | Method | Description                    |
|-----------------|--------|--------------------------------|
| `/items`        | POST   | Add a new item                 |
| `/items/{id}`   | GET    | Get a single item by ID        |
| `/items`        | GET    | Get all items (optional)       |
| `/items/{id}`   | DELETE | Delete an item by ID (optional)|
| `/items/{id}`   | PUT    | Update an item by ID (optional)|

### Input Validation
- Required fields must be present.  
- Validates constraints like **non-empty `name`**.

---

## Project Structure

src/
├── main/
│ ├── java/
│ │ └── com.example.items/
│ │ ├── controller/ # REST controllers
│ │ ├── model/ # Item class
│ │ └── service/ # Business logic & in-memory storage
│ └── resources/
│ └── application.properties


---

## Requirements
- **Java 17+**  
- **Maven** (for building)  
- Optional: **Postman** (for API testing)  

---

## How to Run

1. **Clone the repo:**  
```bash
git clone <repo-link>
cd <project-folder>
Build using Maven:

mvn clean install
Run the app:

mvn spring-boot:run
Test the API:

Base URL: http://localhost:8080/items

Use Postman or browser to test endpoints.

Example Requests
Add Item (POST /items):

{
  "id": 1,
  "name": "Sample Item",
  "description": "This is a sample item."
}
Get Item (GET /items/1):

{
  "id": 1,
  "name": "Sample Item",
  "description": "This is a sample item."
}
Notes
Data is in-memory, lost when app stops.

Can be hosted on Vercel, Netlify, or Heroku for demo.
