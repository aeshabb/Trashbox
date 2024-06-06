package org.itmo.dto.request;


public class LoginRequest extends Request {

    public LoginRequest(String name, String username, String password){
        super(name, username, password);
    }

}
