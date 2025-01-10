package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.Task;
import org.junit.Test;

import java.io.StringWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ShowCommandTest {

    @Test
    public void attemptToExecuteShowTaskCommand() {
        StringWriter writer = new StringWriter();
        Projects projects = new Projects();

        ShowCommand showCommand = new ShowCommand(writer, projects);
        assertThrows(AssertionError.class, () -> showCommand.execute(new Arguments(List.of("not-meaningful"))));
    }

    @Test
    public void executeShowCommandWithAProjectContainingASingleTask() throws Exception {
        StringWriter writer = new StringWriter();

        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", Task.newTask(1, "Task 1"));

        ShowCommand command = new ShowCommand(writer, projects);
        command.execute(new Arguments(List.of()));

        String expected = "caizin\n" + "[ ] 1: Task 1\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void executeShowCommandWithAProjectContainingACoupleOfTasks() throws Exception {
        StringWriter writer = new StringWriter();

        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", Task.newTask(1, "Task 1"));
        projects.addTaskToProjectWithName("caizin", Task.newTask(2, "Task 2"));

        ShowCommand command = new ShowCommand(writer, projects);
        command.execute(new Arguments(List.of()));

        String expected = "caizin\n" + "[ ] 1: Task 1\n" + "[ ] 2: Task 2\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void executeShowCommandWithAProjectContainingACoupleOfTasksOneOfThemDone() throws Exception {
        StringWriter writer = new StringWriter();

        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", Task.newTask(1, "Task 1"));
        projects.addTaskToProjectWithName("caizin", Task.newTask(2, "Task 2"));
        projects.markTaskWithIdDone(2);

        ShowCommand command = new ShowCommand(writer, projects);
        command.execute(new Arguments(List.of()));

        String expected = "caizin\n" + "[ ] 1: Task 1\n" + "[x] 2: Task 2\n";
        assertEquals(expected, writer.toString());
    }
}