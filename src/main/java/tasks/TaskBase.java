package tasks;

import tasks.status.TaskStatus;

public abstract class TaskBase {

    public TaskBase(String description) {
        this.description = description;
    }

    public TaskBase(String description, TaskStatus status) {
        this.description = description;
        this.status = status;
    }

    public String description;

    public TaskStatus status = TaskStatus.NEW;

    protected abstract int getScore();

    public int getFinishedScore() {
        if (status == TaskStatus.FINISHED) {
            return getScore();
        }

        return 0;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
