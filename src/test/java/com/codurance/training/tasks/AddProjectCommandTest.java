package com.codurance.training.tasks;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddProjectCommandTest {

    @Test
    public void executeAddProjectCommandByAddingAProject() throws IOException {
        Projects projects = new Projects();

        AddProjectCommand addProjectCommand = new AddProjectCommand(projects);
        addProjectCommand.execute(List.of("caizin"));

        assertEquals("caizin\n", projects.format());
    }
}