package tasks;

import tasks.status.TaskStatus;

public class EasyTask extends TaskBase{
    public EasyTask(String description, TaskStatus status) {
        super(description, status);
    }

    public EasyTask(String description) {
        super();
    }

    @Override
    public int getScore() {
        return 5;
    }
}
