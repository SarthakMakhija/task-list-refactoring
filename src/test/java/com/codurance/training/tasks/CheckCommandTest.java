package com.codurance.training.tasks;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class CheckCommandTest {

    @Test
    public void executeCheckCommandByCheckingATask() throws IOException {
        StringWriter writer = new StringWriter();

        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", new Task(1, "Task 1", false));

        CheckCommand checkCommand = new CheckCommand(writer, projects);
        checkCommand.execute(new String[]{"1"});

        String expected = "caizin\n" + "[x] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }
}