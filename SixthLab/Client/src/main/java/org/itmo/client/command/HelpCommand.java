package org.itmo.client.command;

import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.HelpReply;
import org.itmo.dto.request.HelpRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class HelpCommand extends Command {

    public HelpCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader) {
        super(socket, printer, inputStreamReader);

    }

    @Override
    public void execute(String[] parameters) {
        HelpRequest request = new HelpRequest();
        HelpReply helpReply = (HelpReply) Network.sendAndReceive(socket, request);
        if (helpReply != null && helpReply.isSuccess())
            printer.printLine(helpReply.getResult());
        else
            printer.printLine("Не удалось получить справочную информацию");

    }
    }


