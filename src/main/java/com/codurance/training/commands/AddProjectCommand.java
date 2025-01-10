package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;

class AddProjectCommand implements Command {
    private final Projects projects;

    AddProjectCommand(Projects projects) {
        this.projects = projects;
    }

    public void execute(Arguments arguments)  {
        assert (arguments.size() == 1);
        String projectName = arguments.get(0);
        projects.addProject(projectName);
    }
}
