package com.codurance.training.tasks;

import com.codurance.training.commands.CommandLine;
import com.codurance.training.commands.Commands;

import java.io.Writer;

public final class TaskList {

    private final Commands commands;

    public TaskList(Writer writer) {
        commands = new Commands(writer);
    }

    public void execute(String commandLine) throws Exception {
        commands.execute(new CommandLine(commandLine).parse());
    }
}

