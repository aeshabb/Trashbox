package org.itmo.server.thread;

import lombok.Setter;
import org.itmo.dto.request.Request;
import org.itmo.server.network.Network;

import java.io.IOException;
import java.nio.channels.SelectionKey;
@Setter
public class ReadThread implements Runnable {

    private SelectionKey key;
    private ProcessThread processThread;

    public ReadThread(SelectionKey key, ProcessThread processThread) {
        this.key = key;
        this.processThread = processThread;
    }

    @Override
    public void run() {
        try {
            Request req = Network.read(key);
            var attachment = key.attachment();
            key.channel().register(key.selector(), SelectionKey.OP_READ, attachment);
            processThread.setKey(key);
            processThread.setRequest(req);
            Thread thread = new Thread(processThread);
            thread.start();
        } catch (IOException e) {
            System.out.println("Пользователь отключился");
        }
    }

}