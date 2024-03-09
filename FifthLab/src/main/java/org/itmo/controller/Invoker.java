package org.itmo.controller;

import org.itmo.command.Command;
import org.itmo.command.HistoryCommand;

import java.util.Arrays;
import java.util.Map;

/**
 * Пульт управления командами
 */
public class Invoker {
    /**
     * Хранение команд
     */
    private final Map<String, Command> commands;
    /**
     * История команд
     */
    private final HistoryCommand commandsHistory;

    /**
     *
     * @param commands
     */
    public Invoker(Map<String, Command> commands) {
        this.commands = commands;
        commandsHistory = (HistoryCommand) commands.get("history");
    }

    /**
     *
     * @param commandNameAndInfo
     * @return
     */
    public boolean executeCommand(String commandNameAndInfo) {
        if (commandNameAndInfo != null) {
            commandNameAndInfo = commandNameAndInfo.trim();
            String[] parsedLine = commandNameAndInfo.split(" ");
            String[] argsArray = Arrays.copyOfRange(parsedLine, 1, parsedLine.length);
            if (commands.get(parsedLine[0]) != null) {
                Command command = commands.get(parsedLine[0]);
                command.execute(argsArray);
                commandsHistory.addCommand(parsedLine[0]);
                return true;
            }
        }
        return false;
    }
}
