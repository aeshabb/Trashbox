package org.itmo.dto.request;

import lombok.Getter;
import org.itmo.entity.Route;

@Getter
public class AddRequest extends Request {
    private final Route route;

    public AddRequest(Route route, String username, String password){
        super("add", username, password);
        this.route = route;
    }

    protected AddRequest(String name, Route route, String username, String password){
        super(name, username, password);
        this.route = route;
    }

}
