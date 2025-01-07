package org.itmo.server.thread;

import org.itmo.dto.reply.Reply;
import org.itmo.server.network.Network;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class WriteThread implements Runnable{
    private final Reply reply;
    private final SelectionKey key;

    public WriteThread(Reply reply, SelectionKey key){
        this.reply = reply;
        this.key = key;
    }

    @Override
    public void run() {
        try {
            Network.write((SocketChannel) key.channel(), reply);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
