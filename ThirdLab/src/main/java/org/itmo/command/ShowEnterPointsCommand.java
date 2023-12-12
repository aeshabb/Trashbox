package org.itmo.command;

import org.itmo.output.Printer;

public class ShowEnterPointsCommand extends Command {

    public ShowEnterPointsCommand(Receiver receiver, String description, Printer printer) {
        super(receiver, description, printer);
    }

    @Override
    public void execute(String[] parameters) {
        String direction = String.join(" ", parameters);
        int points = receiver.getEnterPoints(direction);
        if (points == 0) {
            printer.printLine("Невозможно определить");
        } else {
            printer.printLine(Integer.toString(points));
        }
    }
}
