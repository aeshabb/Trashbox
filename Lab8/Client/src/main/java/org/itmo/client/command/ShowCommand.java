package org.itmo.client.command;

import org.itmo.client.entity.User;
import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.ShowReply;
import org.itmo.dto.request.ShowRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class ShowCommand extends Command {

    public ShowCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, User user) {
        super(socket, printer, inputStreamReader, user);


    }

    @Override
    public void execute(String[] args) {
        ShowRequest showRequest = new ShowRequest("show", user.getUsername(), user.getPassword());
        ShowReply showReply = (ShowReply) Network.sendAndReceive(socket, showRequest);
        if (showReply != null && showReply.isSuccess())
            printer.printLine(showReply.getResult());
        else
            printer.printLine("Не удалось получить коллекцию");
    }

}

