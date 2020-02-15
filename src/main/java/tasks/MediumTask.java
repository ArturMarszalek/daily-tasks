
package tasks;

import tasks.status.TaskStatus;

public class MediumTask extends EasyTask {

    public MediumTask(String description) {
        super(description);
    }

    public MediumTask(TaskStatus status, String description) {
        super(status, description);
    }

    @Override
    public int getScore() {
        return super.getScore() + 5;
    }
}