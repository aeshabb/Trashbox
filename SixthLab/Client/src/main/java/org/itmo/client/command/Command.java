package org.itmo.client.command;

import lombok.Setter;
import org.itmo.client.output.InfoPrinter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
@Setter
public abstract class Command {
    protected Socket socket;
    protected InfoPrinter printer;
    protected InputStreamReader inputStreamReader;

    Command(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader) {
        this.socket = socket;
        this.printer = printer;
        this.inputStreamReader = inputStreamReader;
    }

    abstract public void execute(String[] parameters);

}
