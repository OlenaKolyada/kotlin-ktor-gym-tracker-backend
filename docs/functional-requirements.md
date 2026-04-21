# Functional Requirements

## 1. Registration and Account Management

### 1.1. Registration in the Application
* **Requirement source:** All user types.
* **Requirement description:** Implement user registration through Firebase Auth using email/password.
* **Requirement priority:** High.

### 1.2. Registration via Google
* **Requirement source:** All user types.
* **Requirement description:** Provide the ability to register and sign in via Google using Firebase Auth.
* **Requirement priority:** High.

### 1.3. Sign In
* **Requirement source:** All user types.
* **Requirement description:** Provide the ability for users to sign in to the application using email/password or Google.
* **Requirement priority:** High.

## 2. User Profile Management

### 2.1. View Profile
* **Requirement source:** All user types.
* **Requirement description:** Implement the ability to view the user profile with basic data:
  * Name
  * Email
  * Avatar
  * Weight
  * Height
  * Age
  * Gender
* **Requirement priority:** Medium.

### 2.2. Edit Profile
* **Requirement source:** All user types.
* **Requirement description:** Provide the ability to update user profile data.
* **Requirement priority:** Medium.

### 2.3. Upload Avatar
* **Requirement source:** Application users.
* **Requirement description:** Provide the user with the ability to upload or change the profile avatar.
* **Requirement priority:** Low.

## 3. Gym Club Management

### 3.1. Add Gym Club
* **Requirement source:** Users who train in one or multiple gym clubs.
* **Requirement description:** Implement the ability to create a user gym club. When creating a club, the user is shown a prefilled list of common machines and exercises. The user selects the items available in this club using checkboxes. Club fields include:
  * Name
  * Image
  * List of available machines and exercises
* **Requirement priority:** High.

### 3.2. Edit Gym Club
* **Requirement source:** Application users.
* **Requirement description:** Provide the ability to update user gym club data:
  * Name
  * Image
  * List of available machines and exercises
* **Requirement priority:** High.

### 3.3. Delete Gym Club
* **Requirement source:** Application users.
* **Requirement description:** Provide the ability to delete a user gym club.
* **Requirement priority:** High.

## 4. Machines and Exercises Catalog

### 4.1. Administrative Addition of a Machine or Exercise
* **Requirement source:** System administrators.
* **Requirement description:** Implement the ability to add a machine or exercise to the shared prefilled catalog. Fields include:
  * Name
  * Image
  * Description
  * Category
  * Muscle groups
* **Requirement priority:** Medium.

### 4.2. Administrative Editing of a Machine or Exercise
* **Requirement source:** System administrators.
* **Requirement description:** Provide the ability to update machine or exercise data in the shared catalog.
* **Requirement priority:** Medium.

### 4.3. Administrative Deletion of a Machine or Exercise
* **Requirement source:** System administrators.
* **Requirement description:** Provide the ability to delete a machine or exercise from the shared catalog.
* **Requirement priority:** Medium.

## 5. Muscle Groups Catalog

### 5.1. Administrative Management of Muscle Groups
* **Requirement source:** System administrators.
* **Requirement description:** Implement CRUD operations for muscle groups. Muscle groups are used for describing, categorizing, and sorting machines and exercises. Muscle group fields include:
  * Name
  * Category
  * Image
* **Requirement priority:** Low.

### 5.2. Linking Muscle Groups to Machines and Exercises
* **Requirement source:** System administrators.
* **Requirement description:** Provide the ability to link machines and exercises to one or more muscle groups.
* **Requirement priority:** Low.

## 6. Workout Execution

### 6.1. Create Workout Session
* **Requirement source:** Users with ADHD, regular gym-goers.
* **Requirement description:** Implement the ability to start a workout session. The session records:
  * User
  * Gym club
  * Start date and time
  * Session status
* **Requirement priority:** High.

### 6.2. Display Available Machines During Workout
* **Requirement source:** Users with ADHD, users training in multiple gym clubs.
* **Requirement description:** After starting a workout, display only the machines and exercises that the user previously marked as available in the selected club.
* **Requirement priority:** High.

### 6.3. Log Completed Machine
* **Requirement source:** Users with ADHD.
* **Requirement description:** Implement the core application functionality: logging a completed machine or exercise with a single tap. One tap means that the user has finished working on a specific machine or exercise within the current workout.
* **Requirement priority:** High.

### 6.4. Save Weight for Completed Machine
* **Requirement source:** Application users.
* **Requirement description:** Save the working weight specified by the user for each completed machine or exercise.
* **Requirement priority:** High.

### 6.5. Finish Workout Session
* **Requirement source:** All user types.
* **Requirement description:** Provide the ability to finish a workout by changing the session status.
* **Requirement priority:** High.

### 6.6. View Workout History
* **Requirement source:** All user types.
* **Requirement description:** Implement the ability to view a list of completed workouts.
* **Requirement priority:** Medium.

## 7. Workout Summary

### 7.1. Generate Workout Summary
* **Requirement source:** Application users.
* **Requirement description:** After finishing a workout, generate a short summary:
  * Duration
  * Number of completed machines and exercises
  * List of completed machines and exercises with weights
  * Calories burned
* **Requirement priority:** Medium.

### 7.2. View Workout Summary
* **Requirement source:** Application users.
* **Requirement description:** Provide the ability to view the summary of a specific workout session.
* **Requirement priority:** Medium.

## 8. Goals and Progress Analytics

### 8.1. Configure Workout Goal
* **Requirement source:** Users who track workout consistency.
* **Requirement description:** Implement the ability to set a weekly workout goal.
* **Requirement priority:** Medium.

### 8.2. Count Workouts by Week
* **Requirement source:** Users who track workout consistency.
* **Requirement description:** Implement calculation of the number of completed workouts per week.
* **Requirement priority:** Medium.

### 8.3. Check Goal Achievement
* **Requirement source:** Users with a configured goal.
* **Requirement description:** Compare the number of completed workouts per week with the user's goal.
* **Requirement priority:** Medium.

### 8.4. Analytics for Completed Machines and Exercises
* **Requirement source:** Application users.
* **Requirement description:** Implement progress calculation for completed machines and exercises. Sets are not counted separately.
* **Requirement priority:** Low.

## 9. API and Mobile Application Integration

### 9.1. OpenAPI Specification
* **Requirement source:** Developers.
* **Requirement description:** Describe the backend API using OpenAPI for subsequent code generation.
* **Requirement priority:** High.

### 9.2. Mobile Application Integration
* **Requirement source:** Developers.
* **Requirement description:** Provide communication between the React Native application and the backend through an HTTP API.
* **Requirement priority:** High.
