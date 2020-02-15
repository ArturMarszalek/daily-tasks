package tasks;

import tasks.status.TaskStatus;

public class HardTask extends MediumTask {
    public HardTask(String description) {
        super(description);
    }

    public HardTask(TaskStatus status, String description) {
        super(status, description);
    }

    @Override
    public int getScore() {
        return super.getScore() + 5;
    }
}