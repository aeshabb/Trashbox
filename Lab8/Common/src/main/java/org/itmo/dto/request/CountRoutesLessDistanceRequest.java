package org.itmo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountRoutesLessDistanceRequest extends Request {
    private int distance;
    public CountRoutesLessDistanceRequest(int distance, String name, String username, String password){
        super(name, username, password);
        this.distance = distance;
    }
}
