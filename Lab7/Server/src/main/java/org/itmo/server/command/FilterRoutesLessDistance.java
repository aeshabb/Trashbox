package org.itmo.server.command;

import org.itmo.dto.reply.FilterRoutesLessDistanceReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.reply.ShowReply;
import org.itmo.dto.request.FilterRoutesLessDistanceRequest;
import org.itmo.dto.request.Request;
import org.itmo.dto.request.ShowRequest;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

import java.util.List;

public class FilterRoutesLessDistance extends Command {

    public FilterRoutesLessDistance(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public Reply process(Request request) {
        FilterRoutesLessDistanceRequest req = (FilterRoutesLessDistanceRequest) request;
        FilterRoutesLessDistanceReply rep = new FilterRoutesLessDistanceReply();

        if (!receiver.filterLessThanDistance(req.getDistance()).isEmpty()) {
            rep.setSuccess(true);
            rep.setResult(receiver.filterLessThanDistance(req.getDistance()));
        } else {
            rep.setSuccess(false);
        }

        printer.printLine("[DEBUG] Запрос на показ элементов с меньшим полем distance");

        return rep;
    }
}
