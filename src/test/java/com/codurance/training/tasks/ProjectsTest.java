package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectsTest {

    @Test
    public void formatProjectsWithASingleProject() {
        Projects projects = new Projects();
        projects.addProject("caizin");

        Tasks tasks = projects.get("caizin");
        tasks.add(new Task(1, "Task 1", true));

        String expected = "caizin\n" + "[x] 1: Task 1\n";
        assertEquals(expected, projects.format());
    }

    @Test
    public void formatProjectsWithACoupleOfProjects() {
        Projects projects = new Projects();
        projects.addProject("caizin");
        projects.addProject("database");

        projects.get("caizin").add(new Task(1, "Task 1", true));
        projects.get("database").add(new Task(2, "Task 2", true));

        String expected = "caizin\n" + "[x] 1: Task 1\n" + "database\n" + "[x] 2: Task 2\n";
        assertEquals(expected, projects.format());
    }
}