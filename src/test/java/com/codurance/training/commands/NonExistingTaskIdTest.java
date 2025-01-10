package com.codurance.training.commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonExistingTaskIdTest {

    @Test
    public void errorMessageForAMissingTaskId() {
        NonExistingTaskId nonExistingTaskId = new NonExistingTaskId("Task Id not found");
        assertEquals("Task Id not found 100\n", nonExistingTaskId.errorMessage(100));
    }
}