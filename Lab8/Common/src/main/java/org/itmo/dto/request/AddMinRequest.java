package org.itmo.dto.request;

import org.itmo.entity.Route;

public class AddMinRequest extends AddRequest{
    public AddMinRequest(Route route, String username, String password) {
        super("add_if_min", route, username, password);
    }
}
