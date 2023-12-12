package org.itmo.command;

import org.itmo.output.Printer;

public class ShowEnrolleesWithFirstPriorityCommand extends Command{
    public ShowEnrolleesWithFirstPriorityCommand(Receiver receiver, String description, Printer printer) {
        super(receiver, description, printer);
        this.receiver = receiver;
        this.description = description;
        this.printer = printer;
    }

    @Override
    public void execute(String[] parameters) {
        String division = String.join(" ", parameters);
        printer.printList(receiver.getEnrolleesWithFirstPriority(division));
    }
}
