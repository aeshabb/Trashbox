package org.itmo.command;

import com.opencsv.exceptions.CsvException;
import org.itmo.output.CommandPrinter;
import org.itmo.runner.Runner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class ExecuteScriptCommand extends Command {

    public ExecuteScriptCommand(Receiver receiver, String description, CommandPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 1) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            try {
                Runner runner = new Runner(new CommandPrinter(new PrintStream("nul")));
                InputStream inputStream = new FileInputStream(parameters[0]);
                runner.runMethods(inputStream, true);
            } catch (CsvException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
