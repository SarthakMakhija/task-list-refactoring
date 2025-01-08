package com.codurance.training.tasks;

import java.io.IOException;
import java.io.Writer;

public class ShowCommand {
    private final Writer writer;
    private final Projects projects;

    ShowCommand(Writer writer, Projects projects) {
        this.writer = writer;
        this.projects = projects;
    }

    void execute() throws IOException {
        this.writer.write(this.projects.format());
    }
}
