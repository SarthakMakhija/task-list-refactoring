package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;

import java.io.Writer;

class UncheckCommand implements Command {
    private final Writer writer;
    private final Projects projects;
    private final NonExistingTaskId nonExistingTaskId;

    UncheckCommand(Writer writer, Projects projects) {
        this(writer, projects, new NonExistingTaskId("Could not find a task with an ID of"));
    }

    UncheckCommand(Writer writer, Projects projects, NonExistingTaskId nonExistingTaskId) {
        this.writer = writer;
        this.projects = projects;
        this.nonExistingTaskId = nonExistingTaskId;
    }

    @Override
    public void execute(Arguments arguments) throws Exception {
        assert (arguments.count() == 1);
        if (projects.markTaskWithIdNotDone(arguments.argumentAtIndexAsInt(0))) return;
        writer.write(nonExistingTaskId.errorMessage(arguments.argumentAtIndexAsInt(0)));
    }
}

class CheckCommand implements Command {
    private final Writer writer;
    private final Projects projects;
    private final NonExistingTaskId nonExistingTaskId;

    CheckCommand(Writer writer, Projects projects) {
        this(writer, projects, new NonExistingTaskId("Could not find a task with an ID of"));
    }

    CheckCommand(Writer writer, Projects projects, NonExistingTaskId nonExistingTaskId) {
        this.writer = writer;
        this.projects = projects;
        this.nonExistingTaskId = nonExistingTaskId;
    }

    @Override
    public void execute(Arguments arguments) throws Exception {
        assert (arguments.count() == 1);
        if (projects.markTaskWithIdDone(arguments.argumentAtIndexAsInt(0))) return;
        writer.write(nonExistingTaskId.errorMessage(arguments.argumentAtIndexAsInt(0)));
    }
}

class NonExistingTaskId {
    private final String errorMessagePrefix;

    NonExistingTaskId(String errorMessagePrefix) {
        this.errorMessagePrefix = errorMessagePrefix;
    }

    public String errorMessage(int taskId) {
        return errorMessagePrefix + " " + taskId + "\n";
    }
}