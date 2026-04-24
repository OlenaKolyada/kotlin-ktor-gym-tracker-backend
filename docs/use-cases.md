# FunkyTap Use Cases

## UserFeature

### Use case: Register user

**Goal:**  
Create a user account and initial profile.

**Flow:**  
1. User enters email, password, and basic profile data.
2. System validates the input.
3. System creates the user account.
4. System creates the initial user profile.

**Result:**  
User account and profile are created.

---

### Use case: Authenticate user

**Goal:**  
Allow an existing user to access the application.

**Flow:**  
1. User enters email and password.
2. System validates the credentials.
3. System grants access to the application.

**Result:**  
User is authenticated.

---

### Use case: View profile

**Goal:**  
Show the user's profile data.

**Flow:**  
1. User opens the profile screen.
2. System loads the user's profile.
3. System shows profile data, including name, avatar, height, weight, date of birth, and weekly workout goal.

**Result:**  
User sees their current profile data.

---

### Use case: Update profile

**Goal:**  
Allow the user to update profile data.

**Flow:**  
1. User changes profile data.
2. System validates the changes.
3. System saves the updated profile.

**Result:**  
User profile is updated.

---

### Use case: Delete profile

**Goal:**  
Allow the user to delete their account.

**Flow:**  
1. User requests account deletion.
2. System asks for confirmation.
3. User confirms deletion.
4. System deletes or deactivates the account and related personal data.

**Result:**  
User account is removed or deactivated.

---

### Use case: Create weekly workout goal

**Goal:**  
Set how many times per week the user wants to train.

**Flow:**  
1. User selects the desired number of workouts per week.
2. System saves the weekly goal.
3. System starts tracking progress against this goal.

**Result:**  
Weekly workout goal is created.

---

### Use case: Update weekly workout goal

**Goal:**  
Change the user's weekly workout goal.

**Flow:**  
1. User changes the desired number of workouts per week.
2. System saves the new goal.
3. System recalculates current weekly progress.

**Result:**  
Weekly workout goal is updated.

---

### Use case: Delete weekly workout goal

**Goal:**  
Stop tracking progress against a weekly workout goal.

**Flow:**  
1. User removes the weekly goal.
2. System deletes the goal.
3. System stops calculating goal progress.

**Result:**  
Weekly workout goal is deleted.

---

## CatalogFeature

### Use case: Create gym

**Goal:**  
Allow the user to add a gym they train in.

**Flow:**  
1. User enters gym data, such as name, address, and available machines.
2. System validates the input.
3. System saves the gym in the user's personal gym catalog.

**Result:**  
Gym is added to the user's gym list.

---

### Use case: View gym list

**Goal:**  
Show the gyms added by the current user.

**Flow:**  
1. User opens the main screen.
2. System loads the user's gyms.
3. System shows the gym list.

**Result:**  
User sees their personal list of gyms.

---

### Use case: Update gym

**Goal:**  
Allow the user to update a gym from their personal catalog.

**Flow:**  
1. User changes gym data, such as name, address, or machine list.
2. System validates the changes.
3. System saves the updated gym.

**Result:**  
Gym data is updated.

---

### Use case: Delete gym

**Goal:**  
Allow the user to remove a gym from their personal catalog.

**Flow:**  
1. User requests gym deletion.
2. System asks for confirmation.
3. User confirms deletion.
4. System removes the gym from the user's personal catalog.

**Result:**  
Gym is removed from the user's gym list.

---

### Use case: Open gym for workout

**Goal:**  
Start a workout in the selected gym.

**Flow:**  
1. User taps a gym on the main screen.
2. System creates an active workout for this gym.
3. System opens the active workout screen.
4. System shows the machines available in this gym.

**Result:**  
Active workout is started.

---

### Use case: Sort machines by muscle groups

**Goal:**  
Use muscle groups to organize machines for workout and analytics.

**Flow:**  
1. System reads the muscle groups linked to gym machines.
2. System groups or orders machines by muscle group.
3. System uses this structure on workout and analytics screens.

**Result:**  
Machines are organized by muscle groups without exposing a separate muscle group browsing screen.

---

## WorkoutFeature

### Use case: Start workout

**Goal:**  
Create an active workout when the user chooses a gym.

**Flow:**  
1. User taps a gym on the main screen.
2. System creates an active workout for the selected gym.
3. System records the workout start time.
4. System opens the active workout screen.

**Result:**  
User can start marking completed machines.

