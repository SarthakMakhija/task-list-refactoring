package com.codurance.training.tasks;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UncheckCommandTest {

    @Test
    public void attemptToExecuteUncheckTaskCommand() {
        StringWriter writer = new StringWriter();
        Projects projects = new Projects();

        UncheckCommand uncheckCommand = new UncheckCommand(writer, projects);
        assertThrows(AssertionError.class, () -> uncheckCommand.execute(List.of()));
    }

    @Test
    public void executeUncheckCommandByUncheckingATask() throws IOException {
        StringWriter writer = new StringWriter();

        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", new Task(1, "Task 1", true));

        UncheckCommand uncheckCommand = new UncheckCommand(writer, projects);
        uncheckCommand.execute(List.of("1"));

        String expected = "caizin\n" + "[ ] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }
}