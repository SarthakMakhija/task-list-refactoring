package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.Task;
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
        assertThrows(AssertionError.class, () -> uncheckCommand.execute(new Arguments(List.of())));
    }

    @Test
    public void executeUncheckCommandByUncheckingATask() throws Exception {
        StringWriter writer = new StringWriter();

        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", new Task(1, "Task 1", true));

        UncheckCommand uncheckCommand = new UncheckCommand(writer, projects);
        uncheckCommand.execute(new Arguments(List.of("1")));

        String expected = "caizin\n" + "[ ] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }
}