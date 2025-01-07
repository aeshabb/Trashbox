package org.itmo.client.command;

import org.itmo.client.entity.User;
import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.RemoveByIdReply;
import org.itmo.dto.reply.RemoveLowerReply;
import org.itmo.dto.request.RemoveByIdRequest;
import org.itmo.dto.request.RemoveLowerRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class RemoveLowerCommand extends Command {

    public RemoveLowerCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, User user) {
        super(socket, printer, inputStreamReader, user);


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

        RemoveLowerRequest request = new RemoveLowerRequest(distance, "remove_lower", user.getUsername(), user.getPassword());
        RemoveLowerReply reply = (RemoveLowerReply) Network.sendAndReceive(socket, request);
        if (reply != null && reply.isSuccess())
            printer.printLine(reply.getMessage());
        else if (reply != null) {
            printer.printLine(reply.getMessage());
        } else {
            printer.printLine("Не удалось удалить элементы из коллекции");
        }
    }
}
