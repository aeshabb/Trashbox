package org.itmo.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class Request implements Serializable {
    private final String name;
    private final String username;
    private final String password;

    protected Request(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