---

### Use case: Mark machine as completed

**Goal:**  
Record that the user has completed work on a machine during the active workout.

**Flow:**  
1. User taps a machine in the active workout.
2. System marks the machine as completed.
3. System includes this machine in the current workout progress.

**Result:**  
Machine is marked as completed in the active workout.

---

### Use case: Unmark completed machine

**Goal:**  
Allow the user to fix an accidental tap.

**Flow:**  
1. User taps an already completed machine.
2. System removes the completed state from this machine.
3. System excludes this machine from the current workout progress.

**Result:**  
Machine is no longer marked as completed.

---

### Use case: Update machine weight

**Goal:**  
Save the current working weight for a machine.

**Flow:**  
1. User changes the weight for a machine during the active workout.
2. System saves this weight as the latest weight for this user and machine.
3. When the user uses this machine in a later workout, system pre-fills the latest saved weight.

**Result:**  
User only changes the weight when the actual working weight changes.

---

### Use case: Finish workout

**Goal:**  
Complete the current workout and show a short summary.

**Flow:**  
1. User taps `Finish workout`.
2. System records the workout end time.
3. System calculates workout duration, completed machines, kcal, streak, and weekly goal progress.
4. System saves the workout to history.
5. System updates analytics.
6. System shows a completion screen with short statistics and a `View detailed stats` button.

**Result:**  
Workout is completed. User can open detailed workout statistics.

---

### Use case: View workout completion summary

**Goal:**  
Show the result immediately after workout completion.

**Flow:**  
1. System opens the completion screen after the workout is finished.
2. System shows short congratulation text.
3. System shows brief statistics, such as duration, completed machines, kcal, streak, and weekly goal progress.
4. System shows the `View detailed stats` button.

**Result:**  
User sees a short workout summary and can continue to detailed statistics.

---

### Use case: View detailed workout statistics

**Goal:**  
Show full statistics for a completed workout.

**Flow:**  
1. User taps `View detailed stats` after workout completion or opens a workout from history.
2. System loads the selected workout.
3. System shows duration, completed machines, kcal, streak, weekly goal progress, muscle groups, and completed machine list.

**Result:**  
User sees detailed statistics for the selected workout.

---

### Use case: Delete workout

**Goal:**  
Allow the user to remove an incorrect workout from history.

**Flow:**  
1. User opens a completed workout from history.
2. User requests workout deletion.
3. System asks for confirmation.
4. User confirms deletion.
5. System deletes the workout.
6. System recalculates analytics affected by this workout.

**Result:**  
Workout is deleted. Statistics are recalculated.

---

## AnalyticsFeature

### Use case: View profile statistics

**Goal:**  
Show an overview of the user's training activity.

**Flow:**  
1. User opens the statistics screen.
2. System loads aggregated training data.
3. System shows total workouts, completed machines, favorite machine, streak, weekly kcal, and monthly kcal.

**Result:**  
User sees a high-level overview of their training activity.

---

### Use case: View weekly goal progress

**Goal:**  
Show how close the user is to the weekly workout goal.

**Flow:**  
1. User opens the goals screen.
2. System loads the weekly goal and completed workouts for the current week.
3. System calculates current progress.
4. System shows completed workouts, target workouts, and remaining workouts.

**Result:**  
User sees current weekly goal progress.

---

### Use case: View workout calendar

**Goal:**  
Show training activity by date.

**Flow:**  
1. User opens the calendar section.
2. System loads workouts for the selected month.
3. System marks days with completed workouts.
4. System shows the number of workouts for the month.

**Result:**  
User sees workout activity on a calendar.

---

### Use case: View workout history

**Goal:**  
Show previous workouts.

**Flow:**  
1. User opens the history screen.
2. System loads completed workouts.
3. System shows workout date, gym, duration, and number of completed machines.

**Result:**  
User sees the list of previous workouts.

---

### Use case: View favorite machine

**Goal:**  
Show the machine used most often by the user.

**Flow:**  
1. System analyzes completed workouts.
2. System counts machine usage.
3. System determines the most frequently completed machine.
4. System shows the favorite machine in statistics.

**Result:**  
User sees their favorite machine.

---

### Use case: View streak

**Goal:**  
Show the user's current training streak.

**Flow:**  
1. System analyzes completed workouts.
2. System calculates the current streak according to the app rules.
3. System shows the streak in statistics and workout detail screens.

**Result:**  
User sees their current training streak.
