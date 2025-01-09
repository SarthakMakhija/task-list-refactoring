package com.codurance.training.tasks;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddTaskCommandTest {

    @Test
    public void executeCheckCommandByAddingATaskToAProject() throws IOException {
        Projects projects = new Projects();
        projects.addProject("caizin");

        AddTaskCommand addTaskCommand = new AddTaskCommand(projects);
        addTaskCommand.execute(List.of("caizin", "Task1"));

        assertEquals("caizin\n[ ] 1: Task1\n", projects.format());
    }
}