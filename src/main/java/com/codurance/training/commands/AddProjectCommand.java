package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;

import java.io.IOException;
import java.util.List;

class AddProjectCommand implements Command {
    private final Projects projects;

    AddProjectCommand(Projects projects) {
        this.projects = projects;
    }

    public void execute(List<String> arguments) throws Exception {
        assert (arguments.size() == 1);
        String projectName = arguments.get(0);
        projects.addProject(projectName);
    }
}
