package com.codurance.training.commands;

import org.junit.Test;

import java.io.StringWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CommandsTest {

    @Test
    public void attemptToExecuteAnUnsupportedCommand() {
        StringWriter writer = new StringWriter();

        Commands commands = new Commands(writer);
        assertThrows(IllegalArgumentException.class,
                () -> commands.execute(new CommandDescription("unsupported", new Arguments(List.of("project", "caizin")))));
    }

    @Test
    public void executeAddTaskInAProjectFollowedByShow() throws Exception {
        StringWriter writer = new StringWriter();

        Commands commands = new Commands(writer);
        commands.execute(new CommandDescription(CommandType.ADD, new Arguments(List.of("project", "caizin"))));
        commands.execute(new CommandDescription(CommandType.ADD, new Arguments(List.of("task", "caizin", "Task1"))));
        commands.execute(new CommandDescription(CommandType.SHOW, new Arguments(List.of())));

        String expected = "caizin\n[ ] 1: Task1\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void executeAddTaskInAProjectFollowedByCheckAndShow() throws Exception {
        StringWriter writer = new StringWriter();

        Commands commands = new Commands(writer);
        commands.execute(new CommandDescription(CommandType.ADD, new Arguments(List.of("project", "caizin"))));
        commands.execute(new CommandDescription(CommandType.ADD, new Arguments(List.of("task", "caizin", "Task1"))));
        commands.execute(new CommandDescription(CommandType.CHECK, new Arguments(List.of("1"))));
        commands.execute(new CommandDescription(CommandType.SHOW, new Arguments(List.of())));

        String expected = "caizin\n[x] 1: Task1\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void executeAddTaskInAProjectFollowedByCheckAndUncheckAndThenShow() throws Exception {
        StringWriter writer = new StringWriter();

        Commands commands = new Commands(writer);
        commands.execute(new CommandDescription(CommandType.ADD, new Arguments(List.of("project", "caizin"))));
        commands.execute(new CommandDescription(CommandType.ADD, new Arguments(List.of("task", "caizin", "Task1"))));
        commands.execute(new CommandDescription(CommandType.CHECK, new Arguments(List.of("1"))));
        commands.execute(new CommandDescription(CommandType.UNCHECK, new Arguments(List.of("1"))));
        commands.execute(new CommandDescription(CommandType.SHOW, new Arguments(List.of())));

        String expected = "caizin\n[ ] 1: Task1\n";
        assertEquals(expected, writer.toString());
    }
}