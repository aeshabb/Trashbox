package org.itmo.server.thread;

import org.itmo.dto.reply.LoginReply;
import org.itmo.dto.reply.RegisterReply;
import org.itmo.dto.reply.Reply;
import org.itmo.dto.request.Request;
import org.itmo.server.command.Command;
import org.itmo.server.database.DatabaseReceiver;

import java.nio.channels.SelectionKey;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class ProcessThread implements Runnable {
    private Request request;
    private SelectionKey key;
    private final ExecutorService cachedPool;
    private final Map<String, Command> commandMap;
    private final DatabaseReceiver databaseReceiver;


    public ProcessThread(Request request, SelectionKey key, ExecutorService cachedPool, Map<String, Command> commandMap, DatabaseReceiver databaseReceiver) {
        this.request = request;
        this.key = key;
        this.cachedPool = cachedPool;
        this.commandMap = commandMap;
        this.databaseReceiver = databaseReceiver;
    }

    @Override
    public void run() {
        Reply reply = commandMap.get(request.getName()).process(request);
        if (reply != null) {
            if (!(reply.isSuccess() && ((reply.getClass() == LoginReply.class) || (reply.getClass() == RegisterReply.class)))) {
                if (databaseReceiver.findUserByNameAndPassword(request.getUsername(), request.getPassword()) == -1) {
                    reply.setSuccess(false);
                }
            }
        }

        cachedPool.submit(new WriteThread(reply, key));
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setKey(SelectionKey key) {
        this.key = key;
    }

}
