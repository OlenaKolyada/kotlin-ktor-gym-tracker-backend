# API Description

## 1. Entities

### User

| Field | Business Description | Example Value |
|------|----------------------|---------------|
| id | Unique user identifier | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c123" |
| firebaseUid | User identifier from Firebase Auth | "firebase_uid_abc123" |
| name | User name | "Olena" |
| email | User email address | "olena@example.com" |
| avatarUrl | User avatar URL | "https://storage.example.com/avatar.png" |
| weight | User weight | 62.5 |
| height | User height | 168 |
| birthDate | User birth date | "1992-05-14" |
| gender | User gender | "female" |
| createdAt | Profile creation date | "2026-04-19T10:00:00Z" |
| updatedAt | Profile last update date | "2026-04-19T12:00:00Z" |

### Gym

| Field | Business Description | Example Value |
|------|----------------------|---------------|
| id | Unique gym club identifier | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c124" |
| userId | Identifier of the gym club owner | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c123" |
| title | Gym club name | "Basic-Fit Bordeaux" |
| pictureUrl | Gym club image URL | "https://storage.example.com/gym.png" |
| availableTrainingItemIds | List of training items available in the gym club | ["018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c125"] |
| createdAt | Gym club creation date | "2026-04-19T10:00:00Z" |
| updatedAt | Gym club last update date | "2026-04-19T12:00:00Z" |

### TrainingItem

| Field | Business Description | Example Value |
|------|----------------------|---------------|
| id | Unique training item identifier | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c125" |
| title | Machine or exercise name | "Leg Press" |
| slug | Human-readable technical identifier | "leg-press" |
| pictureUrl | Image URL | "https://storage.example.com/leg-press.png" |
| description | Machine or exercise description | "Machine exercise for lower body strength" |
| category | Training item category | "machine" |
| muscleGroupIds | List of related muscle groups | ["018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c126"] |
| createdAt | Record creation date | "2026-04-19T10:00:00Z" |
| updatedAt | Record last update date | "2026-04-19T12:00:00Z" |

### MuscleGroup

| Field | Business Description | Example Value |
|------|----------------------|---------------|
| id | Unique muscle group identifier | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c126" |
| title | Muscle group name | "Quadriceps" |
| category | Muscle group category | "legs" |
| pictureUrl | Image URL | "https://storage.example.com/quadriceps.png" |
| createdAt | Record creation date | "2026-04-19T10:00:00Z" |
| updatedAt | Record last update date | "2026-04-19T12:00:00Z" |

### WorkoutSession

| Field | Business Description | Example Value |
|------|----------------------|---------------|
| id | Unique workout session identifier | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c127" |
| userId | User identifier | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c123" |
| gymId | Identifier of the gym club where the workout takes place | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c124" |
| startDateTime | Workout start date and time | "2026-04-19T18:00:00Z" |
| finishDateTime | Workout finish date and time | "2026-04-19T19:10:00Z" |
| status | Workout status | "active" |
| createdAt | Session creation date | "2026-04-19T18:00:00Z" |
| updatedAt | Session last update date | "2026-04-19T19:10:00Z" |

### WorkoutEntry

| Field | Business Description | Example Value |
|------|----------------------|---------------|
| id | Unique workout entry identifier | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c128" |
| workoutSessionId | Workout session identifier | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c127" |
| trainingItemId | Identifier of the completed training item | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c125" |
| weight | Working weight for this training item | 45 |
| createdAt | Date when the training item was logged as completed | "2026-04-19T18:15:00Z" |
| updatedAt | Entry last update date | "2026-04-19T18:16:00Z" |

### WorkoutSummary

| Field | Business Description | Example Value |
|------|----------------------|---------------|
| id | Unique summary identifier | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c129" |
| workoutSessionId | Workout session identifier | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c127" |
| duration | Workout duration in minutes | 70 |
| completedTrainingItemCount | Number of completed training items | 8 |
| caloriesBurned | Estimated calories burned | 320 |
| createdAt | Summary creation date | "2026-04-19T19:10:00Z" |
| updatedAt | Summary last update date | "2026-04-19T19:10:00Z" |

