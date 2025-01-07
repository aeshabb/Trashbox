package org.itmo.server.command;

import org.itmo.dto.reply.RemoveByIdReply;
import org.itmo.dto.reply.RemoveLowerReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.RemoveByIdRequest;
import org.itmo.dto.request.RemoveLowerRequest;
import org.itmo.dto.request.Request;
import org.itmo.server.collection.Receiver;
import org.itmo.server.database.DatabaseReceiver;
import org.itmo.server.output.InfoPrinter;

public class RemoveLowerCommand extends Command {

    DatabaseReceiver databaseReceiver;

    public RemoveLowerCommand(Receiver receiver, String description, InfoPrinter printer, DatabaseReceiver databaseReceiver) {
        super(receiver, description, printer);
        this.databaseReceiver = databaseReceiver;
    }

    @Override
    public Reply process(Request request) {
        RemoveLowerRequest req = (RemoveLowerRequest) request;
        RemoveLowerReply rep = new RemoveLowerReply();

        if (databaseReceiver.removeLower(req.getDistance(), req.getUsername(), req.getPassword())) {
            receiver.fillStorage(databaseReceiver.fillRouteStorage());
            rep.setSuccess(true);
            rep.setMessage("Элементы успешно удалены");
        } else{
            rep.setSuccess(false);
            rep.setMessage("Не удалось удалить элементы меньше данного. Проверьте введённую distance");
        }

        printer.printLine("[DEBUG] Запрос на удаление элементов с меньшим полем distance");

        return rep;
    }
}
