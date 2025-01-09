package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;

import java.io.Writer;

class CheckCommand implements Command {
    private final Writer writer;
    private final Projects projects;

    CheckCommand(Writer writer, Projects projects) {
        this.writer = writer;
        this.projects = projects;
    }

    public void execute(Arguments arguments) throws Exception {
        assert (arguments.size() == 1);
        if (projects.markTaskWithIdDone(arguments.argumentAtIndexAsInt(0))) return;
        writer.write(String.format("Could not find a task with an ID of %d\n", arguments.argumentAtIndexAsInt(0)));
    }
}
