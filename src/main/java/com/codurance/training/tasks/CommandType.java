package com.codurance.training.tasks;

public enum CommandType {
    ADD_PROJECT("add_project"), ADD_TASK("add_task"), SHOW("show"), CHECK("check"), UNCHECK("uncheck");

    private final String commandName;

    CommandType(String commandName) {
        this.commandName = commandName;
    }

    public static CommandType from(String commandName) {
        for (CommandType type : CommandType.values()) {
            if (type.commandName.equalsIgnoreCase(commandName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown command: " + commandName);
    }
}
