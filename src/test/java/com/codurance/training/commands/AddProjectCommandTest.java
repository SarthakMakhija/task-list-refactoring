package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AddProjectCommandTest {

    @Test
    public void attemptToExecuteAddProjectCommand() {
        Projects projects = new Projects();

        AddProjectCommand addProjectCommand = new AddProjectCommand(projects);
        assertThrows(AssertionError.class, () -> addProjectCommand.execute(List.of()));
    }

    @Test
    public void executeAddProjectCommandByAddingAProject() throws IOException {
        Projects projects = new Projects();

        AddProjectCommand addProjectCommand = new AddProjectCommand(projects);
        addProjectCommand.execute(List.of("caizin"));

        assertEquals("caizin\n", projects.format());
    }
}