package org.itmo.command;

import org.itmo.output.CommandPrinter;

public class UpdateCommand extends Command {

    public UpdateCommand(Receiver receiver, String description, CommandPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 1) {
            printer.printLine("Неверное количество параметров");
        } else {
            RouteParser routeParser = new RouteParser(receiver, printer, parameters);
            receiver.updateRouteToTreeSet(routeParser.parseRouteFromConsole());
            printer.printLine("Route заменен в коллекции!");
        }
    }
}

