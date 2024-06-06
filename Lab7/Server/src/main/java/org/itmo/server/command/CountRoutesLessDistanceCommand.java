package org.itmo.server.command;

import org.itmo.dto.reply.CountRoutesLessDistanceReply;
import org.itmo.dto.reply.FilterRoutesLessDistanceReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.CountRoutesLessDistanceRequest;
import org.itmo.dto.request.FilterRoutesLessDistanceRequest;
import org.itmo.dto.request.Request;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

public class CountRoutesLessDistanceCommand extends Command {

    public CountRoutesLessDistanceCommand(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public Reply process(Request request) {
        CountRoutesLessDistanceRequest req = (CountRoutesLessDistanceRequest) request;
        CountRoutesLessDistanceReply rep = new CountRoutesLessDistanceReply();

        if (!(receiver.countLessThanDistance(req.getDistance()) == 0)) {
            rep.setSuccess(true);
            rep.setResult(String.valueOf(receiver.countLessThanDistance(req.getDistance())));
        } else {
            rep.setSuccess(false);
        }

        printer.printLine("[DEBUG] Запрос на количество элементов с меньшим полем distance");

        return rep;
    }
}
