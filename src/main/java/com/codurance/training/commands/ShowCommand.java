package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

class ShowCommand implements Command {
    private final Writer writer;
    private final Projects projects;

    ShowCommand(Writer writer, Projects projects) {
        this.writer = writer;
        this.projects = projects;
    }

    public void execute(List<String> arguments) throws Exception {
        assert (arguments.isEmpty());
        this.writer.write(this.projects.format());
    }
}
