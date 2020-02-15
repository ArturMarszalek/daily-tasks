package tasks;

import tasks.status.TaskStatus;

public class HardTask extends MediumTask {
    public HardTask(String description) {
        super(description);
    }
    public HardTask(String description, TaskStatus taskStatus) {
        super(description);
        this.status=taskStatus;
    }

    @Override
    public int getScore() {
        return super.getScore() + 5;
    }
}
