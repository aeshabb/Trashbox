package org.itmo.client.command;

import org.itmo.client.entity.User;
import org.itmo.client.network.Network;
import org.itmo.client.output.InfoPrinter;
import org.itmo.dto.reply.ClearReply;
import org.itmo.dto.reply.FilterInfoReply;
import org.itmo.dto.reply.FilterReply;
import org.itmo.dto.request.ClearRequest;
import org.itmo.dto.request.FilterRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class FilterCommand extends Command {
    private final BufferedReader bufferedReader;

    public FilterCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, BufferedReader bufferedReader, User user) {
        super(socket, printer, inputStreamReader, user);
        this.bufferedReader = bufferedReader;

    }

    @Override
    public void execute(String[] args) {
        Map<String, String> userFilters = new HashMap<>();
        String line;
        printer.printLine("Введите фильтры: name + value");

        try {
            while (!"end".equals(line = bufferedReader.readLine())) {
                String[] parsed = line.trim().split(" ");
                if (parsed.length != 2) {
                    printer.printLine("Неверный набор аргументов");
                } else {
                    userFilters.put(parsed[0], parsed[1]);
                    printer.printLine("Закончить вводить фильтры: \"end\"");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        FilterRequest request = new FilterRequest("filter", userFilters, user.getUsername(), user.getPassword());
        FilterReply filterReply = (FilterReply) Network.sendAndReceive(socket, request);
        if (filterReply != null && filterReply.isSuccess())
            printer.printLine(filterReply.getResult());
        else
            printer.printLine("Вы неправильно указали фильтры");
    }
}
