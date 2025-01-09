package com.codurance.training.commands;

import java.util.List;

public class CommandDescription {
    private final CommandType commandType;
    private final Arguments arguments;

    CommandDescription(String commandName, List<String> arguments) {
        this(CommandType.from(commandName), arguments);
    }

    CommandDescription(CommandType commandType, List<String> arguments) {
        this.commandType = commandType;
        this.arguments = new Arguments(arguments);
    }

    CommandType commandType() {
        return commandType;
    }

    List<String> arguments() {
        return arguments.arguments;
    }
}
