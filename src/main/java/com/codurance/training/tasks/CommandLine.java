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
        switch (subCommand) {
            case "project":
                return new CommandDescription(CommandType.ADD_PROJECT, commandArgumentsFrom(parts, 2));
            case "task":
                return new CommandDescription(CommandType.ADD_TASK, commandArgumentsFrom(parts, 2));
        }
        throw new IllegalArgumentException("Unknown subcommand: " + subCommand);
    }

    private static List<String> commandArgumentsFrom(String[] parts, int skip) {
        return Arrays.stream(parts).skip(skip).collect(Collectors.toList());
    }
}
