package org.itmo.client.command;

import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.RemoveByIdReply;
import org.itmo.dto.request.RemoveByIdRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class RemoveByIdCommand extends Command {

    public RemoveByIdCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader) {
        super(socket, printer, inputStreamReader);


    }

    @Override
    public void execute(String[] parameters) {
        int id;
        try {
            id = Integer.parseInt(parameters[0]);
        } catch (Exception e) {
            printer.printLine("Неверный формат команды. Используйте remove_by_id + (число)");
            return;
        }

        RemoveByIdRequest request = new RemoveByIdRequest(id);
        RemoveByIdReply reply = (RemoveByIdReply) Network.sendAndReceive(socket, request);
        if (reply != null && reply.isSuccess())
            printer.printLine("Элемент успешно удалён");
        else
            printer.printLine("Не удалось удалить элемент из коллекции");
    }

}
