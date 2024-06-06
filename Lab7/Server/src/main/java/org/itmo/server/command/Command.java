package org.itmo.server.command;

import lombok.Getter;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.Request;
import org.itmo.server.collection.Receiver;
import org.itmo.server.output.InfoPrinter;


import java.io.*;
import java.nio.ByteBuffer;
@Getter
public abstract class Command {
    protected final Receiver receiver;

    protected final String description;
    protected final InfoPrinter printer;


    protected Command(Receiver receiver, String description, InfoPrinter printer) {
        this.receiver = receiver;
        this.description = description;
        this.printer = printer;
    }

    public static ByteBuffer serialize(Reply reply) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(reply);
        objectOutputStream.flush();
        byte[] serializedData = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        return ByteBuffer.wrap(serializedData);

    }

    public static Request deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Request) ois.readObject();
    }

    public abstract Reply process(Request request);

}
