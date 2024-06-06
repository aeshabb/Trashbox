package org.itmo.client.command;

import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.CountRoutesLessDistanceReply;
import org.itmo.dto.request.CountRoutesLessDistanceRequest;

import java.io.InputStreamReader;
import java.net.Socket;

public class CountRoutesLessDistanceCommand extends Command {

    public CountRoutesLessDistanceCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader) {
        super(socket, printer, inputStreamReader);


    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 1) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            try {
                CountRoutesLessDistanceRequest request = new CountRoutesLessDistanceRequest(Integer.parseInt(parameters[0]));
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
