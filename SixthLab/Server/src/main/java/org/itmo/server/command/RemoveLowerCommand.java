package org.itmo.server.command;

import org.itmo.dto.reply.RemoveByIdReply;
import org.itmo.dto.reply.RemoveLowerReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.RemoveByIdRequest;
import org.itmo.dto.request.RemoveLowerRequest;
import org.itmo.dto.request.Request;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

public class RemoveLowerCommand extends Command {

    public RemoveLowerCommand(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public Reply process(Request request) {
        RemoveLowerRequest req = (RemoveLowerRequest) request;
        RemoveLowerReply rep = new RemoveLowerReply();

        if (receiver.removeLower(req.getDistance())) {
            rep.setSuccess(true);
            rep.setMessage("Элемент успешно удалён");
        } else{
            rep.setSuccess(false);
            rep.setMessage("Не удалось удалить элемент. Проверьте введённую distance");
        }

        printer.printLine("[DEBUG] Запрос на удаление элементов с меньшим полем distance");

        return rep;
    }
}
