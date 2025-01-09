package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void formatADoneTask() {
        Task task = new Task(1, "Task 1", true);
        assertEquals("[x] 1: Task 1\n", task.format());
    }

    @Test
    public void formatANotDoneTask() {
        Task task = new Task(1, "Task 1", false);
        assertEquals("[ ] 1: Task 1\n", task.format());
    }

    @Test
    public void matchesId() {
        Task task = new Task(1, "Task 1", false);
        assertTrue(task.matchesId(1));
    }

    @Test
    public void doesNotMatchId() {
        Task task = new Task(1, "Task 2", false);
        assertFalse(task.matchesId(2));
    }

    @Test
    public void markATaskDone() {
        Task task = new Task(2, "Task 2", false);
        task.markDone();

        assertEquals("[x] 2: Task 2\n", task.format());
    }

    @Test
    public void markATaskNotDone() {
        Task task = new Task(2, "Task 2", false);
        task.markNotDone();

        assertEquals("[ ] 2: Task 2\n", task.format());
    }
}