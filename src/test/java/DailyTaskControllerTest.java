import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.EasyTask;
import tasks.HardTask;
import tasks.MediumTask;

import static org.junit.jupiter.api.Assertions.*;

class DailyTaskControllerTest {

    private DailyTaskController dailyTaskController;

    @BeforeEach
    void setUp() {
        dailyTaskController = new DailyTaskController();
    }



    @Test
    void shouldAddTask() {
        //given
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko");

        //when
        DailyTaskController dailyTaskController = new DailyTaskController();
        dailyTaskController.add(eatBreakfast);
        //then
        assertTrue(dailyTaskController.contains(eatBreakfast));
    }
    @Test
    void shouldAddThreeTask() {
        //given
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko");
        EasyTask eatSeconBreakfast = new EasyTask("zjedz drugie sniadanie");
        EasyTask eatDinner = new EasyTask("zjedz obiad");

        //when
        DailyTaskController dailyTaskController = new DailyTaskController();
        dailyTaskController.add(eatBreakfast);
        dailyTaskController.add(eatSeconBreakfast);
        dailyTaskController.add(eatDinner);
        //then
        assertTrue(dailyTaskController.contains(eatSeconBreakfast));
    }

    @Test
    void shouldRemoveTask() {
        //given
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko");
        dailyTaskController.add(eatBreakfast);
        assertTrue(dailyTaskController.contains(eatBreakfast));
        //when
        dailyTaskController.remove(eatBreakfast);
        //then
        assertFalse(dailyTaskController.contains(eatBreakfast));
    }
    @Test
    void shouldRemoveTaskfromBiggerLinkedList() {
        //given
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko");
        EasyTask eatSeconBreakfast = new EasyTask("zjedz drugie sniadanie");
        EasyTask eatDinner = new EasyTask("zjedz obiad");

        DailyTaskController dailyTaskController = new DailyTaskController();
        dailyTaskController.add(eatBreakfast);
        dailyTaskController.add(eatSeconBreakfast);
        dailyTaskController.add(eatDinner);
        assertTrue(dailyTaskController.contains(eatBreakfast));
        //when
        dailyTaskController.remove(eatBreakfast);
        //then
        assertFalse(dailyTaskController.contains(eatBreakfast));
    }

    @Test
    void shouldAddTaskAtSpecificPlace() {
        //given
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko");
        dailyTaskController.add(eatBreakfast);
        EasyTask eatDinner = new EasyTask("zjedz kolacje");
        dailyTaskController.add(eatDinner);

        EasyTask eatLunch = new EasyTask("zjedz obiad");
        //when
        dailyTaskController.add(1, eatLunch);
        //then
        assertSame(eatLunch, dailyTaskController.getAt(1));
    }

    @Test
    void shouldCountAllPointsForFinishedTasks() {
        //given
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko");
        EasyTask doNotEatSweets = new MediumTask("nie jedz słodyczy");
        EasyTask doExercises = new HardTask("idz na silke");
        dailyTaskController.add(eatBreakfast);
        dailyTaskController.add(doNotEatSweets);
        dailyTaskController.add(doExercises);

        //when
        int totalScoreForAllFinishedTasks = dailyTaskController.getTotalScoreForAllFinishedTasks();
        //then
        assertEquals(30, totalScoreForAllFinishedTasks);
    }
}