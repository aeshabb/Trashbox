package org.itmo.command;

import org.itmo.entity.Route;
import org.itmo.output.CommandPrinter;
import org.itmo.reader.ReaderCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class SaveCommand extends Command {

    public SaveCommand(Receiver receiver, String description, CommandPrinter printer) {
        super(receiver, description, printer);

    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 0) {
            printer.printLine("Неверный ввод аргументов");
        } else {
            try {
                TreeSet<Route> set = receiver.getCollection();
                FileWriter csvWriter = new FileWriter(System.getProperty("pathToCSV"));
                csvWriter.append(ReaderCSV.getHeaders()[0]);
                for (int i = 1; i < ReaderCSV.getHeaders().length; i++) {
                    csvWriter.append(",");
                    csvWriter.append(ReaderCSV.getHeaders()[i]);

                }
                csvWriter.append("\n");
                for (Route route : set) {
                    csvWriter.append(route.getName());
                    csvWriter.append(String.valueOf(route.getCoordinates().getxC())).append(",");
                    csvWriter.append(String.valueOf(route.getCoordinates().getyC())).append(",");
                    csvWriter.append(String.valueOf(route.getLocationFrom().getxLF())).append(",");
                    csvWriter.append(String.valueOf(route.getLocationFrom().getyLF())).append(",");
                    csvWriter.append(String.valueOf(route.getLocationFrom().getzLF())).append(",");
                    csvWriter.append(String.valueOf(route.getLocationFrom().getNameLF())).append(",");
                    csvWriter.append(String.valueOf(route.getLocationTo().getxLT())).append(",");
                    csvWriter.append(String.valueOf(route.getLocationTo().getyLT())).append(",");
                    csvWriter.append(String.valueOf(route.getLocationTo().getzLT())).append(",");
                    csvWriter.append(String.valueOf(route.getDistance()));
                    csvWriter.append("\n");
                }

                csvWriter.flush();
                csvWriter.close();
            } catch (IOException e) {
                System.out.println("Возникла ошибка во время записи, проверьте данные.");
            }

        }
    }
}
