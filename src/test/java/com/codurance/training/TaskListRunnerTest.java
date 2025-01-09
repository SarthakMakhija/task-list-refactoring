package com.codurance.training;

import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class TaskListRunnerTest {

    @Test
    public void executeWithAdditionOfAProjectContainingOneTask() throws Exception {
        StringWriter writer = new StringWriter();
        TaskListRunner taskListRunner = new TaskListRunner(writer);
        taskListRunner.execute("add project caizin");
        taskListRunner.execute("add task caizin Task1");
        taskListRunner.execute("show");

        String expected = "caizin\n" + "[ ] 1: Task1" + "\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void executeWithAdditionOfAProjectContainingACoupleOfTasks() throws Exception {
        StringWriter writer = new StringWriter();
        TaskListRunner taskListRunner = new TaskListRunner(writer);
        taskListRunner.execute("add project caizin");
        taskListRunner.execute("add task caizin Task1");
        taskListRunner.execute("add task caizin Task2");
        taskListRunner.execute("show");

        String expected = "caizin\n" + "[ ] 1: Task1" + "\n" + "[ ] 2: Task2" + "\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void executeWithAdditionOfAProjectContainingACoupleOfTasksAndCheckOneOfThem() throws Exception {
        StringWriter writer = new StringWriter();
        TaskListRunner taskListRunner = new TaskListRunner(writer);
        taskListRunner.execute("add project caizin");
        taskListRunner.execute("add task caizin Task1");
        taskListRunner.execute("add task caizin Task2");
        taskListRunner.execute("check 1");
        taskListRunner.execute("show");

        String expected = "caizin\n" + "[x] 1: Task1" + "\n" + "[ ] 2: Task2" + "\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void executeWithAdditionOfAProjectContainingACoupleOfTasksAndUncheckOneOfThem() throws Exception {
        StringWriter writer = new StringWriter();
        TaskListRunner taskListRunner = new TaskListRunner(writer);
        taskListRunner.execute("add project caizin");
        taskListRunner.execute("add task caizin Task1");
        taskListRunner.execute("add task caizin Task2");
        taskListRunner.execute("check 1");
        taskListRunner.execute("uncheck 1");
        taskListRunner.execute("show");

        String expected = "caizin\n" + "[ ] 1: Task1" + "\n" + "[ ] 2: Task2" + "\n";
        assertEquals(expected, writer.toString());
    }
}
