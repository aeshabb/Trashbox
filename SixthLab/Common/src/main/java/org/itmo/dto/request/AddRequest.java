package org.itmo.dto.request;

import lombok.Getter;
import org.itmo.entity.Route;

@Getter
public class AddRequest extends Request {
    public final Route route;
    public AddRequest(Route route){
        super("add");
        this.route = route;
    }

    protected AddRequest(String name, Route route){
        super(name);
        this.route = route;
    }

}
