package org.itmo.command;

import org.itmo.output.CommandPrinter;

public class RemoveLowerCommand extends Command {

    public RemoveLowerCommand(Receiver receiver, String description, CommandPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 1) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            try {
                receiver.removeLowerDistance(Integer.parseInt(parameters[0]));
            } catch (NumberFormatException num) {
                printer.printLine("Неверный ввод!");
            }
        }
    }
}