### Goal

| Field | Business Description | Example Value |
|------|----------------------|---------------|
| id | Unique goal identifier | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c130" |
| userId | User identifier | "018f4a2c-9b2e-7f4a-9c8a-2a7f4b91c123" |
| workoutsPerWeek | Target number of workouts per week | 3 |
| startDate | Goal start date | "2026-04-01" |
| createdAt | Goal creation date | "2026-04-01T10:00:00Z" |
| updatedAt | Goal last update date | "2026-04-10T10:00:00Z" |

## 2. REST API Endpoints

### Users

1. **`POST /api/v1/users`** — Create user
   * Business rule: the user is created after successful authentication through Firebase Auth
   * Constraints:
      * `firebaseUid` is required
      * `email` is required
      * `firebaseUid` must be unique
   * Returns: created user profile

2. **`GET /api/v1/users/{userId}`** — Get user profile
   * Business rule: a user can get only their own profile
   * Returns: user profile data

3. **`PATCH /api/v1/users/{userId}`** — Update user profile
   * Business rule: a user can update only their own profile
   * Constraints:
      * `id` cannot be changed
      * `firebaseUid` cannot be changed
      * Email is managed through Firebase Auth
   * Returns: updated user profile

4. **`DELETE /api/v1/users/{userId}`** — Delete user
   * Business rule: a user can delete only their own profile
   * Constraints:
      * User data deletion must account for related gyms, workouts, and goals
   * Returns: deletion status

### Gyms

5. **`POST /api/v1/gyms`** — Create gym club
   * Business rule: the gym club is created only for the current user
   * Constraints:
      * Gym club title is required
      * `availableTrainingItemIds` is selected from the existing catalog
   * Returns: created gym club

6. **`GET /api/v1/gyms/{gymId}`** — Get gym club details
   * Business rule: a user can view only their own gym clubs
   * Returns: gym club with the list of available training items

7. **`PATCH /api/v1/gyms/{gymId}`** — Update gym club
   * Business rule: a user can update only their own gym clubs
   * Constraints:
      * `userId` cannot be changed
      * Only existing `TrainingItem` records can be added to the gym club list
   * Returns: updated gym club

8. **`DELETE /api/v1/gyms/{gymId}`** — Delete gym club
   * Business rule: a user can delete only their own gym club
   * Constraints:
      * A gym club cannot be deleted if it has an active workout session
   * Returns: deletion status

9. **`GET /api/v1/gyms`** — Get user gym clubs
   * Business logic: returns only the current user's gym clubs
   * Sorting: by creation date or title
   * Returns: list of user gym clubs

### Training Items

10. **`POST /api/v1/training-items`** — Create training item
   * Business rule: available only to administrators
   * Constraints:
      * Title is required
      * Category is required
      * `slug` must be unique
   * Returns: created training item

11. **`GET /api/v1/training-items/{trainingItemId}`** — Get training item
   * Business logic: returns machine or exercise data
   * Returns: training item with description and muscle groups

12. **`PATCH /api/v1/training-items/{trainingItemId}`** — Update training item
   * Business rule: available only to administrators
   * Returns: updated training item

13. **`DELETE /api/v1/training-items/{trainingItemId}`** — Delete training item
   * Business rule: available only to administrators
   * Constraints:
      * A training item cannot be deleted if it is already used in workout history
   * Returns: deletion status

14. **`GET /api/v1/training-items`** — Get training item list
   * Business logic: returns the prefilled list of training items for selection when creating or editing a gym club
   * Filters:
      * By category
      * By muscle group
      * By title
   * Returns: list of `TrainingItem`

### Muscle Groups

15. **`POST /api/v1/muscle-groups`** — Create muscle group
   * Business rule: available only to administrators
   * Constraints:
      * Title is required
      * Category is required
   * Returns: created muscle group

16. **`GET /api/v1/muscle-groups/{muscleGroupId}`** — Get muscle group
   * Business logic: returns muscle group data
   * Returns: muscle group

