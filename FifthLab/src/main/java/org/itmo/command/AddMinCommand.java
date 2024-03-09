package org.itmo.command;

import org.itmo.output.CommandPrinter;

public class AddMinCommand extends Command {

    public AddMinCommand(Receiver receiver, String description, CommandPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 1) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            if (receiver.checkIfMinDistance(Integer.parseInt(parameters[0]))) {
                RouteParser routeParser = new RouteParser(receiver, printer, parameters);
                receiver.addRouteToTreeSet(routeParser.parseRouteFromConsole());
                printer.printLine("Route добавлен в коллекцию!");
            } else {
                printer.printLine("Distance не минимальный!");
            }
        }

    }
}
