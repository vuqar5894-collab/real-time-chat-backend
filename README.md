# Real-Time Chat Backend

A scalable real-time chat backend built with **Spring Boot, WebSocket, Redis, and PostgreSQL**.
The project demonstrates how modern messaging systems handle **real-time communication, authentication, message delivery states, and horizontal scalability**.

Inspired by messaging platforms such as **Slack and Discord**.

---

# Features

* JWT-based authentication and authorization
* Real-time messaging using WebSocket
* Redis Pub/Sub for message broadcasting across instances
* PostgreSQL for persistent message storage
* Message lifecycle states:

  * SENT
  * DELIVERED
  * SEEN
* Typing indicators
* Chat rooms
* Layered backend architecture
* Dockerized development environment

---

# Tech Stack

## Backend

* Java 21
* Spring Boot
* Spring Security
* Spring WebSocket
* Spring Data JPA

## Infrastructure

* PostgreSQL
* Redis
* Docker
* Docker Compose

---

# System Architecture

The backend is designed as a **real-time event-driven system**.

Client applications communicate with the server using **WebSocket for real-time messaging** and **REST APIs for authentication and management operations**.

Flow overview:

Client
│
WebSocket / REST
│
Spring Boot Application
│
Redis Pub/Sub
│
PostgreSQL

Redis Pub/Sub allows multiple application instances to **broadcast messages between nodes**, enabling horizontal scaling.

---

# Real-Time Messaging Flow

1. Client connects to WebSocket endpoint.
2. User sends a message to the server.
3. Server publishes the message to Redis.
4. Redis distributes the message to all active application instances.
5. Connected clients receive the message in real-time.

---

# Message Lifecycle

Messages move through several states to simulate real messaging platforms.

SENT → DELIVERED → SEEN

SENT
Message was successfully stored in the database.

DELIVERED
Message reached the recipient's client.

SEEN
Recipient opened the chat and viewed the message.

---

# Running the Project

## Using Docker

Build and start containers:

docker compose up --build

Server will start at:

http://localhost:8080

---

# Project Structure

src
├─ config
├─ controller
├─ dto
├─ entity
├─ repository
├─ security
├─ service
└─ util

The project follows a **layered architecture pattern**:

Controller → Service → Repository

---

# API Endpoints

## Authentication

Register

POST /api/auth/register

Login

POST /api/auth/login

---

# WebSocket Endpoint

ws://localhost:8080/ws

---

# WebSocket Events

Send message

/app/chat.send

Typing indicator

/app/chat.typing

Message seen

/app/chat.seen

---

# Author

Vugar
Backend Developer
