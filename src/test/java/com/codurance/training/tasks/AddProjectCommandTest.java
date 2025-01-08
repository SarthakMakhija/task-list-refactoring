package com.codurance.training.tasks;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AddProjectCommandTest {

    @Test
    public void executeAddProjectCommandByAddingAProject() throws IOException {
        Projects projects = new Projects();

        AddProjectCommand addProjectCommand = new AddProjectCommand(projects);
        addProjectCommand.execute(new String[]{"caizin"});

        assertEquals("caizin\n", projects.format());
    }
}