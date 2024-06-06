package org.itmo.server.command;

import org.itmo.dto.reply.Reply;
import org.itmo.dto.reply.UpdateReply;
import org.itmo.dto.request.Request;
import org.itmo.dto.request.UpdateRequest;
import org.itmo.server.collection.Receiver;
import org.itmo.server.database.DatabaseReceiver;
import org.itmo.server.output.InfoPrinter;

public class UpdateCommand extends Command {

    DatabaseReceiver databaseReceiver;

    public UpdateCommand(Receiver receiver, String description, InfoPrinter printer, DatabaseReceiver databaseReceiver) {
        super(receiver, description, printer);
        this.databaseReceiver = databaseReceiver;
    }

    @Override
    public Reply process(Request request) {
        UpdateRequest req = (UpdateRequest) request;
        UpdateReply rep = new UpdateReply();
        if (databaseReceiver.update(req.getId(), req.getRoute(), req.getUsername(), req.getPassword()) != -1) {
            if (receiver.update(req.getId(), req.getRoute())) {
                rep.setSuccess(true);
                rep.setMessage("Элемент успешно обновлён");
            }
        } else{
            rep.setSuccess(false);
            rep.setMessage("Не удалось обновить элемент. По данному id нет вашего route");
        }

        printer.printLine("[DEBUG] Запрос на обновление элемента в коллекции");

        return rep;
    }

}

