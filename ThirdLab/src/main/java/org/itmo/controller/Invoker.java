package org.itmo.controller;

import org.itmo.command.Command;

import java.util.Arrays;
import java.util.Map;

public class Invoker {
    private final Map<String, Command> commands;

    public Invoker(Map<String, Command> commands) {
        this.commands = commands;
    }

    public void executeCommand(String commandNameAndInfo) {
        String[] parsedLine = commandNameAndInfo.split(" ");
        String[] argsArray = Arrays.copyOfRange(parsedLine, 1, parsedLine.length);
        Command command = commands.get(parsedLine[0]);
        command.execute(argsArray);
    }
}
