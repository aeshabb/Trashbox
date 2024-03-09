package org.itmo.command;

import org.itmo.output.CommandPrinter;

import java.util.List;

public class HelpCommand extends Command {
    private final List<String> descriptionCommands;

    public HelpCommand(Receiver receiver, String description, CommandPrinter printer, List<String> descriptionCommands) {
        super(receiver, description, printer);
        this.receiver = receiver;
        this.description = description;
        this.printer = printer;
        descriptionCommands.add(description);
        descriptionCommands.add("Завершить работу: \"exit\"");
        this.descriptionCommands = descriptionCommands;
    }

    @Override
    public void execute(String[] parameters) {
        printer.printList(descriptionCommands);
    }

}
