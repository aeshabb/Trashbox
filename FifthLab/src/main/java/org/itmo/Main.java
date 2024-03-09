package org.itmo;

import com.opencsv.exceptions.CsvException;
import org.itmo.output.CommandPrinter;
import org.itmo.reader.ReaderCSV;
import org.itmo.runner.Runner;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Main class
 */
public class Main {
    /**
     *
     * @param args
     * @throws IOException
     * @throws CsvException
     */
    public static void main(String[] args) throws IOException, CsvException {
        System.setProperty("CSVPATH", "C:\\Users\\Алексей\\OneDrive\\Рабочий стол\\codes\\Trashbox\\FifthLab\\src\\main\\resources\\db.csv");
        ReaderCSV.readCSV(System.getProperty("CSVPATH"));
        Runner runner = new Runner(new CommandPrinter(new PrintStream(System.out)));
        runner.runMethods(System.in, false);
    }
}