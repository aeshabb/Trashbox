package org.itmo.client.command;

import lombok.Getter;
import lombok.Setter;
import org.itmo.client.entity.User;
import org.itmo.client.output.InfoPrinter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
@Setter
@Getter
public abstract class Command {
    protected Socket socket;
    protected InfoPrinter printer;
    protected InputStreamReader inputStreamReader;
    protected User user;

    Command(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, User user) {
        this.socket = socket;
        this.printer = printer;
        this.inputStreamReader = inputStreamReader;
        this.user = user;
    }

    abstract public void execute(String[] parameters);

}
