package com.codurance.training.commands;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import static org.junit.Assert.*;

public class CommandsTest {

    @Test
    public void executeAddTaskInAProjectFollowedByShow() throws Exception {
        StringWriter writer = new StringWriter();

        Commands commands = new Commands(writer);
        commands.execute(new CommandDescription(CommandType.ADD, List.of("project", "caizin")));
        commands.execute(new CommandDescription(CommandType.ADD, List.of("task", "caizin", "Task1")));
        commands.execute(new CommandDescription(CommandType.SHOW, List.of()));

        String expected = "caizin\n[ ] 1: Task1\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void executeAddTaskInAProjectFollowedByCheckAndShow() throws Exception {
        StringWriter writer = new StringWriter();

        Commands commands = new Commands(writer);
        commands.execute(new CommandDescription(CommandType.ADD, List.of("project", "caizin")));
        commands.execute(new CommandDescription(CommandType.ADD, List.of("task", "caizin", "Task1")));
        commands.execute(new CommandDescription(CommandType.CHECK, List.of("1")));
        commands.execute(new CommandDescription(CommandType.SHOW, List.of()));

        String expected = "caizin\n[x] 1: Task1\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void executeAddTaskInAProjectFollowedByCheckAndUncheckAndThenShow() throws Exception {
        StringWriter writer = new StringWriter();

        Commands commands = new Commands(writer);
        commands.execute(new CommandDescription(CommandType.ADD, List.of("project", "caizin")));
        commands.execute(new CommandDescription(CommandType.ADD, List.of("task", "caizin", "Task1")));
        commands.execute(new CommandDescription(CommandType.CHECK, List.of("1")));
        commands.execute(new CommandDescription(CommandType.UNCHECK, List.of("1")));
        commands.execute(new CommandDescription(CommandType.SHOW, List.of()));

        String expected = "caizin\n[ ] 1: Task1\n";
        assertEquals(expected, writer.toString());
    }
}