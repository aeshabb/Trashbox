package org.itmo.server.command;

import org.itmo.dto.reply.ClearReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.ClearRequest;
import org.itmo.dto.request.Request;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

public class ClearCommand extends Command {

    public ClearCommand(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public Reply process(Request request){
        ClearRequest req = (ClearRequest) request;
        ClearReply rep = new ClearReply();

        receiver.clear();
        rep.setSuccess(true);

        System.out.println("[DEBUG] Запрос на очистку коллекции");

        return rep;
    }

}
