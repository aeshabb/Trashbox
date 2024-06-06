package org.itmo.client;


import com.opencsv.exceptions.CsvException;
import org.itmo.client.output.InfoPrinter;
import org.itmo.client.runner.Runner;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        Runner runner = new Runner(new InfoPrinter(new PrintStream(System.out)), new InputStreamReader(System.in));
        runner.runMethods(false);
    }
}