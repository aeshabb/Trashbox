package org.itmo.server.command;

import org.itmo.dto.reply.AddReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.AddRequest;
import org.itmo.dto.request.Request;
import org.itmo.entity.Route;
import org.itmo.server.collection.Receiver;
import org.itmo.server.database.DatabaseReceiver;
import org.itmo.server.output.InfoPrinter;

public class AddCommand extends Command {
    private final DatabaseReceiver databaseReceiver;

    public AddCommand(Receiver receiver, String description, InfoPrinter printer, DatabaseReceiver databaseReceiver) {
        super(receiver, description, printer);
        this.databaseReceiver = databaseReceiver;
    }

    @Override
    public Reply process(Request request) {
        AddRequest req = (AddRequest) request;
        AddReply rep = new AddReply();
        int id;
        if ((id = databaseReceiver.addRouteToDB(req.getRoute(), req.getUsername(), req.getPassword())) != -1) {
            Route route = req.getRoute();
            route.setId(id);
            receiver.add(route);
            rep.setSuccess(true);
            rep.setMessage("Элемент успешно добавлен в коллекцию");
        } else {
            rep.setSuccess(false);
            rep.setMessage("Элементы в коллекции должны быть уникальны по полю distance!");
        }

        printer.printLine("[DEBUG] Запрос на добавление элемента в коллекцию");

        return rep;
    }

}

