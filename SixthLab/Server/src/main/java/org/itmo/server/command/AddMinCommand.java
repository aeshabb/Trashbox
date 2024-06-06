package org.itmo.server.command;

import org.itmo.dto.reply.AddMinReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.AddMinRequest;
import org.itmo.dto.request.Request;
import org.itmo.entity.Route;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

public class AddMinCommand extends Command {

    public AddMinCommand(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public Reply process(Request request) {
        AddMinRequest req = (AddMinRequest) request;
        AddMinReply rep = new AddMinReply();
        if (receiver.addIfMin(req.getRoute())) {
            rep.setMessage("Элемент упешно добавлен в коллекцию");
        } else{
            rep.setMessage("Элемент не является минимальным. Не добавлен в коллекцию");
        }
        rep.setSuccess(true);

        System.out.println("[DEBUG] Запрос на добавление максимального элемента в коллекцию");

        return rep;
    }

}
