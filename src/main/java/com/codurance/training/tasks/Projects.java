package com.codurance.training.tasks;

import java.util.LinkedHashMap;

public class Projects extends LinkedHashMap<String, Project> {

    void addProject(String name) {
        this.put(name, new Project(name));
    }

    void addTaskToProjectWithName(String projectName, Task task) {
        Project project = this.get(projectName);
        if (project == null) {
            throw new IllegalArgumentException("Unknown project: " + projectName);
        }
        project.addTask(task);
    }

    boolean toggleTaskWithId(int id, boolean done) {
        return this.values().stream().anyMatch((Project project) -> project.toggleTaskWithId(id, done));
    }

    String format() {
        StringBuilder formatted = new StringBuilder();
        this.values().stream().map(Project::format).forEach(formatted::append);
        return formatted.toString();
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

    boolean toggleTaskWithId(int id, boolean done) {
        return this.tasks.toggleTaskWithId(id, done);
    }

    String format() {
        return this.name +
                "\n" +
                this.tasks.format();
    }
}