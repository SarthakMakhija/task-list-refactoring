package com.codurance.training.tasks;

import java.util.LinkedHashMap;
import java.util.Map;

public class Projects extends LinkedHashMap<String, Project> {

    void addProject(String name) {
        this.put(name, new Project(name));
    }

    void addTaskToProjectWithName(String projectName, Task task) {
        Project project = this.get(projectName);
        if (project == null) {
            throw new IllegalArgumentException("Unknown project: " + project);
        }
        project.addTask(task);
    }

    boolean toggleTaskWithId(int id, boolean done) {
        for (Map.Entry<String, Project> project : this.entrySet()) {
            if (project.getValue().tasks.toggleTaskWithId(id, done)) return true;
        }
        return false;
    }

    String format() {
        StringBuilder formatted = new StringBuilder();
        for (Map.Entry<String, Project> project : this.entrySet()) {
            formatted.append(project.getKey());
            formatted.append("\n");
            formatted.append(project.getValue().tasks.format());
        }
        return formatted.toString();
    }
}

class Project {
    private final String name;
    final Tasks tasks;

    public Project(String name) {
        this.name = name;
        this.tasks = new Tasks();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }
}