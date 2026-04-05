# springboot-microservices-platform

Cloud-native microservices platform built using **Spring Boot, API Gateway, Docker, Kubernetes, and AWS**.
This project is created for **hands-on learning** covering end-to-end microservices architecture.

---

# 🏗️ Architecture

Client → API Gateway → Microservices

Services:

* user-service
* product-service
* order-service
* payment-service
* notification-service

---

# 📁 Project Structure

springboot-microservices-platform
├── api-gateway
├── user-service
├── product-service
├── order-service
├── payment-service
├── notification-service
├── kubernetes
├── docs
└── README.md

---

# 🚀 Services & Ports

API Gateway → 8080
User Service → 8081
Product Service → 8082
Order Service → 8083
Payment Service → 8084
Notification Service → 8085

---

# ⚙️ Tech Stack

* Spring Boot
* Spring Cloud Gateway
* Maven
* Java 21
* H2 Database
* Docker (next)
* Kubernetes (next)
* AWS (next)

---

# ⚙️ Requirements

Install:

Java 21
Maven 3.9+
Git
IntelliJ Community Edition

Verify:

java -version
mvn -version
git --version

---

# ▶️ How to Run Services

Start services in order:

1. product-service
   Run: ProductServiceApplication

2. user-service
   Run: UserServiceApplication

3. order-service
   Run: OrderServiceApplication

4. api-gateway
   Run: ApiGatewayApplication

---

# 🌐 Access via API Gateway

http://localhost:8080/users
http://localhost:8080/products
http://localhost:8080/orders

---

# application.yml Example

server:
port: 8081

spring:
application:
name: user-service

---

# API Gateway Configuration

server:
port: 8080

spring:
application:
name: api-gateway

cloud:
gateway:
routes:
- id: user-service
uri: http://localhost:8081
predicates:
- Path=/users/**

```
    - id: product-service
      uri: http://localhost:8082
      predicates:
        - Path=/products/**

    - id: order-service
      uri: http://localhost:8083
      predicates:
        - Path=/orders/**
```

---

# IntelliJ Setup

Open IntelliJ
Click Open
Select root folder:

springboot-microservices-platform

Click Trust Project

Reload Maven project

Set SDK = Java 21

Run Application classes

---

# Maven Issues Fix

If Maven not detected:

Right click pom.xml
Reload Maven project

If settings.xml error:

Remove file:

~/.m2/settings.xml

Reload project again

---

# Java Version Error Fix

pom.xml

<properties>
  <java.version>21</java.version>
</properties>

Ensure IntelliJ:

Project SDK = 21
Module SDK = 21

---

# Disable Eureka (important)

If you see:

Connection refused localhost:8761

Add to api-gateway application.yml:

spring:
cloud:
discovery:
enabled: false

---

# Git Setup

Initialize repo

git init
git add .
git commit -m "Initial microservices setup"

---

# GitHub Push (Token Authentication)

GitHub does not support password authentication.

Create token:

https://github.com/settings/tokens

Push code:

git branch -M main
git remote add origin <repo-url>
git push -u origin main

Username:
your-github-username

Password:
paste-personal-access-token

---

# .gitignore

target/
.idea/
*.log
.DS_Store
.env
out/

---

# Commit These Files

pom.xml
src/
application.yml
mvnw
mvnw.cmd
.mvn/

Do NOT commit:

target/
.idea/
logs

---

# Health Check

http://localhost:8081/actuator/health
http://localhost:8082/actuator/health

---

# Next Steps

Add database per service
Add service-to-service communication
Add DTO layer
Add exception handling
Dockerize services
Add docker-compose
Add Kubernetes deployment
Deploy to AWS

---

# Goal

This project demonstrates:

Microservices architecture
API Gateway routing
Service isolation
Cloud-native design
Docker & Kubernetes readiness
Interview preparation project

---
