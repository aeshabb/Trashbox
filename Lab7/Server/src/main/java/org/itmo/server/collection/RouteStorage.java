package org.itmo.server.collection;


import lombok.Getter;
import lombok.Setter;
import org.itmo.entity.Route;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
public class RouteStorage {
    private TreeSet<Route> routeSet;
    private ReentrantLock lock = new ReentrantLock();

    private final List<Integer> deletedRoute = new ArrayList<>();
    private final LocalDateTime initTime;


    public RouteStorage(TreeSet<Route> routeSet, LocalDateTime initTime) {
        this.initTime = initTime;
        this.routeSet = routeSet;
    }


    public void clear() {
        lock.lock();
        routeSet.clear();
        lock.unlock();
    }

    public String getInfo() {
        return "Тип коллекции: " + routeSet.getClass() + "\n" +
               "Дата инициализации: " + initTime + "\n" +
               "Размер: " + routeSet.size();

    }

    public void addRoute(Route route) {
        lock.lock();
        routeSet.add(route);
        lock.unlock();
    }


    public void deleteRoute(Route route) {
        lock.lock();
        routeSet.remove(route);
        lock.unlock();
    }


}

