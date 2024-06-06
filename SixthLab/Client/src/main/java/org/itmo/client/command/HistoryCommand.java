package org.itmo.client.command;

import org.itmo.client.output.InfoPrinter;

import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Stack;

public class HistoryCommand extends Command {
    private final Stack<String> commandsHistory = new Stack<>();

    public HistoryCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader) {
        super(socket, printer, inputStreamReader);

    }

    @Override
    public void execute(String[] parameters) {
        if (commandsHistory.size() >= 6) {
            printer.printList(commandsHistory.subList(commandsHistory.size() - 6, commandsHistory.size()));
        } else {
            for (String command : commandsHistory) {
                printer.printLine(command);
            }
        }
    }

    public void addCommand(String name) {
        commandsHistory.push(name);
    }

}
