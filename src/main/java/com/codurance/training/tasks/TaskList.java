package com.codurance.training.tasks;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public final class TaskList {

    private final Projects projects = new Projects();
    private final AddTaskCommand addTaskCommand = new AddTaskCommand(projects);
    private final Writer writer;

    public TaskList(Writer writer) {
        this.writer = writer;
    }

    public void execute(String commandLine) throws Exception {
        String[] parts = commandLine.split(" ", 2);
        String command = parts[0];
        switch (command) {
            case "show":
                new ShowCommand(writer, projects).execute(null);
                break;
            case "add":
                add(parts[1]);
                break;
            case "check":
                new CheckCommand(writer, projects).execute(List.of(parts[1]));
                break;
            case "uncheck":
                new UncheckCommand(writer, projects).execute(List.of(parts[1]));
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }

    private void add(String commandLine) throws IOException {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            new AddProjectCommand(projects).execute(List.of(subcommandRest[1]));
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTaskCommand.execute(List.of(projectTask));
        }
    }
}
