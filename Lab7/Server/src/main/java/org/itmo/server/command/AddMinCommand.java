package org.itmo.server.command;

import org.itmo.dto.reply.AddMinReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.AddMinRequest;
import org.itmo.dto.request.Request;
import org.itmo.entity.Route;
import org.itmo.server.collection.Receiver;
import org.itmo.server.database.DatabaseReceiver;
import org.itmo.server.output.InfoPrinter;

public class AddMinCommand extends Command {

    DatabaseReceiver databaseReceiver;

    public AddMinCommand(Receiver receiver, String description, InfoPrinter printer, DatabaseReceiver databaseReceiver) {
        super(receiver, description, printer);
        this.databaseReceiver = databaseReceiver;
    }

    @Override
    public Reply process(Request request) {
        AddMinRequest req = (AddMinRequest) request;
        AddMinReply rep = new AddMinReply();
        if (databaseReceiver.addIfMin(req.getRoute(), req.getUsername(), req.getPassword()) != -1) {
            receiver.add(req.getRoute());
            rep.setMessage("Элемент упешно добавлен в коллекцию");

        } else {
            rep.setMessage("Элемент не является минимальным. Не добавлен в коллекцию");
        }
        rep.setSuccess(true);

        System.out.println("[DEBUG] Запрос на добавление максимального элемента в коллекцию");

        return rep;
    }

}
