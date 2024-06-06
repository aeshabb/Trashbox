package org.itmo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterRoutesLessDistanceRequest extends Request {
    private int distance;
    public FilterRoutesLessDistanceRequest(int distance) {
        super("filter_less_than_distance");
        this.distance = distance;
    }
}
