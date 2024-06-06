package org.itmo.dto.request;

import lombok.Getter;

@Getter
public class RemoveLowerRequest extends Request{
    private final int distance;
    public RemoveLowerRequest(int distance, String name, String username, String password){
        super(name, username, password);
        this.distance = distance;
    }
}
