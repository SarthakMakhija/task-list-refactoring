package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddCommandRegistry implements Command {
    private final Map<String, Command> commandBySubCommand = new HashMap<>();

    public AddCommandRegistry(Projects projects) {
        commandBySubCommand.put("project", new AddProjectCommand(projects));
        commandBySubCommand.put("task", new AddTaskCommand(projects));
    }

    @Override
    public void execute(List<String> arguments) throws Exception {
        Command command = this.commandBySubCommand.get(arguments.get(0));
        if (command == null) {
            throw new IllegalArgumentException("Unknown command: " + arguments.get(0));
        }
        command.execute(arguments.subList(1, arguments.size()));
    }
}
