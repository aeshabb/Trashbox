package org.itmo.command;

import org.itmo.database.RouteStorage;
import org.itmo.entity.Route;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Receiver {
    private final RouteStorage routeStorage;

    public Receiver(RouteStorage routeStorage) {
        this.routeStorage = routeStorage;
    }

    protected int getCollectionSize() {
        return routeStorage.getRouteSet().size();
    }

    protected Class getCollectionClass() {
        return routeStorage.getRouteSet().getClass();
    }

    protected LocalDateTime getInitTime() {
        return routeStorage.getInitTime();
    }

    protected TreeSet<Route> getCollection() {
        return routeStorage.getRouteSet();
    }

    protected void addRouteToTreeSet(Route route) {
        routeStorage.createRoute(route);
    }

    protected boolean checkIfMinDistance(int distance) {
        Iterator<Route> iter = routeStorage.getRouteSet().iterator();
        return distance <= iter.next().getDistance();
    }

    protected int getFreeId() {
        List<Integer> deletedRoute = routeStorage.getDeletedRoute();
        int id;
        if (!deletedRoute.isEmpty()) {
            id = deletedRoute.get(0);
            deletedRoute.remove(0);
        } else {
            id = routeStorage.getRouteSet().size() + 1;
        }
        return id;
    }

    protected void updateRouteToTreeSet(Route route) {
        if (routeStorage.getDeletedRoute().contains(route.getId())) {
            routeStorage.createRoute(route);
        } else {
            routeStorage.deleteRoute(findRouteById(route.getId()));
            routeStorage.createRoute(route);
        }

    }

    protected Route findRouteById(int id) {
        for (Route route : routeStorage.getRouteSet()) {
            if (route.getId() == id) {
                return route;
            }
        }
        return null;
    }

    protected void deleteRouteById(int id) {
        routeStorage.deleteRoute(findRouteById(id));
    }

    protected void clearRouteTreeSet() {
        TreeSet<Route> set = routeStorage.getRouteSet();
        set.clear();
    }

    protected void removeLowerDistance(int distance) {
        Iterator<Route> iter = routeStorage.getRouteSet().iterator();
        List<Route> routesToDelete = new ArrayList<>();
        Route route;
        while (iter.hasNext() && (route = iter.next()).getDistance() < distance) {
            routesToDelete.add(route);
        }
        for (Route route1 : routesToDelete) {
            routeStorage.deleteRoute(route1);
        }
    }

    protected Route getMinByFrom() {
        long x = 9223372036854775807L;
        Route route1 = null;
        for (Route route : routeStorage.getRouteSet()) {
            if (x > route.getLocationFrom().getxLF()) {
                x = route.getLocationFrom().getxLF();
                route1 = route;
            }
        }
        return route1;
    }

    protected int countRoutesLessDistance(int distance) {
        int cnt = 0;
        for (Route route : routeStorage.getRouteSet()) {
            if (distance > route.getDistance()) {
                cnt++;
            }
        }
        return cnt;
    }

    protected List<Route> getRoutesLessDistance(int distance) {
        List<Route> routes = new ArrayList<>();
        for (Route route : routeStorage.getRouteSet()) {
            if (distance > route.getDistance()) {
                routes.add(route);
            }
        }
        return routes;
    }
}