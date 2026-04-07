# springboot-microservices-platform

Cloud-native microservices platform built using **Spring Boot,Spring Cloud,Eureka, API Gateway, Feign Client, H2, Docker, Kubernetes, and AWS**.
This project is created for **hands-on learning** covering end-to-end microservices communication with service discovery and containerization.

---

# 🏗️ Architecture

                ┌─────────────┐
                │  API Gateway│
                └──────┬──────┘
                       │
                ┌──────▼──────┐
                │   Eureka    │
                │ Discovery   │
                └──────┬──────┘
                       │
        ┌──────────────┴──────────────┐
        │                             │
┌───────▼────────┐           ┌────────▼────────┐
│ product-service │           │  order-service  │
└────────────────┘           └─────────────────┘

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

# Tech Stack
   Java 17
   Spring Boot
   Spring Cloud Gateway
   Eureka Service Discovery
   OpenFeign
   Spring Data JPA
   H2 Database
   Docker
   Maven

# Services:

1. discovery-server
   Eureka server
   Port: 8761
   Service registry
2. api-gateway
   Routes requests to services
   Port: 8080
3. product-service
   Product catalog management
   Port: 8082
4. order-service
   Order creation
   Calls product-service via Feign
   Port: 8083
5. user-service
6. payment-service
7. notification-service

---

# API Endpoints

Create Product

POST /products

{
  "name": "iPhone",
  "description": "Apple phone",
  "price": 80000,
  "stock": 10
}
Get Products

GET /products

Create Order

POST /orders
{
  "userId": 1,
  "items": [
    {
      "productId": 1,
      "quantity": 2
    }
  ]
}


# 🚀 Services & Ports

API Gateway → 8080
User Service → 8081
Product Service → 8082
Order Service → 8083
Payment Service → 8084
Notification Service → 8085

---

# Run Using Docker

Build jars: mvn clean package

Run containers: docker-compose up

Services:

Service	            Port
API Gateway	         8080
Eureka	            8761
Product Service	   8082
Order Service	      8083

# Features Implemented

   Microservices architecture
   API Gateway routing
   Eureka service discovery
   Feign client communication
   Order with multiple products
   Separate database per service
   Docker containerization
   Load-balanced routing via gateway

# ⚙️ Requirements

Install:

Java 17
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

Project SDK = 17
Module SDK = 17

---

# Git Setup

Initialize repo

git init
git add .
git commit -m "Initial microservices setup"

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

Future Enhancements
   Circuit Breaker (Resilience4j)
   Config Server
   Distributed tracing
   Kubernetes deployment
   Authentication (JWT)
   Centralized logging

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

# Author

Anupama Singh
Senior Java Developer
Spring Boot | Microservices | SAP Commerce | AWS
