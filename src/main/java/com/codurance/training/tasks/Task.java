package com.codurance.training.tasks;

public final class Task {
    private final long id;
    private final String description;
    private boolean done;

    public static Task newTask(long id, String description) {
        return new Task(id, description, false);
    }

    Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    String format() {
        return String.format("[%c] %d: %s%n", (done ? 'x' : ' '), id, description);
    }

    boolean matchesId(int id) {
        return this.id == id;
    }

    void markDone() {
        this.done = true;
    }

    void markNotDone() {
        this.done = false;
    }
}
