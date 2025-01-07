package org.itmo.dto.request;

public class RegisterRequest extends Request {
    public RegisterRequest(String name, String username, String password){
        super(name, username, password);
    }
}
