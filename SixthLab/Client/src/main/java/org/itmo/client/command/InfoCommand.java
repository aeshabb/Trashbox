package org.itmo.client.command;

import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.InfoReply;
import org.itmo.dto.request.InfoRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class InfoCommand extends Command {

    public InfoCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader) {
        super(socket, printer, inputStreamReader);


    }

    @Override
    public void execute(String[] parameters) {
        InfoRequest infoRequest = new InfoRequest();
        InfoReply infoReply = (InfoReply) Network.sendAndReceive(socket, infoRequest);
        if (infoReply != null && infoReply.isSuccess())
            printer.printLine(infoReply.getResult());
        else
            printer.printLine("Не удалось получить информацию о коллекции");
    }

}