17. **`PATCH /api/v1/muscle-groups/{muscleGroupId}`** — Update muscle group
   * Business rule: available only to administrators
   * Returns: updated muscle group

18. **`DELETE /api/v1/muscle-groups/{muscleGroupId}`** — Delete muscle group
   * Business rule: available only to administrators
   * Constraints:
      * A muscle group cannot be deleted if it is used in `TrainingItem`
   * Returns: deletion status

19. **`GET /api/v1/muscle-groups`** — Get muscle group list
   * Business logic: used for administrative management and `TrainingItem` categorization
   * Returns: list of muscle groups

### Workout Sessions

20. **`POST /api/v1/workout-sessions`** — Start workout session
   * Business rule: a user can start a workout only in their own gym club
   * Constraints:
      * `gymId` is required
      * The user must not have another active workout
   * Returns: created workout session

21. **`GET /api/v1/workout-sessions/{workoutSessionId}`** — Get workout session
   * Business rule: a user can view only their own workouts
   * Returns: workout data, list of completed training items, and weights

22. **`PATCH /api/v1/workout-sessions/{workoutSessionId}`** — Update workout session
   * Business rule: a user can update only their own workout
   * Constraints:
      * `userId` cannot be changed
      * `gymId` cannot be changed after session creation
   * Returns: updated workout session

23. **`DELETE /api/v1/workout-sessions/{workoutSessionId}`** — Delete workout session
   * Business rule: a user can delete only their own workout
   * Returns: deletion status

24. **`GET /api/v1/workout-sessions`** — Get workout history
   * Business logic: returns workouts of the current user
   * Filters:
      * By gym club
      * By time period
      * By status
   * Sorting: by workout date, newest first by default
   * Returns: list of workout sessions

25. **`POST /api/v1/workout-sessions/{workoutSessionId}/finish`** — Finish workout session
   * Business rule: only an active workout of the current user can be finished
   * Result:
      * Session status changes to `finished`
      * Finish time is recorded
      * Workout summary is generated
   * Returns: finished workout with summary

### Workout Entries

26. **`POST /api/v1/workout-entries`** — Log completed training item
   * Business rule: an entry can be created only inside an active workout
   * Business logic: one tap means that the user has finished working on a specific `TrainingItem`
   * Constraints:
      * `trainingItemId` must exist
      * `trainingItemId` must be available in the selected gym club
      * Weight cannot be negative
   * Returns: created workout entry

27. **`GET /api/v1/workout-entries/{workoutEntryId}`** — Get workout entry
   * Business rule: a user can view only entries from their own workouts
   * Returns: workout entry

28. **`PATCH /api/v1/workout-entries/{workoutEntryId}`** — Update workout entry
   * Business rule: a user can update only entries from their own workout
   * Constraints:
      * `workoutSessionId` cannot be changed
      * `trainingItemId` cannot be changed once the entry is created
   * Returns: updated entry

29. **`DELETE /api/v1/workout-entries/{workoutEntryId}`** — Delete mistakenly logged training item
   * Business rule: a user can delete only an entry from their own workout
   * Returns: deletion status

30. **`GET /api/v1/workout-entries`** — Get workout entry list
   * Business logic: returns entries by workout session or by time period
   * Filters:
      * By workout session
      * By training item
      * By time period
   * Returns: list of workout entries

### Workout Summaries

31. **`POST /api/v1/workout-summaries`** — Create workout summary
   * Business rule: usually created by the system when a workout is finished
   * Access: user or system process
   * Returns: created summary

32. **`GET /api/v1/workout-summaries/{workoutSummaryId}`** — Get workout summary
   * Business rule: a user can view only summaries of their own workouts
   * Returns: workout summary

33. **`PATCH /api/v1/workout-summaries/{workoutSummaryId}`** — Update workout summary
   * Business rule: available to the system process or administrator
   * Returns: updated summary

34. **`DELETE /api/v1/workout-summaries/{workoutSummaryId}`** — Delete workout summary
   * Business rule: deleted together with the workout session or by an administrator
   * Returns: deletion status

