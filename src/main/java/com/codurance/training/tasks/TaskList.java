package com.codurance.training.tasks;

import java.io.Writer;

public final class TaskList {

    private final Projects projects = new Projects();
    private final Writer writer;
    private long lastId = 0;

    public TaskList(Writer writer) {
        this.writer = writer;
    }

    public void execute(String commandLine) throws Exception {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                new ShowCommand(writer, projects).execute();
                break;
            case "add":
                add(commandRest[1]);
                break;
            case "check":
                new CheckCommand(writer, projects).execute(Integer.parseInt(commandRest[1]));
                break;
            case "uncheck":
                new UncheckCommand(writer, projects).execute(Integer.parseInt(commandRest[1]));
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
