package tasks;

import tasks.status.TaskStatus;

public abstract class TaskBase {
    public  TaskStatus status;
    public TaskBase(String description) {
        this.description = description;
        TaskStatus status = TaskStatus.NEW;
    }
public TaskBase(String description, TaskStatus status){
        this.description=description;
        this.status=status;
}
    public String description;


    protected abstract int getScore();

    public int getFinishedScore(){
        if (status==TaskStatus.FINISHED){
            return getScore();
        }
        return 0;
    }

    public String getDescription() {
        return description;
    }
}
