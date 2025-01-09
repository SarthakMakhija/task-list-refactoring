package com.codurance.training.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandLine {
    private final String line;

    public CommandLine(String line) {
        this.line = line;
    }

    public CommandDescription parse() {
        String[] parts = this.line.split(" ");
        if (!parts[0].equals("add")) {
            return new CommandDescription(parts[0], commandArgumentsFrom(parts, 1));
        }
        return parseAdd(parts);
    }

    private static CommandDescription parseAdd(String[] parts) {
        String subCommand = parts[1];
        if (subCommand.equals("project")) {
            return new CommandDescription("add_project", commandArgumentsFrom(parts, 2));
        }
        if (subCommand.equals("task")) {
            return new CommandDescription("add_task", commandArgumentsFrom(parts, 2));
        }
        throw new IllegalArgumentException("Unknown subcommand: " + subCommand);
    }

    private static List<String> commandArgumentsFrom(String[] parts, int skip) {
        return Arrays.stream(parts).skip(skip).collect(Collectors.toList());
    }
}
