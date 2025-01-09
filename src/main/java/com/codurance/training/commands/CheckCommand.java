package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CheckCommand implements Command {

    private final Writer writer;
    private final Projects projects;

    CheckCommand(Writer writer, Projects projects) {
        this.writer = writer;
        this.projects = projects;
    }

    public void execute(List<String> arguments) throws IOException {
        assert (arguments.size() == 1);
        int taskId = Integer.parseInt(arguments.get(0));
        if (projects.toggleTaskWithId(taskId, true)) return;
        writer.write(String.format("Could not find a task with an ID of %d\n", taskId));
    }
}
