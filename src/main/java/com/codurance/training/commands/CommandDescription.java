package com.codurance.training.commands;

import java.util.List;

public class CommandDescription {
    private final CommandType commandType;
    private final List<String> arguments;

    CommandDescription(String commandName, List<String> arguments) {
        this(CommandType.from(commandName), arguments);
    }

    CommandDescription(CommandType commandType, List<String> arguments) {
        this.commandType = commandType;
        this.arguments = arguments;
    }

    CommandType getCommandType() {
        return commandType;
    }

    List<String> getArguments() {
        return arguments;
    }
}
