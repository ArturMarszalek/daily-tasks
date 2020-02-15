package tasks;

import tasks.status.TaskStatus;

public class EasyTask extends TaskBase{
    public EasyTask(String description) {
        super(description);
    }
    public EasyTask(String description, TaskStatus status) {
        super(description,status);
    }

    @Override
    public int getScore() {
        return 5;
    }
}
