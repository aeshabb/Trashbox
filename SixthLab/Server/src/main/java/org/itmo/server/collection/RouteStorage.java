package org.itmo.server.collection;



import lombok.Getter;
import lombok.Setter;
import org.itmo.entity.Route;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Getter
@Setter
public class RouteStorage {
    private TreeSet<Route> routeSet;

    private final List<Integer> deletedRoute = new ArrayList<>();
    private final LocalDateTime initTime;



    public RouteStorage(TreeSet<Route> routeSet, LocalDateTime initTime) {
        this.initTime = initTime;
        this.routeSet = routeSet;
    }


    public void clear(){
        routeSet.clear();
    }
    public String getInfo(){
        return "Тип коллекции: " + routeSet.getClass() + "\n" +
                "Дата инициализации: " + initTime + "\n" +
                "Размер: " + routeSet.size();
    }
    public void addRoute(Route route) {
        routeSet.add(route);
    }


    public void deleteRoute(Route route) {
        routeSet.remove(route);
    }



}

