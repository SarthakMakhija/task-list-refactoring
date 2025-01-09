package com.codurance.training.commands;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArgumentsTest {

    @Test
    public void skipOneAndCreateArguments() {
        Arguments arguments = Arguments.skipOneAndCreate(new String[]{"an", "argument", "1"});
        assertEquals(List.of("argument", "1"), arguments);
    }

    @Test
    public void skipOneAndCreateEmptyArguments() {
        Arguments arguments = Arguments.skipOneAndCreate(new String[]{});
        assertEquals(List.of(), arguments);
    }

    @Test
    public void skipOneAndCreateEmptyArgumentsGivenNull() {
        Arguments arguments = Arguments.skipOneAndCreate(null);
        assertEquals(List.of(), arguments);
    }

    @Test
    public void skipOneFromArguments() {
        Arguments arguments = new Arguments(List.of("an", "argument", "1"));
        assertEquals(List.of("argument", "1"), arguments.skipOne());
    }
}