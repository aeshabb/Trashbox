package org.itmo.dto.request;

import lombok.Getter;

@Getter
public class RemoveLowerRequest extends Request{
    private final int distance;
    public RemoveLowerRequest(int distance){
        super("remove_lower");
        this.distance = distance;
    }
}
