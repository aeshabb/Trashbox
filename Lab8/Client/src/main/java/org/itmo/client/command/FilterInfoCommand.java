package org.itmo.client.command;

import org.itmo.client.entity.User;
import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.ClearReply;
import org.itmo.dto.reply.FilterInfoReply;
import org.itmo.dto.request.ClearRequest;
import org.itmo.dto.request.FilterInfoRequest;
import org.itmo.dto.request.FilterRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class FilterInfoCommand extends Command {

    public FilterInfoCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, User user) {
        super(socket, printer, inputStreamReader, user);

    }

    @Override
    public void execute(String[] args) {
        FilterInfoRequest request = new FilterInfoRequest("filter_info", user.getUsername(), user.getPassword());
        FilterInfoReply reply = (FilterInfoReply) Network.sendAndReceive(socket, request);
        if (reply != null && reply.isSuccess())
            printer.printLine(reply.getResult());
        else
            printer.printLine("Не удалось получить информацию");
    }
}
