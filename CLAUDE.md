# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

**FunkyTap** is a minimalist mobile app for people with ADHD who go to the gym.

**Problem:** it's easy to lose track of which machines you've already done during a workout.

**Solution:** tap a machine icon when you're done with it — no sets, reps, or timers.

**Core features:**
- Configure gyms and pick machines from a built-in catalog
- During a workout — mark a machine with a single tap
- Machine weight is remembered and auto-filled across all gyms

## Tech Stack

| Layer | Technology |
|---|---|
| Mobile | React Native (iOS + Android) |
| Backend | Ktor (Netty), JVM 23, Kotlin 2.3.0 |
| Database | PostgreSQL on AWS, Exposed 0.61.0, HikariCP |
| Migrations | Flyway |
| Auth | Firebase Auth (Google + email) |
| API | OpenAPI spec → Kotlin codegen (openapi-generator 7.13.0) |
| Serialization | kotlinx.serialization |
| DI | Koin 4.1.2 |
| Testing | JUnit 5 + MockK |
| Infrastructure | Docker, GitLab CI/CD |
| Machine images | AI-generated |

## Build & Run Commands

```bash
./gradlew build              # Build everything
./gradlew test               # Run all tests
./gradlew :module:test       # Run tests for a single module (e.g., ./gradlew :feature:catalog:test)
./gradlew run                # Run the server locally
./gradlew buildFatJar        # Build executable JAR with all dependencies
./gradlew buildImage         # Build Docker image
./gradlew runDocker          # Run using local Docker image
```

The server starts on `http://0.0.0.0:8080`.

## Architecture

Modular monolith with DDD. The React Native frontend is a separate app in a separate repository.

### Module Layout

- **`:app`** — Entry point. Wires together Ktor engine (Netty) and Koin DI. Has no business logic.
- **`:http`** — Presentation layer (shared): Ktor routes, request/response DTOs, plugins/middleware (auth, serialization, CORS, call logging, status pages, Swagger/OpenAPI).
- **`:infra`** — Shared infrastructure: Exposed ORM, PostgreSQL driver, HikariCP, Flyway, Firebase auth provider.
- **`:openapi`** — Generates Kotlin model/API classes from `spec/spec-funkytap-api.yml`. Generated sources land in `build/generated/src/main/kotlin` and compile automatically before `compileKotlin`.
- **`:feature:user`, `:feature:catalog`, `:feature:workout`, `:feature:analytics`** — Feature modules. Each contains Application, Domain, and Infrastructure layers only.

### Layer Responsibilities

- **Presentation** — input/output only: controllers, request/response DTOs, no logic. Lives in `:http`, shared across all features.
- **Application** — orchestration between Presentation and Domain: validation, DTO ↔ Domain mapping, transactions.
- **Domain** — business logic only; unaware of other layers and frameworks. Invariants enforced in entity constructors.
- **Infrastructure** — repository implementations, DB mapping, external integrations.

### Feature Responsibilities

**UserFeature** — `User`, `Goal`, profile data (`weight`, `height`, `age`, `gender`)
- User profile, auth data, goals (`workouts_per_week`)
- Does NOT calculate anything about workouts

**CatalogFeature** — `Gym`, `Exercise`, `MuscleGroup` and their relations
- Reference data / dictionaries, simple CRUD, no progress logic

**WorkoutFeature** — `WorkoutSession`, `WorkoutEntry`, `WorkoutSummary`
- Workout execution: recording entries and weights, session status, summary (duration, calories)

**AnalyticsFeature** — no own aggregates, reads from WorkoutFeature
- Weekly workout counts, goal achievement evaluation, progress aggregation for UI

**Ownership boundaries:**
- "User set a goal of 3 workouts/week" → UserFeature
- "User completed a workout" → WorkoutFeature
- "How many workouts did they do this week" → AnalyticsFeature
- "Did they reach their goal" → AnalyticsFeature
- "Color the week in the calendar" → AnalyticsFeature result (flag), rendering → UI

### Domain Entities

| Entity | Key Fields | Feature |
|---|---|---|
| `User` | name, email, password, avatar, weight, height, gender, age | UserFeature |
| `Goal` | user_id, workouts_per_week, start_date | UserFeature |
| `Gym` | user_id, title, picture | CatalogFeature |
| `Exercise` | title, picture, description, category | CatalogFeature |
| `MuscleGroup` | title, category, picture | CatalogFeature |
| `WorkoutSession` | user_id, start_datetime, end_datetime, status | WorkoutFeature |
| `WorkoutEntry` | workout_id, exercise_id, weight | WorkoutFeature |
| `WorkoutSummary` | workout_id, calories_burned, duration | WorkoutFeature |

**Relations:** `Gym` ↔ `Exercise` (many-to-many), `MuscleGroup` ↔ `Exercise` (many-to-many)

### DDD Rules

- Single aggregate → logic lives in the entity
- Multiple aggregates → use a Domain Service
- Repository does only fetch/save, no business logic
- Features communicate through interfaces, not direct dependencies

### Use Cases (draft)

1. User registers
2. User logs in
3. User adds a new gym
4. User does a workout for the first time (entering weights manually)
5. User does a workout without changing weight (auto-filled from last session)
6. User does a workout with updated weight
7. CRUD for all entities
8. User views statistics

### Post-MVP Features

- **Analytics:** calories burned per workout, total workout time (weekly/monthly)
- **Goals:** workouts_per_week target, calendar view showing which weeks the goal was met
- **Celebrations:** congratulation screen on workout completion and goal achievement

## Conventions

- All modules use the **`build-jvm`** convention plugin (defined in `build-plugin/`), which applies `org.jetbrains.kotlin.jvm` and sets JVM toolchain to **Java 23**.
- Dependency versions are centralized in `gradle/libs.versions.toml`. Always add new dependencies there.
- DI is done via **Koin**; modules are wired in `:app`.
- Database schema migrations are managed by **Flyway**.

### Adding a New Feature Module

1. Create `feature/<name>/build.gradle.kts` using `id("build-jvm")`.
2. Add `include(":feature:<name>")` to `settings.gradle.kts`.
3. Wire routes in `:http` and DI modules in `:app`.
