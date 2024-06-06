package org.itmo.client.command;

import com.opencsv.exceptions.CsvException;
import org.itmo.client.entity.User;
import org.itmo.client.output.InfoPrinter;
import org.itmo.client.runner.Runner;

import java.io.*;
import java.net.Socket;

public class ExecuteScriptCommand extends Command {

    public ExecuteScriptCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader, User user) {
        super(socket, printer, inputStreamReader, user);

    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 1) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            try {
                InputStream inputStream = new FileInputStream(parameters[0]);
                Runner runner = new Runner(new InfoPrinter(new PrintStream("nul")), new InputStreamReader(inputStream), socket);
                runner.setUser(user);
                runner.runMethods(true);
            } catch (IOException e) {
                printer.printLine("Проверьте путь к файлу");
            }
        }
    }
}
