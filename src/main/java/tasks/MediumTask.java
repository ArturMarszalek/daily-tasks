package tasks;

public class MediumTask extends EasyTask {

    public MediumTask(String description) {
        super(description);
    }

    @Override
    public int getScore() {
        return super.getScore() + 5;
    }
}
