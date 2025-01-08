package com.codurance.training.tasks;

import java.io.IOException;
import java.io.Writer;

public class CheckCommand {

    private final Writer writer;
    private final Projects projects;

    CheckCommand(Writer writer, Projects projects) {
        this.writer = writer;
        this.projects = projects;
    }

    void execute(int taskId) throws IOException {
        if (projects.toggleTaskWithId(taskId, true)) return;
        writer.write(String.format("Could not find a task with an ID of %d\n", taskId));
    }
}
