package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of Task objects.
 * Supports adding, finding, and filtering tasks by status.
 * @author Rodak
 */
public class TaskManager {

    private Map<String, Task> tasks;

    /**
     * Creates a new empty TaskManager.
     */
    public TaskManager() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a task to the manager.
     * @param task the task to add
     * @throws IllegalArgumentException if a task with the same ID already exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID: " + task.getTaskId());
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by its ID.
     * @param taskId the ID of the task to find
     * @return the Task if found, or null if not found
     */
    public Task findTask(String taskId) {
        return tasks.getOrDefault(taskId, null);
    }

    /**
     * Returns a list of all tasks matching the given status.
     * @param status the status to filter by
     * @return a list of tasks with the matching status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}