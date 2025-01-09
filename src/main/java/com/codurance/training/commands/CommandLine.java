package com.codurance.training.commands;

public class CommandLine {
    private final String line;

    public CommandLine(String line) {
        this.line = line;
    }

    public CommandDescription parse() {
        String[] parts = this.line.split(" ");
        return new CommandDescription(parts[0], Arguments.skipOneAndCreate(parts).arguments);
    }
}
