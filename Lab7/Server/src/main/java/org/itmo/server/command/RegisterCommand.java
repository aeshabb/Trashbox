package org.itmo.server.command;

import org.itmo.dto.reply.LoginReply;
import org.itmo.dto.reply.RegisterReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.LoginRequest;
import org.itmo.dto.request.RegisterRequest;
import org.itmo.dto.request.Request;
import org.itmo.server.collection.Receiver;
import org.itmo.server.database.DatabaseReceiver;
import org.itmo.server.output.InfoPrinter;

public class RegisterCommand extends Command{
    private final DatabaseReceiver databaseReceiver;

    public RegisterCommand(Receiver receiver, String description, InfoPrinter printer, DatabaseReceiver databaseReceiver) {
        super(receiver, description, printer);
        this.databaseReceiver = databaseReceiver;
    }

    @Override
    public Reply process(Request request) {
        RegisterRequest req = (RegisterRequest) request;
        RegisterReply rep = new RegisterReply();
        if (databaseReceiver.registerUser(req.getUsername(), req.getPassword())) {
            rep.setSuccess(true);
            rep.setMessage("Пользователь зарегестрирован");
        } else {
            rep.setSuccess(false);
            rep.setMessage("Пользователь уже есть в БД");
        }

        printer.printLine("[DEBUG] Запрос на добавление user в БД");

        return rep;
    }
}
