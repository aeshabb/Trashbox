package org.itmo.dto.request;

import org.itmo.entity.Route;

public class AddMinRequest extends AddRequest{
    public AddMinRequest(Route route) {
        super("add_if_min", route);
    }
}
