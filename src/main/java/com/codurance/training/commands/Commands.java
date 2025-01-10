package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

interface Command {
    void execute(Arguments arguments) throws Exception;
}


public class Commands {
    private final Map<CommandType, Command> commandByType = new HashMap<>();

    public Commands(Writer writer) {
        Projects projects = new Projects();
        commandByType.put(CommandType.ADD, new AddCommands(projects));
        commandByType.put(CommandType.SHOW, new ShowCommand(writer, projects));
        commandByType.put(CommandType.CHECK, new CheckCommand(writer, projects));
        commandByType.put(CommandType.UNCHECK, new UncheckCommand(writer, projects));
    }

    public void execute(CommandDescription commandDescription) throws Exception {
        commandByType.get(commandDescription.commandType()).execute(commandDescription.arguments());
    }
}
