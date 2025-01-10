package com.codurance.training.commands;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ArgumentsTest {

    @Test
    public void skipOneAndCreateArguments() {
        Arguments arguments = Arguments.skipOneAndCreate(new String[]{"an", "argument", "1"});
        assertEquals("argument", arguments.argumentAtIndexAsString(0));
        assertEquals("1", arguments.argumentAtIndexAsString(1));
    }

    @Test
    public void skipOneAndCreateEmptyArguments() {
        Arguments arguments = Arguments.skipOneAndCreate(new String[]{});
        assertTrue(arguments.isEmpty());
    }

    @Test
    public void skipOneAndCreateEmptyArgumentsGivenNull() {
        Arguments arguments = Arguments.skipOneAndCreate(null);
        assertTrue(arguments.isEmpty());
    }

    @Test
    public void skipOneFromArguments() {
        Arguments arguments = new Arguments(List.of("an", "argument", "1"));
        Arguments skipped = arguments.skipOne();
        assertEquals("argument", skipped.argumentAtIndexAsString(0));
        assertEquals("1", skipped.argumentAtIndexAsString(1));
    }

    @Test
    public void argumentAtIndex0AsInt() {
        Arguments arguments = new Arguments(List.of("1", "argument", "1"));
        assertEquals(1, arguments.argumentAtIndexAsInt(0));
    }

    @Test
    public void argumentAtIndex1AsInt() {
        Arguments arguments = new Arguments(List.of("0", "200", "1"));
        assertEquals(200, arguments.argumentAtIndexAsInt(1));
    }

    @Test
    public void argumentAtIndex0AsString() {
        Arguments arguments = new Arguments(List.of("1", "argument", "1"));
        assertEquals("1", arguments.argumentAtIndexAsString(0));
    }

    @Test
    public void argumentAtIndex1AsString() {
        Arguments arguments = new Arguments(List.of("0", "200", "1"));
        assertEquals("200", arguments.argumentAtIndexAsString(1));
    }

    @Test
    public void zeroArguments() {
        Arguments arguments = new Arguments(List.of());
        assertEquals(0, arguments.count());
    }

    @Test
    public void threeArguments() {
        Arguments arguments = new Arguments(List.of("0", "200", "1"));
        assertEquals(3, arguments.count());
    }

    @Test
    public void argumentsIsEmpty() {
        Arguments arguments = Arguments.skipOneAndCreate(null);
        assertTrue(arguments.isEmpty());
    }

    @Test
    public void argumentsIsNotEmpty() {
        Arguments arguments = new Arguments(List.of("argument"));
        assertFalse(arguments.isEmpty());
    }
}