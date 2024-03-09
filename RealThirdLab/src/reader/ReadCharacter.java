package reader;

import exception.BufferReaderException;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadCharacter {
    private BufferedReader br;

    public ReadCharacter(BufferedReader br) {
        this.br = br;
    }

    public String readConsoleString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new BufferReaderException("Неверный ввод");
        }

    }

    public void stopStream() {
        try {
            br.close();
        } catch (IOException e) {
            throw new BufferReaderException("Неверный ввод");
        }
    }

    public void reset() {
        try {
            br.reset();
        } catch (IOException e) {
            throw new BufferReaderException("Неверный ввод");
        }
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }
}
