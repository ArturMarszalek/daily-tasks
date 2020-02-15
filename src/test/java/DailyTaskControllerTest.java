import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.EasyTask;
import tasks.HardTask;
import tasks.MediumTask;
import tasks.status.TaskStatus;

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


    @Test
    void shouldRemoveTaskAtFirstPosition() {
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
    void shouldRemoveTaskInTheMiddle() {
        //given
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko");
        EasyTask eatLunch = new MediumTask("zjedz obiad");
        EasyTask doNotSleep = new HardTask("nie spij 24 godziny");
        dailyTaskController.add(eatBreakfast);
        dailyTaskController.add(eatLunch);
        dailyTaskController.add(doNotSleep);
        //when
        dailyTaskController.remove(eatLunch);
        //then
        assertFalse(dailyTaskController.contains(eatLunch));
    }
    @Test
    void shouldRemoveTaskAtLastPosition() {
        //given
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko");
        EasyTask eatDinner = new MediumTask("zjedz kolacje");
        dailyTaskController.add(eatBreakfast);
        dailyTaskController.add(eatDinner);
        //when
        dailyTaskController.remove(eatDinner);
        //then
        assertFalse(dailyTaskController.contains(eatDinner));
    }
}