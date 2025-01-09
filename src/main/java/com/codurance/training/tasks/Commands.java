package com.codurance.training.tasks;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Commands {
    private final Map<CommandType, Command> commandByType = new HashMap<>();

    public Commands(Writer writer) {
        Projects projects = new Projects();
        commandByType.put(CommandType.ADD_PROJECT, new AddProjectCommand(projects));
        commandByType.put(CommandType.ADD_TASK, new AddTaskCommand(projects));
        commandByType.put(CommandType.SHOW, new ShowCommand(writer, projects));
        commandByType.put(CommandType.CHECK, new CheckCommand(writer, projects));
        commandByType.put(CommandType.UNCHECK, new UncheckCommand(writer, projects));
    }

    public void execute(CommandDescription commandDescription) throws IOException {
        commandByType.get(commandDescription.getCommandType()).execute(commandDescription.getArguments());
    }
}
