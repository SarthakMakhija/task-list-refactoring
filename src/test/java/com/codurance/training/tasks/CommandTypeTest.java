package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandTypeTest {

    @Test
    public void createCommandTypeForShowCommand() {
        assertEquals(CommandType.SHOW, CommandType.from("show"));
    }

    @Test
    public void createCommandTypeForCheckCommand() {
        assertEquals(CommandType.CHECK, CommandType.from("check"));
    }

    @Test
    public void createCommandTypeForUncheckCommand() {
        assertEquals(CommandType.UNCHECK, CommandType.from("uncheck"));
    }

    @Test
    public void createCommandTypeForAddProjectCommand() {
        assertEquals(CommandType.ADD_PROJECT, CommandType.from("add_project"));
    }

    @Test
    public void createCommandTypeForAddTaskCommand() {
        assertEquals(CommandType.ADD_TASK, CommandType.from("add_task"));
    }
}