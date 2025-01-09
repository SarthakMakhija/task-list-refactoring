package com.codurance.training.tasks;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CheckCommand {

    private final Writer writer;
    private final Projects projects;

    CheckCommand(Writer writer, Projects projects) {
        this.writer = writer;
        this.projects = projects;
    }

    void execute(List<String> arguments) throws IOException {
        int taskId = Integer.parseInt(arguments.get(0));
        if (projects.toggleTaskWithId(taskId, true)) return;
        writer.write(String.format("Could not find a task with an ID of %d\n", taskId));
    }
}
