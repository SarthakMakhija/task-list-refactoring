package com.codurance.training.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Arguments extends ArrayList<String> {

    static Arguments skipOneAndCreate(String[] parts) {
        if (parts == null) {
            return new Arguments(List.of());
        }
        return new Arguments(Arrays.stream(parts).skip(1).collect(Collectors.toList()));
    }

    Arguments(List<String> arguments) {
        this.addAll(arguments);
    }

    Arguments skipOne() {
        return new Arguments(this.subList(1, this.size()));
    }
}
