package org.itmo.client.command;

import org.itmo.client.entity.User;
import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.LoginReply;
import org.itmo.dto.request.LoginRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class LoginCommand extends Command {

    public LoginCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, User user) {
        super(socket, printer, inputStreamReader, user);
    }

    public void execute(String[] args) {
        if (args.length != 2) {
            printer.printLine("Неверный набор аргументов");
        } else {
            LoginRequest loginRequest = new LoginRequest("login", args[0], args[1]);
            LoginReply loginReply = (LoginReply) Network.sendAndReceive(socket, loginRequest);
            if (loginReply != null && loginReply.isSuccess()) {
                user = new User(args[0], args[1]);
                printer.printLine(loginReply.getMessage());
            } else
                printer.printLine("Нет такого пользователя");
        }
    }
}