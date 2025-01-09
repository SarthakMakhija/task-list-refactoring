package com.codurance.training.commands;

import java.util.List;

public class CommandDescription {
    private final CommandType commandType;
    private final List<String> arguments;

    public CommandDescription(String commandName, List<String> arguments) {
        this(CommandType.from(commandName), arguments);
    }

    public CommandDescription(CommandType commandType, List<String> arguments) {
        this.commandType = commandType;
        this.arguments = arguments;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public List<String> getArguments() {
        return arguments;
    }
}
