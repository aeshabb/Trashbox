package org.itmo.client.command;

import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.RemoveByIdReply;
import org.itmo.dto.reply.RemoveLowerReply;
import org.itmo.dto.request.RemoveByIdRequest;
import org.itmo.dto.request.RemoveLowerRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class RemoveLowerCommand extends Command {

    public RemoveLowerCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader) {
        super(socket, printer, inputStreamReader);


    }

    @Override
    public void execute(String[] parameters) {
        int distance;
        try {
            distance = Integer.parseInt(parameters[0]);
        } catch (Exception e) {
            printer.printLine("Неверный формат команды. Используйте remove_lower + (число)");
            return;
        }

        RemoveLowerRequest request = new RemoveLowerRequest(distance);
        RemoveLowerReply reply = (RemoveLowerReply) Network.sendAndReceive(socket, request);
        if (reply != null && reply.isSuccess())
            printer.printLine(reply.getMessage());
        else
            printer.printLine("Не удалось удалить элементы из коллекции");
    }
}
