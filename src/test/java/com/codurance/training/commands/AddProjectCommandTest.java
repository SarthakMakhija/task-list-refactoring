package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AddProjectCommandTest {

    @Test
    public void attemptToExecuteAddProjectCommandGivenNoArgumentsAreProvided() {
        Projects projects = new Projects();

        AddProjectCommand addProjectCommand = new AddProjectCommand(projects);
        assertThrows(AssertionError.class, () -> addProjectCommand.execute(new Arguments(List.of())));
    }

    @Test
    public void executeAddProjectCommandByAddingAProject() {
        Projects projects = new Projects();

        AddProjectCommand addProjectCommand = new AddProjectCommand(projects);
        addProjectCommand.execute(new Arguments(List.of("caizin")));

        assertEquals("caizin\n", projects.format());
    }
}