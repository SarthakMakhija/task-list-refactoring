package com.codurance.training.commands;

import java.util.Arrays;

enum CommandType {
    ADD("add"), SHOW("show"), CHECK("check"), UNCHECK("uncheck");

    private final String commandName;

    CommandType(String commandName) {
        this.commandName = commandName;
    }

    static CommandType from(String commandName) {
        return Arrays
                .stream(CommandType.values())
                .filter(commandType -> commandType.commandName.equalsIgnoreCase(commandName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown command type: " + commandName));
    }
}
