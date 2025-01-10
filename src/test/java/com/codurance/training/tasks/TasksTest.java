package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TasksTest {

    @Test
    public void formatTasksContainingASingleTask() {
        Tasks tasks = new Tasks();
        tasks.add(Task.newTask(1, "Task 1"));
        assertEquals("[ ] 1: Task 1\n",  tasks.format());
    }

    @Test
    public void formatTasksContainingACoupleOfTasks() {
        Tasks tasks = new Tasks();
        tasks.add(Task.newTask(1, "Task 1"));
        tasks.add(Task.newTask(2, "Task 2"));

        String expected = "[ ] 1: Task 1\n" + "[ ] 2: Task 2\n";
        assertEquals(expected,  tasks.format());
    }

    @Test
    public void formatTasksContainingACoupleOfTasksWithOneTaskAsDone() {
        Tasks tasks = new Tasks();
        tasks.add(Task.newTask(1, "Task 1"));
        tasks.add(Task.newTask(2, "Task 2"));
        tasks.markTaskWithIdDone(2);

        String expected = "[ ] 1: Task 1\n" + "[x] 2: Task 2\n";
        assertEquals(expected,  tasks.format());
    }

    @Test
    public void markATaskAsDoneWithMatchingId() {
        Tasks tasks = new Tasks();
        tasks.add(Task.newTask(1, "Task 1"));

        tasks.markTaskWithIdDone(1);
        assertEquals("[x] 1: Task 1\n",  tasks.format());
    }

    @Test
    public void markATaskAsNotDoneWithMatchingId() {
        Tasks tasks = new Tasks();
        tasks.add(Task.newTask(1, "Task 1"));

        tasks.markTaskWithIdNotDone(1);
        assertEquals("[ ] 1: Task 1\n",  tasks.format());
    }
}