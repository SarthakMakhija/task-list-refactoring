package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.Task;

class AddTaskCommand implements Command {
    private final Projects projects;
    private long lastTaskId = 0;

    AddTaskCommand(Projects projects) {
        this.projects = projects;
    }

    public void execute(Arguments arguments) {
        assert (arguments.size() == 2);
        String projectName = arguments.get(0);
        String taskDescription = arguments.get(1);

        this.lastTaskId = this.lastTaskId + 1;
        projects.addTaskToProjectWithName(projectName, new Task(this.lastTaskId, taskDescription, false));
    }
}
