package org.itmo.client.command;

import org.itmo.client.entity.User;
import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.ClearReply;
import org.itmo.dto.request.ClearRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class ClearCommand extends Command {

    public ClearCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, User user) {
        super(socket, printer, inputStreamReader, user);

    }

    @Override
    public void execute(String[] args) {
        ClearRequest request = new ClearRequest("clear", user.getUsername(), user.getPassword());
        ClearReply clearReply = (ClearReply) Network.sendAndReceive(socket, request);
        if (clearReply != null && clearReply.isSuccess())
            printer.printLine("Коллекция очищена (элементы которые добавляли вы)");
        else
            printer.printLine("Не удалось очистить коллекцию");
    }
}
