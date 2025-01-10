package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectsTest {

    @Test
    public void addProject() {
        Projects projects = new Projects();
        projects.addProject("caizin");

        String expected = "caizin\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void addTaskToAnExistingProject() {
        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", Task.newTask(1, "Task 1"));
        projects.markTaskWithIdDone(1);

        String expected = "caizin\n" + "[x] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void attemptToAddTaskToANonExistingProject() {
        Projects projects = new Projects();
        assertThrows(IllegalArgumentException.class, () -> projects.addTaskToProjectWithName("caizin", Task.newTask(1, "Task 1")));
    }

    @Test
    public void formatProjectsWithASingleProject() {
        Projects projects = new Projects();

        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", Task.newTask(1, "Task 1"));
        projects.markTaskWithIdDone(1);

        String expected = "caizin\n" + "[x] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void formatProjectsWithACoupleOfProjects() {
        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addProject("database");

        projects.addTaskToProjectWithName("caizin", Task.newTask(1, "Task 1"));
        projects.addTaskToProjectWithName("database", Task.newTask(2, "Task 2"));
        projects.markTaskWithIdDone(1);
        projects.markTaskWithIdDone(2);

        String expected = "caizin\n" + "[x] 1: Task 1\n" + "database\n" + "[x] 2: Task 2\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void markTaskAsNotDone() {
        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", Task.newTask(1, "Task 1"));

        projects.markTaskWithIdNotDone(1);

        String expected = "caizin\n" + "[ ] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void markTaskAsDone() {
        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addTaskToProjectWithName("caizin", Task.newTask(1, "Task 1"));

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