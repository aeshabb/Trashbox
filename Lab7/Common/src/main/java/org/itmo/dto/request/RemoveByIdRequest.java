package org.itmo.dto.request;

import lombok.Getter;

@Getter
public class RemoveByIdRequest extends Request{
    private final int id;
    public RemoveByIdRequest(int id, String name, String username, String password){
        super(name, username, password);
        this.id = id;
    }
}
