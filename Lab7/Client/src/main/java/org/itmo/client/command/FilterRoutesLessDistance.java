package org.itmo.client.command;

import org.itmo.client.entity.User;
import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.FilterRoutesLessDistanceReply;
import org.itmo.dto.reply.RemoveLowerReply;
import org.itmo.dto.request.FilterRoutesLessDistanceRequest;
import org.itmo.dto.request.RemoveLowerRequest;
import org.itmo.entity.Route;

import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

public class FilterRoutesLessDistance extends Command {

    public FilterRoutesLessDistance(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, User user) {
        super(socket, printer, inputStreamReader, user);


    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 1) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            try {
                FilterRoutesLessDistanceRequest request = new FilterRoutesLessDistanceRequest(Integer.parseInt(parameters[0]), "filter_less_than_distance", user.getUsername(), user.getPassword());
                FilterRoutesLessDistanceReply reply = (FilterRoutesLessDistanceReply) Network.sendAndReceive(socket, request);
                if (reply != null && reply.isSuccess())
                    printer.printLine(reply.getResult());
                else
                    printer.printLine("Таких элементов нет!");
            } catch (NumberFormatException e) {
                printer.printLine("Неверный ввод");
            }
        }

    }
}
