package com.codurance.training.commands;

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
    public void createCommandTypeForAddCommand() {
        assertEquals(CommandType.ADD, CommandType.from("add"));
    }

    @Test
    public void attemptToCreateCommandTypeForAnUnknownCommand() {
        assertThrows(IllegalArgumentException.class, () ->  CommandType.from("unknown"));
    }
}