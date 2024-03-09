package org.itmo.command;

import org.itmo.newStructure.MyStack;
import org.itmo.output.CommandPrinter;

public class HistoryCommand extends Command {
    private final MyStack<String> commandsHistory = new MyStack<>();

    public HistoryCommand(Receiver receiver, String description, CommandPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public void execute(String[] parameters) {
        if (commandsHistory.size() >= 6) {
            printer.printList(commandsHistory.subList(commandsHistory.size() - 6, commandsHistory.size()));
        } else {
            printer.printStack(commandsHistory);
        }
    }

    public void addCommand(String name) {
        commandsHistory.push(name);
    }
}
