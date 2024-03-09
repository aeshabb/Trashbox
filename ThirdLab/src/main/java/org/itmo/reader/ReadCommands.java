package org.itmo.reader;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadCommands {
    private final BufferedReader br;

    public ReadCommands(BufferedReader br) {
        this.br = br;
    }

    public String readConsoleString() throws IOException {
        return br.readLine();
    }

    public void stopStream() throws IOException {
        br.close();
    }
}
