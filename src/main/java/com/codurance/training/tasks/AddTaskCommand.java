package com.codurance.training.tasks;

import java.io.IOException;
import java.util.List;

public class AddTaskCommand {
    private final Projects projects;
    private long lastTaskId = 0;

    AddTaskCommand(Projects projects) {
        this.projects = projects;
    }

    void execute(List<String> arguments) throws IOException {
        String projectName = arguments.get(0);
        String taskDescription = arguments.get(1);

        this.lastTaskId = this.lastTaskId + 1;
        projects.addTaskToProjectWithName(projectName, new Task(this.lastTaskId, taskDescription, false));
    }
}
