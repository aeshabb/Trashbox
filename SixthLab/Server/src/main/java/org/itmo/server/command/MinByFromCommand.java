package org.itmo.server.command;

import org.itmo.dto.reply.MinByFromReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.reply.ShowReply;
import org.itmo.dto.request.MinByFromRequest;
import org.itmo.dto.request.Request;

import org.itmo.dto.request.ShowRequest;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

public class MinByFromCommand extends Command {

    public MinByFromCommand(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public Reply process(Request request) {
        MinByFromRequest req = (MinByFromRequest) request;
        MinByFromReply rep = new MinByFromReply();

        rep.setSuccess(true);
        rep.setMessage(receiver.minByFrom().toString());

        printer.printLine("[DEBUG] Запрос на показ коллекции");

        return rep;
    }
}
