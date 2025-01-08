package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}