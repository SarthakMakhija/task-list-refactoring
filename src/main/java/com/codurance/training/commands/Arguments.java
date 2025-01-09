package com.codurance.training.commands;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Arguments {
    final List<String> arguments;

    static Arguments skipOneAndCreate(String[] parts) {
        if (parts == null) {
            return new Arguments(List.of());
        }
        return new Arguments(Arrays.stream(parts).skip(1).collect(Collectors.toList()));
    }

    Arguments(List<String> arguments) {
        this.arguments = arguments;
    }
}
