package org.itmo.command;

import org.itmo.output.Printer;

public class ChangeDirNameCommand extends Command {

    public ChangeDirNameCommand(Receiver receiver, String description, Printer printer) {
        super(receiver, description, printer);
    }

    @Override
    public void execute(String[] parameters) {
        String stringParameters = String.join(" ", parameters);
        String[] dirNames = stringParameters.split(" > ");
        String oldName = dirNames[0];
        String newName = dirNames[1];
        receiver.changeDirName(oldName, newName);
        printer.printLine("Название успешно изменено.");
    }

}
