package org.itmo.client.command;

import org.itmo.client.entity.User;
import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.RegisterReply;
import org.itmo.dto.request.RegisterRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class RegisterCommand extends Command {

    public RegisterCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, User user) {
        super(socket, printer, inputStreamReader, user);
    }

    public void execute(String[] args) {
        if (args.length != 2) {
            printer.printLine("Неверный набор аргументов");
        } else {
            RegisterRequest registerRequest = new RegisterRequest("register", args[0], args[1]);
            RegisterReply registerReply = (RegisterReply) Network.sendAndReceive(socket, registerRequest);
            if (registerReply != null && registerReply.isSuccess()) {
                user = new User(args[0], args[1]);
                printer.printLine(registerReply.getMessage());
            } else
                printer.printLine("Такой пользователь уже зарегестрирован");
        }
    }
}
