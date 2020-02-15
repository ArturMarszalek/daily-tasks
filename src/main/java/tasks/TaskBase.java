package tasks;

import tasks.list.MyLinkedListElement;
import tasks.status.TaskStatus;

public abstract class TaskBase {

    public TaskStatus status = TaskStatus.NEW;

    public TaskBase(String description) {
        this.description = description;
    }

    public TaskBase(TaskStatus status, String description) {
        this.status = status;
        this.description = description;
    }

    public String description;

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
