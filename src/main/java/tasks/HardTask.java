package tasks;

import tasks.status.TaskStatus;

public class HardTask extends MediumTask {
    public HardTask(String description, TaskStatus status) {
        super(description, status);
    }

    @Override
    public int getScore() {
        return super.getScore() + 5;
    }
}
