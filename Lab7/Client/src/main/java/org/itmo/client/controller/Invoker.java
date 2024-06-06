package org.itmo.client.controller;


import lombok.Getter;
import lombok.Setter;
import org.itmo.client.command.Command;
import org.itmo.client.command.HistoryCommand;

import java.util.Arrays;
import java.util.Map;
@Getter
public class Invoker {
    private final Map<String, Command> commands;
    private final HistoryCommand historyCommand;
    public Invoker(Map<String, Command> commands) {
        this.commands = commands;
        historyCommand = (HistoryCommand) commands.get("history");
    }

    public boolean executeCommand(String commandAndArgs) {
        commandAndArgs = commandAndArgs.trim();
        String[] parsed = commandAndArgs.split(" ");
        String[] args = Arrays.copyOfRange(parsed, 1, parsed.length);
        if (!commands.containsKey(parsed[0]))
            return false;

        Command command =  commands.get(parsed[0]);
        historyCommand.addCommand(parsed[0]);
        command.execute(args);
        return true;
    }
}
