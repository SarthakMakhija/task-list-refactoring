package com.codurance.training.tasks;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Projects extends LinkedHashMap<String, Project> {

    public void addProject(String name) {
        this.put(name, new Project(name));
    }

    public void addTaskToProjectWithName(String projectName, Task task) {
        Project project = this.get(projectName);
        if (project == null) {
            throw new IllegalArgumentException("Unknown project: " + projectName);
        }
        project.addTask(task);
    }

    public boolean markTaskWithIdDone(int id) {
        return this.values().stream().anyMatch((Project project) -> project.markTaskWithIdDone(id));
    }

    public boolean markTaskWithIdNotDone(int id) {
        return this.values().stream().anyMatch((Project project) -> project.markTaskWithIdNotDone(id));
    }

    public String format() {
        return this.values().stream().map(Project::format).collect(Collectors.joining());
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