package org.itmo.client.command;

import org.itmo.client.entity.User;
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

    public AddCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, BufferedReader br, User user) {
        super(socket, printer, inputStreamReader, user);
        this.br = br;
    }

    public void execute(String[] args) {
        RouteParser routeParser = new RouteParser(printer, br);
        Route route = routeParser.parseRouteFromConsole(inputStreamReader);
        AddRequest addRequest = new AddRequest(route, user.getUsername(), user.getPassword());
        AddReply addReply = (AddReply) Network.sendAndReceive(socket, addRequest);
        if (addReply != null && addReply.isSuccess())
            printer.printLine(addReply.getMessage());
        else if(addReply != null) {
            printer.printLine(addReply.getMessage());
        }
    }
}

