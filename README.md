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

| Endpoint      | Method | Description              |
|---------------|--------|--------------------------|
| `/items`      | POST   | Add a new item           |
| `/items/{id}` | GET    | Get a single item by ID  |

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

2 .Build the project using Maven:

mvn clean install


3 . Run the application:

mvn spring-boot:run


4 .Test the API:

Base URL: http://localhost:8080/items

Use Postman or browser to test endpoint


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

Data is in-memory, lost when the application stops.

Can be hosted on Vercel, Netlify, or Heroku for demo purposes.
