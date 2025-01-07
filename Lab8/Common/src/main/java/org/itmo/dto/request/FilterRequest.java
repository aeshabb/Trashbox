package org.itmo.dto.request;

import lombok.Getter;

import java.util.Map;
@Getter
public class FilterRequest extends Request{
    private final Map<String, String> userFilters;
    public FilterRequest(String name, Map<String, String> userFilters, String username, String password){
        super(name, username, password);
        this.userFilters = userFilters;
    }
}
