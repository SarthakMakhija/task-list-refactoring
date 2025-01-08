package com.codurance.training.tasks;

import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class TaskListTest {

    @Test
    public void executeWithAdditionOfAProjectContainingOneTask() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("show");

        String expected = "caizin\n" + "[ ] 1: Task1" + "\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void executeWithAdditionOfAProjectContainingACoupleOfTasks() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("add task caizin Task2");
        taskList.execute("show");

        String expected = "caizin\n" + "[ ] 1: Task1" + "\n" + "[ ] 2: Task2" + "\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void executeWithAdditionOfAProjectContainingACoupleOfTasksAndCheckOneOfThem() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("add task caizin Task2");
        taskList.execute("check 1");
        taskList.execute("show");

        String expected = "caizin\n" + "[x] 1: Task1" + "\n" + "[ ] 2: Task2" + "\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void executeWithAdditionOfAProjectContainingACoupleOfTasksAndUncheckOneOfThem() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("add task caizin Task2");
        taskList.execute("check 1");
        taskList.execute("uncheck 1");
        taskList.execute("show");

        String expected = "caizin\n" + "[ ] 1: Task1" + "\n" + "[ ] 2: Task2" + "\n";
        assertEquals(expected, writer.toString());
    }
}
