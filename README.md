# 🚀 Spring Boot GraphQL Employee Service

## 📌 Project Overview

This project demonstrates a **GraphQL API using Spring Boot** to manage Employee data. It follows a clean layered architecture:

* **Entity** → Represents database model
* **Repository** → Handles database operations
* **Service** → Business logic
* **GraphQL Controller (Resolver)** → Handles queries & mutations

The application supports:

* Creating employees (via **Input DTO** and **separate arguments**)
* Fetching all employees
* Fetching employee by UUID

---

## 🧱 Tech Stack

* Java 25
* Spring Boot
* Spring Data JPA
* Spring for GraphQL
* PostgreSQL
* Lombok

---

## 📂 Project Structure

```
com.example.demo
│
├── entity
│   └── Employee.java
│
├── repository
│   └── EmployeeRepository.java
│
├── service
│   └── EmployeeService.java
│
├── controller
│   ├── EmployeeController.java
│   └── EmployeeInput.java
│
└── resources
    ├── application.yml
    └── graphql/schema.graphqls
```

---

## 📊 GraphQL Basics (IMPORTANT 🔥)

GraphQL works differently from REST:

| REST               | GraphQL                    |
| ------------------ | -------------------------- |
| Multiple endpoints | Single endpoint `/graphql` |
| Fixed response     | Client decides response    |
| Over-fetching      | Exact data                 |
| Under-fetching     | No issue                   |

---

## 🧠 Core Concepts

### 🔹 Query

Used to fetch data

```graphql
query {
  employees {
    name
    email
  }
}
```

---

### 🔹 Mutation

Used to create/update/delete

```graphql
mutation {
  createEmployee(input: {...}) {
    name
  }
}
```

---

### 🔹 Type vs Input (VERY IMPORTANT ⭐)

#### ✅ `type` → Used for OUTPUT (Response)

```graphql
type Employee {
  employeeId: ID
  name: String
}
```

👉 Represents data returned by server

---

#### ✅ `input` → Used for INPUT (Request)

```graphql
input EmployeeInput {
  name: String
  email: String
}
```

👉 Represents data sent by client

---

### ❌ Why NOT use `type` as argument?

```graphql
createEmployee(emp: Employee) ❌ NOT ALLOWED
```

#### Reasons:

1. **Separation of concerns**

   * `type` = response
   * `input` = request

2. **Avoid circular references**

   * `type` can contain nested relationships

3. **Security**

   * Prevent user from sending restricted fields (like salary, id)

4. **Flexibility**

   * Input and output structures can be different

---

### 🧠 Easy Rule to Remember

👉 **type = response, input = request**

---

## ⚙️ GraphQL Schema

```graphql
type Employee {
    employeeId: ID
    name: String
    email: String
    age: Int
    department: String
    salary: Float
}

input EmployeeInput {
    name: String
    email: String
    age: Int
    department: String
    salary: Float
}

type Query {
    employees: [Employee]
    employeeById(id: ID): Employee
}

type Mutation {
    createEmployee(input: EmployeeInput): Employee
    createEmployeeArgs(
        name: String,
        email: String,
        age: Int,
        department: String,
        salary: Float
    ): Employee
}
```

---

## 🧪 Example Usage

### ✅ Create Employee (Input)

```graphql
mutation {
  createEmployee(input: {
    name: "Shaad",
    email: "shaad@gmail.com",
    age: 23,
    department: "DevOps",
    salary: 60000
  }) {
    employeeId
    name
  }
}
```

---

### ✅ Create Employee (Args)

```graphql
mutation {
  createEmployeeArgs(
    name: "Ali",
    email: "ali@gmail.com",
    age: 25,
    department: "Backend",
    salary: 70000
  ) {
    employeeId
    name
  }
}
```

---

### ✅ Fetch Employees

```graphql
query {
  employees {
    name
    email
    department
  }
}
```

---

## ⚙️ Configuration (`application.yml`)

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/employee_db
    username: postgres
    password: postgres

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

  graphql:
    graphiql:
      enabled: true

server:
  port: 8080
```

---

## 🔥 Advanced GraphQL Concepts (Must Know)

### 1️⃣ Field Selection

Client chooses fields:

```graphql
employees {
  name
}
```

👉 Backend sends only `name`

---

### 2️⃣ Nested Queries

GraphQL supports relationships easily

```graphql
employee {
  department
}
```

---

### 3️⃣ Strong Typing

Schema acts like contract between frontend & backend

---

### 4️⃣ Single Endpoint

Everything works via:

```
POST /graphql
```

---

## 💡 GraphQL Use Cases in Spring Boot

### ✅ 1. Microservices Aggregation

Combine multiple services into one API

👉 Useful in:

* E-commerce
* Banking dashboards

---

### ✅ 2. Frontend Flexibility

Frontend decides required fields

👉 React/Angular apps love this

---

### ✅ 3. Mobile Apps

Avoid extra data → saves bandwidth

---

### ✅ 4. Complex Data Relationships

Better than REST for nested data

---

### ✅ 5. API Gateway Replacement

GraphQL can act as smart API layer

---

## ⚠️ When NOT to Use GraphQL

* Simple CRUD apps (REST is enough)
* File uploads (more complex)
* Very high caching scenarios

---

## 🚀 Future Enhancements

* Pagination & Filtering
* Authentication (JWT)
* Role-based access control
* GraphQL Subscriptions (real-time)
* Docker + Kubernetes deployment

---

## 🧠 Final Takeaway

* GraphQL gives **flexibility + efficiency**
* `input` and `type` separation ensures **security & clarity**
* Best suited for **modern frontend-heavy applications**

---

## 🙌 Author

**Shaad Bangi**

---

If you want next upgrade 🔥
👉 I can help you add:

* GraphQL validation (`@Valid`)
* Exception handling
* Production-ready structure
* Docker + K8s deployment (DevOps style 😎)