35. **`GET /api/v1/workout-summaries`** — Get summary list
   * Business logic: returns workout summaries of the current user
   * Filters:
      * By workout session
      * By time period
   * Returns: list of summaries

### Goals

36. **`POST /api/v1/goals`** — Create workout goal
   * Business rule: the goal belongs to the current user
   * Constraints:
      * `workoutsPerWeek` must be greater than 0
   * Priority: not included in the minimum MVP
   * Returns: created goal

37. **`GET /api/v1/goals/{goalId}`** — Get workout goal
   * Business rule: a user can view only their own goal
   * Returns: workout goal

38. **`PATCH /api/v1/goals/{goalId}`** — Update workout goal
   * Business rule: a user can update only their own goal
   * Returns: updated goal

39. **`DELETE /api/v1/goals/{goalId}`** — Delete workout goal
   * Business rule: a user can delete only their own goal
   * Returns: deletion status

40. **`GET /api/v1/goals`** — Get user goals
   * Business logic: returns goals of the current user
   * Returns: list of goals

### Analytics

41. **`GET /api/v1/analytics/weekly-progress`** — Get weekly progress
   * Business logic: counts completed workouts for the week
   * Compares the result with the user's goal if a goal is configured
   * Returns:
      * Number of completed workouts
      * Weekly goal
      * Goal achievement flag

42. **`GET /api/v1/analytics/training-items-progress`** — Get progress by training items
   * Business logic: analyzes completed `TrainingItem` records and weights
   * Sets are not counted separately
   * Priority: low

## 3. Business Rules

1. **Access rights:**
   * Guest access is forbidden
   * All user data is available only to the owner
   * A user sees only their own gyms, workouts, goals, and profile
   * Administrators manage the shared `TrainingItem` and `MuscleGroup` catalogs

2. **Identifier rules:**
   * `id` is an opaque string
   * `id` must not contain the entity type
   * `id` must not contain business meaning
   * A separate `slug` field is used for human-readable technical values

3. **Gym club rules:**
   * A user can create one or multiple gym clubs
   * Each gym club belongs to one user
   * When creating a gym club, the user selects `TrainingItem` records from the shared catalog
   * The user does not manually create custom `TrainingItem` records

4. **TrainingItem rules:**
   * `TrainingItem` is a prefilled training element
   * `TrainingItem` can be a machine, an equipment-based exercise, or a bodyweight exercise
   * CRUD for `TrainingItem` is available only to administrators
   * The user only selects available `TrainingItem` records for their gym club

5. **Workout rules:**
   * A workout is always linked to a specific gym club
   * During a workout, only `TrainingItem` records available in the selected gym club are displayed
   * One tap logs completion of one `TrainingItem`
   * One tap does not mean one set
   * The entry stores the `TrainingItem` and working weight
   * A user can have only one active workout at a time

6. **Muscle group catalog rules:**
   * `MuscleGroup` is used to describe, categorize, and sort `TrainingItem`
   * The user does not interact directly with the muscle group catalog
   * CRUD for `MuscleGroup` is available only to administrators

7. **Data validation:**
   * Gym club title is required
   * Weight cannot be negative
   * `TrainingItem` must exist in the catalog
   * `TrainingItem` must be available in the selected gym club
   * Only an active workout can be finished
   * Workout start date cannot be in the future
   * `birthDate` cannot be in the future

8. **API limits:**
   * Regular users: 100 requests per minute
   * Administrators: increased limit or no limit
   * Workout creation and finish methods should be idempotent where possible

## 4. Business Success Metrics

1. **API response speed:** 95% of requests must complete in under 500 ms

2. **Availability:** API is available 99% of the time

3. **Minimal cognitive load:** the main action during a workout is performed with one tap

4. **Workout stability:** creating a completed `TrainingItem` entry must not lose data under unstable network conditions

5. **Limits:**
   * Regular users: 100 requests/minute
   * Administrators: no limit or a separate limit
