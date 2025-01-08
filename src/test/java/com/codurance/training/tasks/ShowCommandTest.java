package com.codurance.training.tasks;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class ShowCommandTest {

    @Test
    public void executeShowCommandWithAProjectContainingASingleTask() throws IOException {
        StringWriter writer = new StringWriter();

        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", new Task(1, "Task 1", false));

        ShowCommand command = new ShowCommand(writer, projects);
        command.execute();

        String expected = "caizin\n" + "[ ] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void executeShowCommandWithAProjectContainingACoupleOfTasks() throws IOException {
        StringWriter writer = new StringWriter();

        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", new Task(1, "Task 1", false));
        projects.addTaskToProjectWithName("caizin", new Task(2, "Task 2", false));

        ShowCommand command = new ShowCommand(writer, projects);
        command.execute();

        String expected = "caizin\n" + "[ ] 1: Task 1\n" + "[ ] 2: Task 2\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void executeShowCommandWithAProjectContainingACoupleOfTasksOneOfThemDone() throws IOException {
        StringWriter writer = new StringWriter();

        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", new Task(1, "Task 1", false));
        projects.addTaskToProjectWithName("caizin", new Task(2, "Task 2", true));

        ShowCommand command = new ShowCommand(writer, projects);
        command.execute();

        String expected = "caizin\n" + "[ ] 1: Task 1\n" + "[x] 2: Task 2\n";
        assertEquals(expected, projects.format());
    }
}