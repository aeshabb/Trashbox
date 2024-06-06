package org.itmo.server.command;

import org.itmo.dto.reply.HelpReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.reply.ShowReply;
import org.itmo.dto.request.HelpRequest;
import org.itmo.dto.request.Request;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;

import java.util.List;


public class HelpCommand extends Command{
    private final List<String> commandList;


    public HelpCommand(Receiver receiver, String description, InfoPrinter printer, List<String> commandList) {
        super(receiver, description, printer);
        this.commandList = commandList;
    }

    public Reply process(Request request){
        HelpRequest req = (HelpRequest) request;
        HelpReply rep = new HelpReply();

        rep.setSuccess(true);
        rep.setResult(receiver.help(commandList));

        printer.printLine("[DEBUG] Запрос на показ справки");

        return rep;
    }

}
