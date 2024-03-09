package org.itmo.command;

import org.itmo.output.Printer;

public class ShowEnterPointsIfOriginalsCommand extends Command{
    public ShowEnterPointsIfOriginalsCommand(Receiver receiver, String description, Printer printer) {
        super(receiver, description, printer);
    }

    @Override
    public void execute(String[] parameters) {
        String direction = String.join(" ", parameters);
        int points = receiver.getEnterPointsIfOriginals(direction);
        if (points == 0) {
            printer.printLine("Невозможно определить");
        } else {
            printer.printLine(Integer.toString(points));
        }
    }
}
