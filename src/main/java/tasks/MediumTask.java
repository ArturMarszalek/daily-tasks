package tasks;

import tasks.status.TaskStatus;

public class MediumTask extends EasyTask {

    public MediumTask(String description) {
        super(description);
    }

    public MediumTask(String description, TaskStatus status) {
        super(description, status);

    }

    @Override
    public int getScore() {
        return super.getScore() + 5;
    }
}
