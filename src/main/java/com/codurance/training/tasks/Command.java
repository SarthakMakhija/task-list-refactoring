package com.codurance.training.tasks;

import java.io.IOException;
import java.util.List;

public interface Command {
    void execute(List<String> arguments) throws IOException;
}
