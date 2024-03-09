package org.itmo.command;

import org.itmo.output.CommandPrinter;

public class RemoveByIdCommand extends Command {

    public RemoveByIdCommand(Receiver receiver, String description, CommandPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public void execute(String[] parameters) {
        try {
            receiver.deleteRouteById(Integer.parseInt(parameters[0]));
            printer.printLine("Route удален.");
        } catch (NumberFormatException num) {
            printer.printLine("Число не int!");
        } catch (NullPointerException nullPointerException) {
            printer.printLine("Такого индекса нет!");
        }
    }
}
