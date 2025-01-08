package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ProjectsTest {

    @Test
    public void formatProjectsWithASingleProject() {
        Projects projects = new Projects();

        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", new Task(1, "Task 1", true));

        String expected = "caizin\n" + "[x] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void formatProjectsWithACoupleOfProjects() {
        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addProject("database");

        projects.addTaskToProjectWithName("caizin", new Task(1, "Task 1", true));
        projects.addTaskToProjectWithName("database", new Task(2, "Task 2", true));

        String expected = "caizin\n" + "[x] 1: Task 1\n" + "database\n" + "[x] 2: Task 2\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void toggleTaskAsNotDone() {
        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", new Task(1, "Task 1", true));

        projects.toggleTaskWithId(1, false);

        String expected = "caizin\n" + "[ ] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void toggleTaskAsDone() {
        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", new Task(1, "Task 1", false));

        projects.toggleTaskWithId(1, true);

        String expected = "caizin\n" + "[x] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void attemptToToggleTaskWithNonExistingId() {
        Projects projects = new Projects();
        projects.addProject("caizin");

        assertFalse(projects.toggleTaskWithId(100, true));
    }
}