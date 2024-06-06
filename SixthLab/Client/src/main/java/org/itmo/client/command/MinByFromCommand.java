package org.itmo.client.command;

import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.ClearReply;
import org.itmo.dto.reply.MinByFromReply;
import org.itmo.dto.request.ClearRequest;
import org.itmo.dto.request.MinByFromRequest;
import org.itmo.entity.Route;

import java.io.InputStreamReader;
import java.net.Socket;

public class MinByFromCommand extends Command {

    public MinByFromCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader) {
        super(socket, printer, inputStreamReader);


    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 0) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            MinByFromRequest request = new MinByFromRequest();
            MinByFromReply minByFromReply = (MinByFromReply) Network.sendAndReceive(socket, request);
            if (minByFromReply != null && minByFromReply.isSuccess())
                printer.printLine(minByFromReply.getMessage());
            else
                printer.printLine("Не удалось получить элемент");
        }
    }
}
