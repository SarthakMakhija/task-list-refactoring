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
    public void markTaskAsNotDone() {
        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", new Task(1, "Task 1", true));

        projects.markTaskWithIdNotDone(1);

        String expected = "caizin\n" + "[ ] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void markTaskAsDone() {
        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", new Task(1, "Task 1", false));

        projects.markTaskWithIdDone(1);

        String expected = "caizin\n" + "[x] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void attemptToMarkTaskWithNonExistingIdAsNotDone() {
        Projects projects = new Projects();
        projects.addProject("caizin");

        assertFalse(projects.markTaskWithIdNotDone(100));
    }

    @Test
    public void attemptToMarkTaskWithNonExistingIdAsDone() {
        Projects projects = new Projects();
        projects.addProject("caizin");

        assertFalse(projects.markTaskWithIdDone(100));
    }
}