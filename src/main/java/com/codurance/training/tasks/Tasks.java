package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class Tasks extends ArrayList<Task> {

    String format() {
        return this.stream().map(Task::format).collect(Collectors.joining());
    }

    boolean markTaskWithIdDone(int id) {
        return executeBlockOnMatchingTask(id, Task::markDone);
    }

    boolean markTaskWithIdNotDone(int id) {
        return executeBlockOnMatchingTask(id, Task::markNotDone);
    }

    boolean executeBlockOnMatchingTask(int id, Consumer<Task> block) {
        return this.stream().filter(task -> task.matchesId(id)).findFirst().map(task -> {
            block.accept(task);
            return true;
        }).orElse(false);
    }
}
