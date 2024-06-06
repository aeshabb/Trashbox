package org.itmo.database;

import org.itmo.entity.Route;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class RouteStorage {

    private final TreeSet<Route> routeSet;

    private final List<Integer> deletedRoute = new ArrayList<>();
    private final LocalDateTime initTime;



    public RouteStorage(TreeSet<Route> routeSet, LocalDateTime initTime) {
        this.initTime = initTime;
        this.routeSet = routeSet;
    }


    public void createRoute(Route route) {
        routeSet.add(route);
    }

    public TreeSet<Route> getRouteSet() {
        return routeSet;
    }


    public void deleteRoute(Route route) {
        routeSet.remove(route);
    }


    public LocalDateTime getInitTime() {
        return initTime;
    }

    public List<Integer> getDeletedRoute() {
        return deletedRoute;
    }
}

