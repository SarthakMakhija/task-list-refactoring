package com.codurance.training.commands;

import com.codurance.training.tasks.Projects;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddCommandsTest {

    @Test
    public void executeAddProject() throws Exception {
        Projects projects = new Projects();

        AddCommands addCommands = new AddCommands(projects);
        addCommands.execute(new Arguments(List.of("project", "caizin")));

        String expected = "caizin\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void executeAddTaskInAProject() throws Exception {
        Projects projects = new Projects();

        AddCommands addCommands = new AddCommands(projects);
        addCommands.execute(new Arguments(List.of("project", "caizin")));
        addCommands.execute(new Arguments(List.of("task", "caizin", "Task1")));

        String expected = "caizin\n[ ] 1: Task1\n";
        assertEquals(expected, projects.format());
    }
}