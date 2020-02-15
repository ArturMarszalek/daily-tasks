package tasks;

import tasks.status.TaskStatus;

public abstract class TaskBase {

    public TaskStatus status = TaskStatus.NEW;

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskBase(String description) {
        this.description = description;
    }

    public String description;

    public abstract int getScore();

    public String getDescription() {
        return description;
    }
}
