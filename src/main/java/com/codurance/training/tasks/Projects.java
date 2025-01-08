package com.codurance.training.tasks;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Projects extends LinkedHashMap<String, Tasks> {

    void addProject(String name) {
        this.put(name, new Tasks());
    }

    void addTaskToProjectWithName(String project, Task task) {
        List<Task> projectTasks = this.get(project);
        if (projectTasks == null) {
            throw new IllegalArgumentException("Unknown project: " + project);
        }
        projectTasks.add(task);
    }

    String format() {
        StringBuilder formatted = new StringBuilder();
        for (Map.Entry<String, Tasks> project : this.entrySet()) {
            formatted.append(project.getKey());
            formatted.append("\n");
            formatted.append(project.getValue().format());
        }
        return formatted.toString();
    }
}
