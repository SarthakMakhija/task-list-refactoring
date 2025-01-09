package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AddTaskCommandTest {

    @Test
    public void attemptToExecuteAddTaskCommand() {
        Projects projects = new Projects();

        AddTaskCommand addTaskCommand = new AddTaskCommand(projects);
        assertThrows(AssertionError.class, () -> addTaskCommand.execute(new Arguments(List.of())));
    }

    @Test
    public void executeCheckCommandByAddingATaskToAProject() throws Exception {
        Projects projects = new Projects();
        projects.addProject("caizin");

        AddTaskCommand addTaskCommand = new AddTaskCommand(projects);
        addTaskCommand.execute(new Arguments(List.of("caizin", "Task1")));

        assertEquals("caizin\n[ ] 1: Task1\n", projects.format());
    }
}