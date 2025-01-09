package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TasksTest {

    @Test
    public void formatTasksContainingASingleTask() {
        Tasks tasks = new Tasks();
        tasks.add(new Task(1, "Task 1", false));
        assertEquals("[ ] 1: Task 1\n",  tasks.format());
    }

    @Test
    public void formatTasksContainingACoupleOfTasks() {
        Tasks tasks = new Tasks();
        tasks.add(new Task(1, "Task 1", false));
        tasks.add(new Task(2, "Task 2", false));

        String expected = "[ ] 1: Task 1\n" + "[ ] 2: Task 2\n";
        assertEquals(expected,  tasks.format());
    }

    @Test
    public void formatTasksContainingACoupleOfTasksWithOneTaskAsDone() {
        Tasks tasks = new Tasks();
        tasks.add(new Task(1, "Task 1", false));
        tasks.add(new Task(2, "Task 2", true));

        String expected = "[ ] 1: Task 1\n" + "[x] 2: Task 2\n";
        assertEquals(expected,  tasks.format());
    }

    @Test
    public void markATaskAsDoneWithMatchingId() {
        Tasks tasks = new Tasks();
        tasks.add(new Task(1, "Task 1", false));

        tasks.markTaskWithIdDone(1);
        assertEquals("[x] 1: Task 1\n",  tasks.format());
    }

    @Test
    public void markATaskAsNotDoneWithMatchingId() {
        Tasks tasks = new Tasks();
        tasks.add(new Task(1, "Task 1", true));

        tasks.markTaskWithIdNotDone(1);
        assertEquals("[ ] 1: Task 1\n",  tasks.format());
    }
}