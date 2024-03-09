package org.itmo.command;

import org.itmo.output.Printer;

public class DeleteByIdCommand extends Command {
    public DeleteByIdCommand(Receiver receiver, String description, Printer printer) {
        super(receiver, description, printer);
    }


    @Override
    public void execute(String[] parameters) {
        Receiver receiver = getReceiver();
        receiver.deleteById(Integer.parseInt(parameters[0]));
    }

}
