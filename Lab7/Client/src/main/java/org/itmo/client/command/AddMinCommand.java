package org.itmo.client.command;

import org.itmo.client.entity.User;
import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.AddMinReply;
import org.itmo.dto.request.AddMinRequest;
import org.itmo.entity.Route;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AddMinCommand extends Command {

    private BufferedReader br;

    public AddMinCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, BufferedReader br, User user) {
        super(socket, printer, inputStreamReader, user);
        this.br = br;
    }

    @Override
    public void execute(String[] args) {
        Route route;
        RouteParser routeParser = new RouteParser(printer, br);
        route = routeParser.parseRouteFromConsole(inputStreamReader);
        AddMinRequest addMinRequest = new AddMinRequest(route, user.getUsername(), user.getPassword());
        AddMinReply addIfMinReply = (AddMinReply) Network.sendAndReceive(socket, addMinRequest);
        if (addIfMinReply != null && addIfMinReply.isSuccess())
            printer.printLine(addIfMinReply.getMessage());
        else
            printer.printLine("Не удалось добавить элемент в коллекцию");
    }
}
