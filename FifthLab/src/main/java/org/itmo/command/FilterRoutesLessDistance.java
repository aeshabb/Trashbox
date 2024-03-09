package org.itmo.command;

import org.itmo.entity.Route;
import org.itmo.output.CommandPrinter;

import java.util.List;

public class FilterRoutesLessDistance extends Command {

    public FilterRoutesLessDistance(Receiver receiver, String description, CommandPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 1) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            try {
                List<Route> list = receiver.getRoutesLessDistance(Integer.parseInt(parameters[0]));
                printer.printLine("Routes с меньшим полем distance: " + list);
            } catch (NumberFormatException e) {
                printer.printLine("Неверный ввод");
            }
        }

    }
}
