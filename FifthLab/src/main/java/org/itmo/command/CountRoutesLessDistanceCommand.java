package org.itmo.command;

import org.itmo.output.CommandPrinter;

public class CountRoutesLessDistanceCommand extends Command {

    public CountRoutesLessDistanceCommand(Receiver receiver, String description, CommandPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 1) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            printer.printLine("Количество Route с меньшим полем distance: " + receiver.countRoutesLessDistance(Integer.parseInt(parameters[0])));
        }

    }
}