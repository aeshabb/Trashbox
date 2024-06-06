package org.itmo.server.command;

import org.itmo.dto.reply.AddReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.AddRequest;
import org.itmo.dto.request.Request;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

public class AddCommand extends Command {

    public AddCommand(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public Reply process(Request request) {
        AddRequest req = (AddRequest) request;
        AddReply rep = new AddReply();
        receiver.add(req.getRoute());
        rep.setSuccess(true);
        rep.setMessage("Элемент успешно добавлен в коллекцию");

        printer.printLine("[DEBUG] Запрос на добавление элемента в коллекцию");

        return rep;
    }

}

