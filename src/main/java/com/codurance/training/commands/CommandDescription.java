package com.codurance.training.commands;

public class CommandDescription {
    private final CommandType commandType;
    private final Arguments arguments;

    CommandDescription(String commandName, Arguments arguments) {
        this(CommandType.from(commandName), arguments);
    }

    CommandDescription(CommandType commandType, Arguments arguments) {
        this.commandType = commandType;
        this.arguments = arguments;
    }

    CommandType commandType() {
        return commandType;
    }

    Arguments arguments() {
        return arguments;
    }
}
