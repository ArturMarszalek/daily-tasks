package tasks;

public class HardTask extends MediumTask {
    public HardTask(String description) {
        super(description);
    }

    @Override
    public int getScore() {
        return super.getScore() + 5;
    }
}
