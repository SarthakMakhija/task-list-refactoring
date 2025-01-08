package com.codurance.training.tasks;

import java.util.LinkedHashMap;
import java.util.Map;

public class Projects extends LinkedHashMap<String, Tasks> {

    void addProject(String name) {
        this.put(name, new Tasks());
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
