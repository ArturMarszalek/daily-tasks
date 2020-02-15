package tasks;

import tasks.status.TaskStatus;

public abstract class TaskBase {

    public TaskBase(String description) {
        this.description = description;
    }

    public String description;

    public TaskBase(String description, TaskStatus status) {
        this.description = description;
    }


    public abstract int getScore();

    public String getDescription() {
        return description;
    }
}
