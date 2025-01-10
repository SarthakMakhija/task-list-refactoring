package com.codurance.training.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class `Arguments` is showing signs of both mutability and immutability.
 * Signs of mutability:
 *  - Arguments extends from ArrayList<String> which is mutable.
 *  - The method `skipOne` creates a new instance of Arguments, which means the author does not want to change the existing collection.
 *  An instance of Arguments is passed to all the Commands. Given, Arguments extends from ArrayList<String>, it gives all the commands
 *  the authority to mutate arguments.
 *  Technically, Arguments should never be mutated once created.
 */
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

    int argumentAtIndexAsInt(int index) {
        return Integer.parseInt(this.get(index));
    }

    String argumentAtIndexAsString(int index) {
        return get(index);
    }

    int count() {
        return size();
    }

    boolean hasAny() {
        return size() == 0;
    }
}
