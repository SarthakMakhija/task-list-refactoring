package com.codurance.training.tasks;

public final class Task {
    private final long id;
    private final String description;
    private boolean done;

    public Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public String format() {
        return String.format("[%c] %d: %s%n", (done ? 'x' : ' '), id, description);
    }

    public boolean matchesId(int id) {
        return this.id == id;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
