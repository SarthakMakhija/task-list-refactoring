package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void formatADoneTask() {
        Task task = Task.newTask(1, "Task 1");
        task.markDone();

        assertEquals("[x] 1: Task 1\n", task.format());
    }

    @Test
    public void formatANotDoneTask() {
        Task task = Task.newTask(1, "Task 1");
        assertEquals("[ ] 1: Task 1\n", task.format());
    }

    @Test
    public void matchesId() {
        Task task = Task.newTask(1, "Task 1");
        assertTrue(task.matchesId(1));
    }

    @Test
    public void doesNotMatchId() {
        Task task = Task.newTask(1, "Task 2");
        assertFalse(task.matchesId(2));
    }

    @Test
    public void markATaskDone() {
        Task task = Task.newTask(2, "Task 2");
        task.markDone();

        assertEquals("[x] 2: Task 2\n", task.format());
    }

    @Test
    public void markATaskNotDone() {
        Task task = Task.newTask(2, "Task 2");
        task.markNotDone();

        assertEquals("[ ] 2: Task 2\n", task.format());
    }
}