package org.itmo.server.command;

import org.itmo.dto.reply.Reply;
import org.itmo.dto.reply.ShowReply;
import org.itmo.dto.request.Request;
import org.itmo.dto.request.ShowRequest;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

public class ShowCommand extends Command {

    public ShowCommand(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);

    }


    @Override
    public Reply process(Request request) {
        ShowRequest req = (ShowRequest) request;
        ShowReply rep = new ShowReply();

        rep.setSuccess(true);
        rep.setResult(receiver.show());

        printer.printLine("[DEBUG] Запрос на показ коллекции");

        return rep;
    }
}

