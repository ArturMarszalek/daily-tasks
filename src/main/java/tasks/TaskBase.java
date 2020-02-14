package tasks;

public abstract class TaskBase {
    public TaskBase(String description) {
        this.description = description;
    }

    public String description;

    public abstract int getScore();

    public String getDescription() {
        return description;
    }
}
