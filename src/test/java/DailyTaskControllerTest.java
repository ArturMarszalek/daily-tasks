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
        EasyTask eatObiad = new EasyTask("zjedz obiad");

        //when
        DailyTaskController dailyTaskController = new DailyTaskController();
        dailyTaskController.add(eatBreakfast);
        dailyTaskController.add(eatObiad);
        //then
        assertTrue(dailyTaskController.contains(eatObiad));
    }

    @Test
    void removeFromEmptyList() {
        EasyTask eatObiad = new EasyTask("zjedz obiad");
        dailyTaskController.remove(eatObiad);
        assertFalse(dailyTaskController.contains(eatObiad));
    }

    @Test
    void removeFromOneElementList() {
        EasyTask eatObiad = new EasyTask("zjedz obiad");
        dailyTaskController.add(eatObiad);
        dailyTaskController.remove(eatObiad);
        assertFalse(dailyTaskController.contains(eatObiad));
    }

    @Test
    void removeLastFromTwoElementList() {
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko");
        EasyTask eatObiad = new EasyTask("zjedz obiad");
        dailyTaskController.add(eatBreakfast);
        dailyTaskController.add(eatObiad);
        dailyTaskController.remove(eatObiad);
        assertTrue(dailyTaskController.contains(eatBreakfast));
        assertFalse(dailyTaskController.contains(eatObiad));
    }   @Test
    void removeFirstFromTwoElementList() {
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko");
        EasyTask eatObiad = new EasyTask("zjedz obiad");
        dailyTaskController.add(eatBreakfast);
        dailyTaskController.add(eatObiad);
        dailyTaskController.remove(eatBreakfast);
        assertFalse(dailyTaskController.contains(eatBreakfast));
        assertTrue(dailyTaskController.contains(eatObiad));
    }


    @Test
    void shouldRemoveTask() {
        //given
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko");
        EasyTask eatObiad = new EasyTask("zjedz obiad");
        EasyTask eatKolacje = new EasyTask("zjedz kolacje");
        dailyTaskController.add(eatBreakfast);
        dailyTaskController.add(eatObiad);
        dailyTaskController.add(eatKolacje);
        //assertTrue(dailyTaskController.contains(eatB));
        //when
        dailyTaskController.remove(eatObiad);
        //then
        assertTrue(dailyTaskController.contains(eatBreakfast));
        assertFalse(dailyTaskController.contains(eatObiad));
        assertTrue(dailyTaskController.contains(eatKolacje));
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
    void shouldCountAllPointsForTasks() {
        //given
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko",TaskStatus.FINISHED);
        EasyTask doNotEatSweets = new MediumTask("nie jedz słodyczy");
        EasyTask doExercises = new HardTask("idz na silke");
        dailyTaskController.add(eatBreakfast);
        dailyTaskController.add(doNotEatSweets);
        dailyTaskController.add(doExercises);

        //when
        int totalScoreForAllFinishedTasks = dailyTaskController.getTotalScoreForAllFinishedTasks();
        //then
        assertEquals(5, totalScoreForAllFinishedTasks);
    }    @Test
    void shouldCountAllPointsForFinishedTasks() {
        //given
        EasyTask eatBreakfast = new EasyTask("zjedz sniadanko",TaskStatus.FINISHED);
        EasyTask doNotEatSweets = new MediumTask("nie jedz słodyczy",TaskStatus.IN_PROGRESS);
        EasyTask doExercises = new HardTask("idz na silke");
        dailyTaskController.add(eatBreakfast);
        dailyTaskController.add(doNotEatSweets);
        dailyTaskController.add(doExercises);

        //when
        int totalScoreForAllFinishedTasks = dailyTaskController.getTotalScoreForAllFinishedTasks();
        //then
        assertEquals(5, totalScoreForAllFinishedTasks);
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
    }    @Test
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
    }    @Test
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