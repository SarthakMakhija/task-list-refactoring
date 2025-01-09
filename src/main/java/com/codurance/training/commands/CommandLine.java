package com.codurance.training.commands;

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
        return new CommandDescription(parts[0], commandArgumentsFrom(parts));
    }

    private static List<String> commandArgumentsFrom(String[] parts) {
        return Arrays.stream(parts).skip(1).collect(Collectors.toList());
    }
}
