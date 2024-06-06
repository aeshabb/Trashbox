package org.itmo.server.command;

import org.itmo.dto.reply.Reply;
import org.itmo.dto.reply.UpdateReply;
import org.itmo.dto.request.Request;
import org.itmo.dto.request.UpdateRequest;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

public class UpdateCommand extends Command {

    public UpdateCommand(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public Reply process(Request request) {
        UpdateRequest req = (UpdateRequest) request;
        UpdateReply rep = new UpdateReply();
        if (receiver.update(req.getId(), req.getRoute())) {
            rep.setSuccess(true);
            rep.setMessage("Элемент успешно обновлён");
        } else{
            rep.setSuccess(false);
            rep.setMessage("Не удалось обновить элемент. Проверьте введённый id");
        }

        printer.printLine("[DEBUG] Запрос на обновление элемента в коллекции");

        return rep;
    }

}

