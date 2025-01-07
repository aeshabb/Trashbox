package org.itmo.client.command;

import org.itmo.client.entity.User;
import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.CountRoutesLessDistanceReply;
import org.itmo.dto.request.CountRoutesLessDistanceRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class CountRoutesLessDistanceCommand extends Command {

    public CountRoutesLessDistanceCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, User user) {
        super(socket, printer, inputStreamReader, user);


    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 1) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            try {
                CountRoutesLessDistanceRequest request = new CountRoutesLessDistanceRequest(Integer.parseInt(parameters[0]), "count_less_than_distance", user.getUsername(), user.getPassword());
                CountRoutesLessDistanceReply reply = (CountRoutesLessDistanceReply) Network.sendAndReceive(socket, request);
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
