package org.itmo.database;

import org.itmo.entity.Route;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Storage для хранения нашей коллекциии с crud операциями.
 */
public class RouteStorage {

    /**
     * routeSet
     */
    private final TreeSet<Route> routeSet;
    /**
     * deletedRoute
     */
    private final List<Integer> deletedRoute = new ArrayList<>();
    /**
     * initTime
     */
    private final LocalDateTime initTime;

    /**
     *
     * @param routeSet
     * @param initTime
     */

    public RouteStorage(TreeSet<Route> routeSet, LocalDateTime initTime) {
        this.initTime = initTime;
        this.routeSet = routeSet;
    }

    /**
     *
     * @param route
     */
    public void createRoute(Route route) {
        routeSet.add(route);
    }

    /**
     *
     * @return routeSet
     */
    public TreeSet<Route> getRouteSet() {
        return routeSet;
    }

    /**
     *
     * @param route
     */
    public void deleteRoute(Route route) {
        routeSet.remove(route);
    }

    /**
     *
     * @return initTime
     */
    public LocalDateTime getInitTime() {
        return initTime;
    }

    /**
     *
     * @return deletedRoute
     */
    public List<Integer> getDeletedRoute() {
        return deletedRoute;
    }
}

