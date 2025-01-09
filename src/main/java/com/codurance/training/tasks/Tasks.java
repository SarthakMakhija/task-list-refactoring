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

    boolean toggleTaskWithId(int id, boolean done) {
        for (Task task : this) {
            if (task.matchesId(id)) {
                task.setDone(done);
                return true;
            }
        }
        return false;
    }
}
