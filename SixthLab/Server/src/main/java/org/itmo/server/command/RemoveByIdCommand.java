package org.itmo.server.command;

import org.itmo.dto.reply.RemoveByIdReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.RemoveByIdRequest;
import org.itmo.dto.request.Request;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

public class RemoveByIdCommand extends Command {

    public RemoveByIdCommand(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public Reply process(Request request) {
        RemoveByIdRequest req = (RemoveByIdRequest) request;
        RemoveByIdReply rep = new RemoveByIdReply();

        if (receiver.removeById(req.getId())) {
            rep.setSuccess(true);
            rep.setMessage("Элемент успешно удалён");
        } else{
            rep.setSuccess(false);
            rep.setMessage("Не удалось удалить элемент. Проверьте введённый id");
        }

        printer.printLine("[DEBUG] Запрос на удаление элемента из коллекции");

        return rep;
    }


}
