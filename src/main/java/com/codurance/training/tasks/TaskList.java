package com.codurance.training.tasks;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public final class TaskList {

    private final Map<String, Tasks> projects = new LinkedHashMap<>();
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
                show();
                break;
            case "add":
                add(commandRest[1]);
                break;
            case "check":
                check(commandRest[1]);
                break;
            case "uncheck":
                uncheck(commandRest[1]);
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }

    private void show() throws IOException {
        format(projects, writer);
    }

    //format does not belong here, it belongs to Map<String, Tasks>.
    private static void format(Map<String, Tasks> projects, Writer writer) throws IOException {
        for (Map.Entry<String, Tasks> project : projects.entrySet()) {
            writer.write(project.getKey());
            writer.write("\n");
            writer.write(project.getValue().format());
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
        projects.put(name, new Tasks());
    }

    private void addTask(String project, String description) {
        List<Task> projectTasks = projects.get(project);
        if (projectTasks == null) {
            throw new IllegalArgumentException("Unknown project: " + project);
        }
        projectTasks.add(new Task(nextId(), description, false));
    }

    private void check(String idString) {
        setDone(idString, true);
    }

    private void uncheck(String idString) {
        setDone(idString, false);
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, Tasks> project : projects.entrySet()) {
            Tasks tasks = project.getValue();
            if (tasks.toggleTaskWithId(id, done)) return;
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }

    private long nextId() {
        return ++lastId;
    }
}
