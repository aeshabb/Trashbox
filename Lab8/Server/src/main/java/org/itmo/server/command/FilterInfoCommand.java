package org.itmo.server.command;

import org.itmo.dto.reply.FilterInfoReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.reply.ShowReply;
import org.itmo.dto.request.FilterInfoRequest;
import org.itmo.dto.request.Request;
import org.itmo.dto.request.ShowRequest;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

public class FilterInfoCommand extends Command {

    public FilterInfoCommand(Receiver receiver, String description, InfoPrinter printer) {
        super(receiver, description, printer);

    }


    @Override
    public Reply process(Request request) {
        FilterInfoRequest req = (FilterInfoRequest) request;
        FilterInfoReply rep = new FilterInfoReply();

        rep.setSuccess(true);
        rep.setResult("""
                name + value (Routes у которых содержится value в name);
                distanceHigher + value (Routes у которых distance > value);
                distanceLower + value (Routes у которых distance < value);
                idHigher + value (Routes у которых distance > value);
                idLower + value (Routes у которых distance < value);
                coordinateXHigher + value (Routes у которых distance > value);
                coordinateXLower + value (Routes у которых distance < value);
                coordinateYHigher + value (Routes у которых distance > value);
                coordinateYLower + value (Routes у которых distance < value);
                """);

        printer.printLine("[DEBUG] Запрос на показ фильтров");

        return rep;
    }

}
