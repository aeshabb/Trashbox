package org.itmo.command;

import org.itmo.output.Printer;

public class ShowEnrolleesOnDirectionCommand extends Command{

    public ShowEnrolleesOnDirectionCommand(Receiver receiver, String description, Printer printer) {
        super(receiver, description, printer);
    }

    @Override
    public void execute(String[] parameters) {
        String direction = String.join(" ", parameters);
        printer.printList(receiver.getEnrolleeListOnDirection(direction));
    }
}
