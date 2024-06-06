package org.itmo.server.reader;

import org.itmo.server.collection.Receiver;
import org.itmo.server.runner.Runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Runnable {
    private final Receiver receiver;
    private final Runner runner;

    public ConsoleReader(Receiver receiver, Runner runner) {
        this.receiver = receiver;
        this.runner = runner;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите команду (для выхода введите exit, для сохранения коллекции save):");
            String input;
            while (!(input = reader.readLine()).equals("exit")) {
                if (input.equals("save")) {
//                    receiver.saveCollection();
                }
            }
//            receiver.saveCollection();
            reader.close();
            exit();
        } catch (IOException e) {
            System.out.println("Ошибка чтения ввода из stdin");
        }
    }

    private void exit() throws IOException {
        runner.exit();
        System.exit(0);
    }
}
