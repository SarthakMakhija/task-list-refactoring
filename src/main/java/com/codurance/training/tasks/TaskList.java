package com.codurance.training.tasks;

import java.io.Writer;

public final class TaskList {

    private final Projects projects = new Projects();
    private final Writer writer;
    private long lastId = 0;

    public TaskList(Writer writer) {
        this.writer = writer;
    }

    /**
     * command parsing
     * command arguments
     * - CommandArguments (maybe?)
     * command execution decision-making
     * command execution
     * - Commands with a switch and multiple commands for execution
     */

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
                new CheckCommand(writer, projects).execute(new String[]{parts[1]});
                break;
            case "uncheck":
                new UncheckCommand(writer, projects).execute(new String[]{parts[1]});
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }

    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
    }

    private void addProject(String name) {
        projects.addProject(name);
    }

    private void addTask(String project, String description) {
        projects.addTaskToProjectWithName(project, new Task(nextId(), description, false));
    }

    private long nextId() {
        return ++lastId;
    }
}
