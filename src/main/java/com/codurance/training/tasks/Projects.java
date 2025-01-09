package com.codurance.training.tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Projects  {

    private final Map<String, Project> projects = new LinkedHashMap<>();

    public void addProject(String name) {
        this.projects.put(name, new Project(name));
    }

    public void addTaskToProjectWithName(String projectName, Task task) {
        Project project = this.projects.get(projectName);
        if (project == null) {
            throw new IllegalArgumentException("Unknown project: " + projectName);
        }
        project.addTask(task);
    }

    public boolean markTaskWithIdDone(int id) {
        return this.projects.values().stream().anyMatch((Project project) -> project.markTaskWithIdDone(id));
    }

    public boolean markTaskWithIdNotDone(int id) {
        return this.projects.values().stream().anyMatch((Project project) -> project.markTaskWithIdNotDone(id));
    }

    public String format() {
        return this.projects.values().stream().map(Project::format).collect(Collectors.joining());
    }
}

class Project {
    final String name;
    final Tasks tasks;

    Project(String name) {
        this.name = name;
        this.tasks = new Tasks();
    }

    void addTask(Task task) {
        this.tasks.add(task);
    }

    boolean markTaskWithIdDone(int id) {
        return this.tasks.markTaskWithIdDone(id);
    }

    boolean markTaskWithIdNotDone(int id) {
        return this.tasks.markTaskWithIdNotDone(id);
    }

    String format() {
        return this.name + "\n" + this.tasks.format();
    }
}