package org.itmo.client.command;

import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.AddReply;
import org.itmo.dto.request.AddRequest;
import org.itmo.entity.Route;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class AddCommand extends Command {
    private BufferedReader br;

    public AddCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, BufferedReader br) {
        super(socket, printer, inputStreamReader);
        this.br = br;
    }

    public void execute(String[] args) {
        RouteParser routeParser = new RouteParser(printer, br);
        Route route = routeParser.parseRouteFromConsole(inputStreamReader);
        AddRequest addRequest = new AddRequest(route);
        AddReply addReply = (AddReply) Network.sendAndReceive(socket, addRequest);
        if (addReply != null && addReply.isSuccess())
            printer.printLine(addReply.getMessage());
        else
            printer.printLine("Не удалось добавить элемент в коллекцию");
    }
}

