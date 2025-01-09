package com.codurance.training.tasks;

import java.util.ArrayList;

class Tasks extends ArrayList<Task> {

    String format() {
        StringBuilder formatted = new StringBuilder();
        for (Task task : this) {
            formatted.append(task.format());
        }
        return formatted.toString();
    }

    boolean markTaskWithIdDone(int id) {
        for (Task task : this) {
            if (task.matchesId(id)) {
                task.markDone();
                return true;
            }
        }
        return false;
    }

    boolean markTaskWithIdNotDone(int id) {
        for (Task task : this) {
            if (task.matchesId(id)) {
                task.markNotDone();
                return true;
            }
        }
        return false;
    }
}
