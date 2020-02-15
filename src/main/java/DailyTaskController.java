import tasks.TaskBase;
import tasks.list.MyLinkedList;

public class DailyTaskController {
    MyLinkedList<TaskBase> myTasks = new MyLinkedList<TaskBase>();

    public void add(TaskBase task) {
        myTasks.add(task);
    }

    public void add(int index, TaskBase taskBase){
        myTasks.add(index, taskBase);
    }

    public void remove(TaskBase task) {
        myTasks.remove(task);
    }

    public boolean contains(TaskBase task) {
        return myTasks.contains(task);
    }

    public int getTotalScoreForAllFinishedTasks() {
        int score = 0;
        for (TaskBase task: myTasks) {

            score += task.getFinishedScore();
        }
       return score;
    }

    public TaskBase getAt(int index){
        return myTasks.get(index);
    }
}
