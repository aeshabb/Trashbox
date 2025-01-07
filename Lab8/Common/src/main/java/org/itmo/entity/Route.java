package org.itmo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Route implements Comparable<Route>, Serializable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    private String name; //Поле не может быть null, Строка не может быть пустой

    private Coordinates coordinates; //Поле не может быть null

    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private LocationFrom from; //Поле может быть null

    private LocationTo to; //Поле не может быть null

    private Integer distance; //Поле может быть null, Значение поля должно быть больше 1


    public Route(int id, String name, Coordinates coordinates, LocalDateTime creationDate, LocationFrom from, LocationTo to, Integer distance) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }



    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }


    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }


    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }


    public LocationFrom getLocationFrom() {
        return from;
    }


    public void setLocationFrom(LocationFrom from) {
        this.from = from;
    }


    public LocationTo getLocationTo() {
        return to;
    }


    public void setLocationTo(LocationTo to) {
        this.to = to;
    }


    public Integer getDistance() {
        return distance;
    }


    public void setDistance(Integer distance) {
        this.distance = distance;
    }


    @Override
    public int compareTo(Route o) {
        return this.distance - o.distance;
    }


    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", from=" + from +
                ", to=" + to +
                ", distance=" + distance +
                '}';
    }
}
