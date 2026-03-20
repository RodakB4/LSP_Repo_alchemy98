package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task with an ID, description, and status.
 * @author Rodak
 */
public class Task {

    private String taskId;
    private String description;
    private String status;

    /**
     * Creates a new Task with the given ID and description.
     * Status defaults to "OPEN".
     * @param taskId the unique identifier for this task
     * @param description a brief description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the current status of the task.
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status. Valid values are OPEN, IN_PROGRESS, and COMPLETE.
     * If the value is not valid, status is set to "UNKNOWN".
     * @param status the new status to set
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a string representation of the task.
     * @return the task in the format "taskId description [status]"
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}