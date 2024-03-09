package org.itmo.command;

import org.itmo.output.CommandPrinter;

public class ClearCommand extends Command {

    public ClearCommand(Receiver receiver, String description, CommandPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public void execute(String[] parameters) {
        receiver.clearRouteTreeSet();
        printer.printLine("Все элементы коллекции удалены.");
    }
}
