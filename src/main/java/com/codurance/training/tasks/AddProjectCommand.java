package com.codurance.training.tasks;

import java.io.IOException;

public class AddProjectCommand {
    private final Projects projects;

    AddProjectCommand(Projects projects) {
        this.projects = projects;
    }

    void execute(String[] arguments) throws IOException {
        String projectName = arguments[0];
        projects.addProject(projectName);
    }
}
