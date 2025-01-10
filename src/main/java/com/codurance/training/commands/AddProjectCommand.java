package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;

class AddProjectCommand implements Command {
    private final Projects projects;

    AddProjectCommand(Projects projects) {
        this.projects = projects;
    }

    @Override
    public void execute(Arguments arguments)  {
        assert (arguments.count() == 1);
        String projectName = arguments.argumentAtIndexAsString(0);
        projects.addProject(projectName);
    }
}
