package com.codurance.training.commands;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommandLineTest {

    @Test
    public void parseShowCommand() {
        CommandLine commandLine = new CommandLine("show");
        CommandDescription commandDescription = commandLine.parse();

        assertEquals(CommandType.SHOW, commandDescription.commandType());
    }

    @Test
    public void parseCheckCommand() {
        CommandLine commandLine = new CommandLine("check 100");
        CommandDescription commandDescription = commandLine.parse();

        assertEquals(CommandType.CHECK, commandDescription.commandType());
        assertEquals("100", commandDescription.arguments().argumentAtIndexAsString(0));
    }

    @Test
    public void parseUncheckCommand() {
        CommandLine commandLine = new CommandLine("uncheck 100");
        CommandDescription commandDescription = commandLine.parse();

        assertEquals(CommandType.UNCHECK, commandDescription.commandType());
        assertEquals("100", commandDescription.arguments().argumentAtIndexAsString(0));
    }

    @Test
    public void parseAddProjectCommand() {
        CommandLine commandLine = new CommandLine("add project caizin");
        CommandDescription commandDescription = commandLine.parse();

        assertEquals(CommandType.ADD, commandDescription.commandType());
        assertEquals("project", commandDescription.arguments().argumentAtIndexAsString(0));
        assertEquals("caizin", commandDescription.arguments().argumentAtIndexAsString(1));
    }

    @Test
    public void parseAddTaskCommand() {
        CommandLine commandLine = new CommandLine("add task caizin 200");
        CommandDescription commandDescription = commandLine.parse();

        assertEquals(CommandType.ADD, commandDescription.commandType());
        assertEquals("task", commandDescription.arguments().argumentAtIndexAsString(0));
        assertEquals("caizin", commandDescription.arguments().argumentAtIndexAsString(1));
        assertEquals("200", commandDescription.arguments().argumentAtIndexAsString(2));
    }
}