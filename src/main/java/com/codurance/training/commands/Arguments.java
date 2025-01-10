package com.codurance.training.commands;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Arguments {

    private final List<String> arguments;

    static Arguments skipOneAndCreate(String[] parts) {
        if (parts == null) {
            return new Arguments(List.of());
        }
        return new Arguments(Arrays.stream(parts).skip(1).collect(Collectors.toList()));
    }

    Arguments(List<String> arguments) {
        this.arguments = arguments;
    }

    Arguments skipOne() {
        return new Arguments(this.arguments.subList(1, this.count()));
    }

    int argumentAtIndexAsInt(int index) {
        return Integer.parseInt(this.arguments.get(index));
    }

    String argumentAtIndexAsString(int index) {
        return this.arguments.get(index);
    }

    int count() {
        return this.arguments.size();
    }

    boolean isEmpty() {
        return this.arguments.isEmpty();
    }
}
