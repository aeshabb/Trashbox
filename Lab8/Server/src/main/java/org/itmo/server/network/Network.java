package org.itmo.server.network;



import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.Request;
import org.itmo.server.command.Command;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Network {

    public static SelectionKey accept(SelectionKey key) throws IOException {
        var ssc = (ServerSocketChannel) key.channel();
        var sc = ssc.accept();
        ByteBuffer buf = ByteBuffer.allocate(4096);
        sc.configureBlocking(false);
        var newKey = sc.register(key.selector(), SelectionKey.OP_READ);
        newKey.attach(buf);
        System.out.println("New client connected from " + sc.getRemoteAddress());
        return newKey;
    }


    public static Request read(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer byteBuf = (ByteBuffer) key.attachment();

        int total = 0;
        while (total < 4) {
            int bytesRead = channel.read(byteBuf);
            if (bytesRead == -1) {
                channel.close();
                return null;
            }
            total += bytesRead;
        }

        total -= 4;
        byteBuf.flip();
        int len = byteBuf.getInt();
        byteBuf.compact();
        // читаем
        while (total != len) {
            int bytesRead = channel.read(byteBuf);
            if (bytesRead == -1) {
                channel.close();
                return null;
            }
            total += bytesRead;
        }
        byteBuf.flip();

        // объект пришёл полностью и его можно обрабатывать, десериализовывать и т.д.
        ByteArrayInputStream bis = new ByteArrayInputStream(byteBuf.array(), 0, len);
        ObjectInputStream ois = new ObjectInputStream(bis);
        try {
            return (Request) ois.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception");
            return null;
        }

    }

    public static void write(SocketChannel channel, Reply reply) throws IOException {
        ByteBuffer buffer = Command.serialize(reply);
        // сперва запишем длину
        var lenBuf = ByteBuffer.wrap(intToBytes(buffer.array().length));
        while (lenBuf.hasRemaining()) {
            int bytesWritten = channel.write(lenBuf);
            if (bytesWritten == -1) {
                throw new IOException();
            }
        }

        // теперь запишем сам Reply
        while (buffer.hasRemaining()) {
            int bytesWritten = channel.write(buffer);
            if (bytesWritten == -1) {
                throw new IOException();
            }
        }
        buffer.clear();
    }

    private static byte[] intToBytes(int x) {
        return new byte[]{
                (byte) ((x >> 24) & 0xFF),
                (byte) ((x >> 16) & 0xFF),
                (byte) ((x >> 8) & 0xFF),
                (byte) (x & 0xFF)
        };
    }


}