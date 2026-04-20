# FunkyTap

**FunkyTap** is a minimalist mobile app for people with ADHD who work out at the gym.

It solves one problem: keeping track of workout progress without losing focus. Users set up their gym clubs and equipment in advance. During the workout, a single tap is enough to log completed work on a machine or exercise.

The mobile application is developed as a separate React Native project. This repository contains the backend application.

## Project Overview

**FunkyTap** demonstrates the development of a Kotlin/Ktor backend for a mobile fitness application with modular monolith architecture, DDD-based feature boundaries, REST API, OpenAPI contract, PostgreSQL persistence, Firebase authentication, and CI/CD preparation.

The project focuses on low cognitive load, simple workout tracking, and clear backend architecture.

## Project Status

The project is in early backend development.

The current repository contains backend architecture planning, project documentation, API design, and initial module structure. Implementation is in progress.

## Tech Stack

- Kotlin
- Ktor
- PostgreSQL
- Firebase Auth
- OpenAPI
- Docker

## Project Tools

- Gradle
- Exposed
- Flyway
- kotlinx.serialization
- JUnit5
- MockK

## Architecture

FunkyTap is designed as a **modular monolith** based on **Domain-Driven Design** principles.

Business feature modules:

- User
- Catalog
- Workout
- Analytics

Each feature contains its own business boundaries and follows the same internal structure:

- Application
- Domain
- Infrastructure

The presentation layer is separated into dedicated modules:

- `openapi` — API contract and generated transport models
- `http` — HTTP routing and request handling
- `app` — application bootstrap and framework configuration

The project also contains a shared infrastructure module:

- `infra` — shared technical infrastructure used by backend modules

## Architectural Rules

- Invariants are protected inside entities through constructors.
- Logic related to one aggregate stays inside the entity.
- Logic involving multiple aggregates is moved to a Domain Service.
- Orchestration, transactions, and flush are handled in Application Services.
- Repositories only load and save data; they do not contain business logic.
- Features communicate through interfaces.
- The React Native frontend is a separate application in a separate repository.

## API

FunkyTap exposes a REST API described through OpenAPI.

The API covers user accounts, gym clubs, training items, muscle groups, workout sessions, workout entries, workout summaries, goals, and analytics.

The OpenAPI contract is used for code generation and keeps the backend API explicit and documented.

## Main Business Features

- User registration and authentication through Firebase Auth
- User profile management
- Gym club management
- Shared catalog of machines and exercises
- Muscle group catalog for machine categorization
- Workout session creation
- One-tap machine completion during workout
- Latest working weight saving per machine
- Workout completion and summary generation
- Workout history
- Weekly goal tracking
- Basic workout analytics

## Documentation

1. Product and Analysis
    1. [Target Audience](docs/funkytap-target-audience.md)
    2. [Functional Requirements](docs/funkytap-functional-requirements.md)
    3. [Use Cases](docs/funkytap-use-cases.md)

2. Architecture and API
    1. [API Description](docs/funkytap-api-description.md)