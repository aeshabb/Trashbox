package org.itmo.server.command;

import org.itmo.dto.reply.AddReply;
import org.itmo.dto.reply.LoginReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.AddRequest;
import org.itmo.dto.request.LoginRequest;
import org.itmo.dto.request.Request;
import org.itmo.server.collection.Receiver;
import org.itmo.server.database.DatabaseReceiver;
import org.itmo.server.output.InfoPrinter;

public class LoginCommand extends Command{
    private final DatabaseReceiver databaseReceiver;

    public LoginCommand(Receiver receiver, String description, InfoPrinter printer, DatabaseReceiver databaseReceiver) {
        super(receiver, description, printer);
        this.databaseReceiver = databaseReceiver;
    }

    @Override
    public Reply process(Request request) {
        LoginRequest req = (LoginRequest) request;
        LoginReply rep = new LoginReply();
        if (databaseReceiver.loginUser(req.getUsername(), req.getPassword())) {
            rep.setSuccess(true);
            rep.setMessage("Пользователь вошел");
        } else {
            rep.setSuccess(false);
            rep.setMessage("Пользователь не вошел");
        }

        printer.printLine("[DEBUG] Запрос на добавление user в БД");

        return rep;
    }
}
