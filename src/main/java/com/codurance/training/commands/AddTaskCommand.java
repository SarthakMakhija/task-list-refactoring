package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.Task;

class AddTaskCommand implements Command {
    private final Projects projects;
    private long lastTaskId = 0;

    AddTaskCommand(Projects projects) {
        this.projects = projects;
    }

    @Override
    public void execute(Arguments arguments) {
        assert (arguments.count() == 2);
        String projectName = arguments.argumentAtIndexAsString(0);
        String taskDescription = arguments.argumentAtIndexAsString(1);

        this.lastTaskId = this.lastTaskId + 1;
        projects.addTaskToProjectWithName(projectName, Task.newTask(this.lastTaskId, taskDescription));
    }
}
