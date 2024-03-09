package org.itmo.command;

import org.itmo.output.Printer;

public abstract class Command {
    protected Receiver receiver;
    protected String description;
    protected Printer printer;

    Command(Receiver receiver, String description, Printer printer) {
        this.receiver = receiver;
        this.description = description;
        this.printer = printer;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    abstract public void execute(String[] parameters);

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
