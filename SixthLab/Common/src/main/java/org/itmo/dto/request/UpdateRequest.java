package org.itmo.dto.request;

import lombok.Getter;
import org.itmo.entity.Route;

@Getter
public class UpdateRequest extends Request{
    int id;
    Route route;

    public UpdateRequest(int id, Route route) {
        super("update");
        this.id = id;
        this.route = route;
    }
}
