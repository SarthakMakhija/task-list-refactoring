package com.codurance.training.tasks;

import java.util.List;

public class CommandDescription {
    private final CommandType commandType;
    private final List<String> arguments;

    public CommandDescription(String commandName, List<String> arguments) {
        this.commandType = CommandType.from(commandName);
        this.arguments = arguments;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public List<String> getArguments() {
        return arguments;
    }
}
