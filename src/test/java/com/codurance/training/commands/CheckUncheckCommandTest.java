package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.Task;
import org.junit.Test;

import java.io.StringWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CheckUncheckCommandTest {

    @Test
    public void attemptToExecuteUncheckTaskCommandGivenNoArgumentsAreProvided() {
        StringWriter writer = new StringWriter();
        Projects projects = new Projects();

        UncheckCommand uncheckCommand = new UncheckCommand(writer, projects);
        assertThrows(AssertionError.class, () -> uncheckCommand.execute(new Arguments(List.of())));
    }

    @Test
    public void attemptToExecuteUncheckCommandForANonExistingTaskId() throws Exception {
        StringWriter writer = new StringWriter();
        Projects projects = new Projects();

        UncheckCommand uncheckCommand = new UncheckCommand(writer, projects, new NonExistingTaskId("Not found, Task id"));
        uncheckCommand.execute(new Arguments(List.of("100")));

        assertEquals("Not found, Task id 100\n", writer.toString());
    }

    @Test
    public void executeUncheckCommandByUncheckingATask() throws Exception {
        StringWriter writer = new StringWriter();

        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", Task.newTask(1, "Task 1"));

        UncheckCommand uncheckCommand = new UncheckCommand(writer, projects);
        uncheckCommand.execute(new Arguments(List.of("1")));

        String expected = "caizin\n" + "[ ] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void attemptToExecuteCheckTaskCommandGivenNoArgumentsAreProvided() {
        StringWriter writer = new StringWriter();
        Projects projects = new Projects();

        CheckCommand checkCommand = new CheckCommand(writer, projects);
        assertThrows(AssertionError.class, () -> checkCommand.execute(new Arguments(List.of())));
    }

    @Test
    public void attemptToExecuteCheckCommandForANonExistingTaskId() throws Exception {
        StringWriter writer = new StringWriter();
        Projects projects = new Projects();

        CheckCommand checkCommand = new CheckCommand(writer, projects, new NonExistingTaskId("Not found, Task id"));
        checkCommand.execute(new Arguments(List.of("100")));

        assertEquals("Not found, Task id 100\n", writer.toString());
    }

    @Test
    public void executeCheckCommandByCheckingATask() throws Exception {
        StringWriter writer = new StringWriter();

        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", Task.newTask(1, "Task 1"));

        CheckCommand checkCommand = new CheckCommand(writer, projects);
        checkCommand.execute(new Arguments(List.of("1")));

        String expected = "caizin\n" + "[x] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }
}