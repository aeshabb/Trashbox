package org.itmo.command;

import org.itmo.output.CommandPrinter;

public abstract class Command {
    protected Receiver receiver;
    protected String description;
    protected CommandPrinter printer;

    Command(Receiver receiver, String description, CommandPrinter printer) {
        this.receiver = receiver;
        this.description = description;
        this.printer = printer;
    }

    abstract public void execute(String[] parameters);

    public String getDescription() {
        return description;
    }
}
