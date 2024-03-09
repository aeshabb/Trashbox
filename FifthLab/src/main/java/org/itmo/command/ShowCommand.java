package org.itmo.command;

import org.itmo.output.CommandPrinter;

public class ShowCommand extends Command {

    public ShowCommand(Receiver receiver, String description, CommandPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public void execute(String[] parameters) {
        printer.printSet(receiver.getCollection());
    }

}

