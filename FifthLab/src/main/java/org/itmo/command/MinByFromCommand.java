package org.itmo.command;

import org.itmo.entity.Route;
import org.itmo.output.CommandPrinter;

public class MinByFromCommand extends Command {

    public MinByFromCommand(Receiver receiver, String description, CommandPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 0) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            Route route = receiver.getMinByFrom();
            printer.printLine(route.toString());
        }
    }
}
