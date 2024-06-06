package org.itmo.client.command;

import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.UpdateReply;
import org.itmo.dto.request.UpdateRequest;
import org.itmo.entity.Route;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class UpdateCommand extends Command {

    private BufferedReader br;

    public UpdateCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, BufferedReader br) {
        super(socket, printer, inputStreamReader);
        this.br = br;
    }

    @Override
    public void execute(String[] args) {
        int id;
        if (args.length != 1) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            try {
                id = Integer.parseInt(args[0]);
                RouteParser routeParser = new RouteParser(printer, br);
                Route route = routeParser.parseRouteFromConsole(inputStreamReader);

                UpdateRequest updRequest = new UpdateRequest(id, route);
                UpdateReply updReply = (UpdateReply) Network.sendAndReceive(socket, updRequest);
                printer.printLine(updReply != null ? updReply.getMessage() : "Не удалось обновить элемент в коллекции");
            } catch (NumberFormatException numberFormatException) {
                printer.printLine("id должен быть int!");
            }
        }

    }
}

