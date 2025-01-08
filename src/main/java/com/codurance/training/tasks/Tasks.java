package com.codurance.training.tasks;

import java.util.ArrayList;

public class Tasks extends ArrayList<Task> {

    String format() {
        StringBuilder formatted = new StringBuilder();
        for (Task task : this) {
            formatted.append(task.format());
        }
        return formatted.toString();
    }

    boolean toggleTaskWithId(int id, boolean done) {
        for (Task task : this) {
            if (matchesId(id, task)) {
                task.setDone(done);
                return true;
            }
        }
        return false;
    }

    private static boolean matchesId(int id, Task task) {
        return task.getId() == id;
    }
}
