package com.codurance.training.tasks;

import java.io.IOException;
import java.io.Writer;

public class UncheckCommand {

    private final Writer writer;
    private final Projects projects;

    UncheckCommand(Writer writer, Projects projects) {
        this.writer = writer;
        this.projects = projects;
    }

    void execute(String[] arguments) throws IOException {
        int taskId = Integer.parseInt(arguments[0]);
        if (projects.toggleTaskWithId(taskId, false)) return;
        writer.write(String.format("Could not find a task with an ID of %d\n", taskId));
    }
}
