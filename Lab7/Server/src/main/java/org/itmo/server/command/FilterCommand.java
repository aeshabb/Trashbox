package org.itmo.server.command;

import org.itmo.dto.reply.FilterReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.reply.ShowReply;
import org.itmo.dto.request.FilterRequest;
import org.itmo.dto.request.Request;
import org.itmo.dto.request.ShowRequest;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

public class FilterCommand extends Command {

    public FilterCommand(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);

    }


    @Override
    public Reply process(Request request) {
        FilterRequest req = (FilterRequest) request;
        FilterReply rep = new FilterReply();

        rep.setSuccess(true);
        rep.setResult(receiver.getFilteredRoutes(req.getUserFilters()));

        printer.printLine("[DEBUG] Запрос на показ коллекции с фильтрами");

        return rep;
    }
}
