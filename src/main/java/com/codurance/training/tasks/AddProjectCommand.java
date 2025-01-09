package com.codurance.training.tasks;

import java.io.IOException;
import java.util.List;

public class AddProjectCommand implements Command {
    private final Projects projects;

    AddProjectCommand(Projects projects) {
        this.projects = projects;
    }

    public void execute(List<String> arguments) throws IOException {
        assert (arguments.size() == 1);
        String projectName = arguments.get(0);
        projects.addProject(projectName);
    }
}
