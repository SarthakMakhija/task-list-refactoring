package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Command {
    void execute(List<String> arguments) throws Exception;
}

//TODO: change the name, maybe TopLevelCommandRegistry
public class Commands {
    private final Map<CommandType, Command> commandByType = new HashMap<>();

    public Commands(Writer writer) {
        Projects projects = new Projects();
        commandByType.put(CommandType.ADD, new AddCommandRegistry(projects));
        commandByType.put(CommandType.SHOW, new ShowCommand(writer, projects));
        commandByType.put(CommandType.CHECK, new CheckCommand(writer, projects));
        commandByType.put(CommandType.UNCHECK, new UncheckCommand(writer, projects));
    }

    public void execute(CommandDescription commandDescription) throws Exception {
        commandByType.get(commandDescription.commandType()).execute(commandDescription.arguments());
    }
}
