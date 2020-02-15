package tasks;

import tasks.status.TaskStatus;

public abstract class TaskBase {
    public TaskBase(String description, TaskStatus status) {
        this.description = description;
        this.status = status;
    }

    public TaskStatus status = TaskStatus.NEW;

    public TaskBase(String description) {
    }

    public TaskBase() {

    }

    public TaskBase(TaskStatus taskStatus) {
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getFinishedScore(){
        if (status == TaskStatus.FINISHED) {
            return getScore();
        }
        return 0;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String description;

    public abstract int getScore();

    public String getDescription() {
        return description;
    }
}
