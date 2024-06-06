package org.itmo.client.command;

import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.ShowReply;
import org.itmo.dto.request.ShowRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class ShowCommand extends Command {

    public ShowCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader) {
        super(socket, printer, inputStreamReader);


    }

    @Override
    public void execute(String[] args) {
        ShowRequest showRequest = new ShowRequest();
        ShowReply showReply = (ShowReply) Network.sendAndReceive(socket, showRequest);
        if (showReply != null && showReply.isSuccess())
            printer.printLine(showReply.getResult());
        else
            printer.printLine("Не удалось получить коллекцию");
    }

}

