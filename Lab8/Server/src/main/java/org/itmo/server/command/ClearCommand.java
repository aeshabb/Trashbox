package org.itmo.server.command;

import org.itmo.dto.reply.ClearReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.ClearRequest;
import org.itmo.dto.request.Request;
import org.itmo.server.collection.Receiver;
import org.itmo.server.database.DatabaseReceiver;
import org.itmo.server.output.InfoPrinter;

public class ClearCommand extends Command {

    DatabaseReceiver databaseReceiver;

    public ClearCommand(Receiver receiver, String description, InfoPrinter printer, DatabaseReceiver databaseReceiver) {
        super(receiver, description, printer);
        this.databaseReceiver = databaseReceiver;
    }

    @Override
    public Reply process(Request request){
        ClearRequest req = (ClearRequest) request;
        ClearReply rep = new ClearReply();

        databaseReceiver.clear(req.getUsername(), req.getPassword());
        receiver.fillStorage(databaseReceiver.fillRouteStorage());
        rep.setSuccess(true);

        System.out.println("[DEBUG] Запрос на очистку коллекции");

        return rep;
    }

}
