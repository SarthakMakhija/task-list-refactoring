package com.codurance.training.tasks;

import java.io.IOException;
import java.util.List;

public interface Command {
    public void execute(List<String> arguments) throws IOException;
}
