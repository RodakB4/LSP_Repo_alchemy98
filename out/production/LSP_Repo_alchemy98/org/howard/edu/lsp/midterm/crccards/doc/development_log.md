# Development Log

## External Assistance Used
AI Tool: ChatGPT , Claude

Below is an explanation of how the AI was used while developing the solution. 
A complete transcript of all prompts and responses used during this assignment follows this explanation.
Claude was used to help implement the code once the designs were complete.
---

## Summary of AI Assistance

During development of the TaskManager class, I used AI to help reason through which internal data structure would satisfy all requirements in the CRC cards and Driver class.

We went back and forth specifically about how to:

- Prevent duplicate task IDs
- Efficiently look up tasks
- Return tasks by status even though the internal storage is not a list
- Ensure findTask() returns null when not found
- Decide which Java collection best fits the behaviors listed in the CRC cards

The discussion led to choosing a **HashMap<String, Task>**, with the following reasoning:

### Why HashMap Was Selected
- `HashMap<String, Task>` directly maps **taskId → Task**, which fits the core requirement of locating tasks by ID.
- `containsKey(taskId)` makes duplicate detection simple and reliable.
- Lookup time is **O(1)** on average, which is ideal for findTask().
- It prevents duplicates naturally because keys in a map must be unique.

### How This Influenced Method Design
- **addTask()**:  
  We decided to use `containsKey()` to detect duplicates, throwing `IllegalArgumentException` as required.

- **findTask()**:  
  We discussed using `getOrDefault(taskId, null)`, although a normal `.get()` also returns null by default.  
  Either approach satisfies the Driver’s requirement of returning null when the task does not exist.

- **getTasksByStatus()**:  
  Since the internal structure is a Map, we loop through `tasks.values()` and filter manually into a `List<Task>`.  
  This returns the correct List type without exposing the HashMap itself.

---
### Javadoc Notation Assistance
The AI also assisted in:
- Structuring the Javadoc consistently
- Ensuring each public method had:
    - A clear description
    - `@param` tags where appropriate
    - `@return` tags where appropriate
- Adding a class-level Javadoc description with the author name, as required by the assignment
- Making sure Javadoc matched actual method behavior  
  (e.g., documenting the behavior of invalid statuses → "UNKNOWN")