package org.itmo.client.command;

import com.opencsv.exceptions.CsvException;
import org.itmo.client.output.InfoPrinter;
import org.itmo.client.runner.Runner;

import java.io.*;
import java.net.Socket;

public class ExecuteScriptCommand extends Command {

    public ExecuteScriptCommand(Socket socket, InfoPrinter printer, InputStreamReader inputStreamReader) {
        super(socket, printer, inputStreamReader);

    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 1) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            try {
                InputStream inputStream = new FileInputStream(parameters[0]);
                Runner runner = new Runner(new InfoPrinter(new PrintStream("nul")), new InputStreamReader(inputStream), socket);
                runner.runMethods(true);
            } catch (CsvException | IOException e) {
                printer.printLine("Проверьте путь к файлу");
            }
        }
    }
}
