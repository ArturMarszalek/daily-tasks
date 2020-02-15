package tasks;

public class EasyTask extends TaskBase{
    public EasyTask(String description) {
        super(description);
    }

    @Override
    public int getScore() {
        return 5;
    }
}
//comment