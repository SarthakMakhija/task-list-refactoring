package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;

import java.util.HashMap;
import java.util.Map;

public class AddCommands implements Command {
    private final Map<String, Command> commandBySubCommand = new HashMap<>();

    public AddCommands(Projects projects) {
        commandBySubCommand.put("project", new AddProjectCommand(projects));
        commandBySubCommand.put("task", new AddTaskCommand(projects));
    }

    @Override
    public void execute(Arguments arguments) throws Exception {
        Command command = this.commandBySubCommand.get(arguments.argumentAtIndexAsString(0));
        if (command == null) {
            throw new IllegalArgumentException("Unknown command: " + arguments.argumentAtIndexAsString(0));
        }
        command.execute(arguments.skipOne());
    }
}
