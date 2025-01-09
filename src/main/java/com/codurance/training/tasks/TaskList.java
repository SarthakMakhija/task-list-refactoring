package com.codurance.training.tasks;

import java.io.Writer;

public final class TaskList {

    private final AddTaskCommand addTaskCommand;
    private final AddProjectCommand addProjectCommand;
    private final ShowCommand showCommand;
    private final CheckCommand checkCommand;
    private final UncheckCommand uncheckCommand;

    public TaskList(Writer writer) {
        Projects projects = new Projects();
        this.addTaskCommand = new AddTaskCommand(projects);
        this.addProjectCommand = new AddProjectCommand(projects);
        this.showCommand = new ShowCommand(writer, projects);
        this.checkCommand = new CheckCommand(writer, projects);
        this.uncheckCommand = new UncheckCommand(writer, projects);
    }

    public void execute(String commandLine) throws Exception {
        CommandDescription commandDescription = new CommandLine(commandLine).parse();
        switch (commandDescription.getCommandType()) {
            case ADD_TASK:
                this.addTaskCommand.execute(commandDescription.getArguments());
                break;
            case ADD_PROJECT:
                this.addProjectCommand.execute(commandDescription.getArguments());
                break;
            case SHOW:
                this.showCommand.execute(commandDescription.getArguments());
                break;
            case CHECK:
                this.checkCommand.execute(commandDescription.getArguments());
                break;
            case UNCHECK:
                this.uncheckCommand.execute(commandDescription.getArguments());
                break;
        }
    }
}

