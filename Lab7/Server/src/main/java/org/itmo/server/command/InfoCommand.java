package org.itmo.server.command;

import org.itmo.dto.reply.InfoReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.InfoRequest;
import org.itmo.dto.request.Request;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

public class InfoCommand extends Command {
    public InfoCommand(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);
    }

    public Reply process(Request request){
        InfoRequest req = (InfoRequest) request;
        InfoReply rep = new InfoReply();

        rep.setSuccess(true);
        rep.setResult(receiver.info());

        System.out.println("[DEBUG] Запрос на показ информации о коллекции");

        return rep;
    }

}
