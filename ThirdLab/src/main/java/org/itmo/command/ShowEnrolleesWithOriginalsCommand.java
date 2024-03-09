package org.itmo.command;

import org.itmo.output.Printer;

public class ShowEnrolleesWithOriginalsCommand extends Command {
    public ShowEnrolleesWithOriginalsCommand(Receiver receiver, String description, Printer printer) {
        super(receiver, description, printer);
        this.receiver = receiver;
        this.description = description;
        this.printer = printer;
    }

    @Override
    public void execute(String[] parameters) {
        String division = String.join(" ", parameters);
        printer.printList(receiver.getEnrolleesWithOriginals(division));
    }

}
