# Dockerized Spring Boot GraphQL Application

This project is containerized using **Docker** and **Docker Compose**.

It runs:

* **Spring Boot Backend**
* **PostgreSQL Database**

---

# Prerequisites

Make sure installed:

* Docker
* Docker Compose (or Docker Desktop)

Check:

```bash
docker --version
docker compose version
```

---

# Project Structure

```text
.
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── src/
```

---

# Run Application

## Start Containers

```bash
docker compose up --build
```

This command will:

* Build Spring Boot image
* Start PostgreSQL container
* Start backend container

---

# Run in Background

```bash
docker compose up --build -d
```

---

# Stop Containers

```bash
docker compose down
```

---

# Access Application

## Backend API

```text
http://localhost:8080
```

## GraphQL Endpoint

```text
http://localhost:8080/graphql
```

## GraphiQL UI (if enabled)

```text
http://localhost:8080/graphql2?path=/graphql
```

---

# PostgreSQL Details

| Key      | Value       |
| -------- | ----------- |
| Host     | db          |
| Port     | 5432        |
| Database | employee_db |
| Username | postgres    |
| Password | root        |

If accessing locally:

```text
Host: localhost
Port: 5432
```

---

# Rebuild After Code Changes

```bash
docker compose up --build
```

---

# Remove Containers + Volumes

```bash
docker compose down -v
```

---

# Useful Commands

## View Running Containers

```bash
docker ps
```

## View Logs

```bash
docker compose logs -f
```

## Backend Logs Only

```bash
docker compose logs -f backend
```

---

# Notes

* Spring Boot waits for PostgreSQL container startup using `depends_on`
* Database URL inside Docker uses service name:

```text
jdbc:postgresql://db:5432/employee_db
```

---

# Author

Shaad Bangi
