package org.itmo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountRoutesLessDistanceRequest extends Request {
    private int distance;
    public CountRoutesLessDistanceRequest(int distance) {
        super("count_less_than_distance");
        this.distance = distance;
    }
}
