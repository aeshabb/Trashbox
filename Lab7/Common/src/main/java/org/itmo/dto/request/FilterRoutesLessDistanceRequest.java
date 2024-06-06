package org.itmo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterRoutesLessDistanceRequest extends Request {
    private int distance;
    public FilterRoutesLessDistanceRequest(int distance, String name, String username, String password){
        super(name, username, password);
        this.distance = distance;
    }
}
