package tasks;

import tasks.status.TaskStatus;

public class EasyTask extends TaskBase{

    public EasyTask(String description) {
        super(description);
    }

    public EasyTask(TaskStatus status, String description) {
        super(status, description);
    }

    @Override
    public int getScore() {

        return 5;
    }
}
