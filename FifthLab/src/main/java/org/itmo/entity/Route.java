package org.itmo.entity;

import java.time.LocalDateTime;

/**
 * Класс объектов, который хранится в нашей коллекции.
 */
public class Route implements Comparable<Route> {
    /**
     * id
     */
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /**
     * name(not null)
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * coordinates(not null)
     */
    private Coordinates coordinates; //Поле не может быть null
    /**
     * creationDate(not null)
     */
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /**
     * locationFrom(could be null)
     */
    private LocationFrom from; //Поле может быть null
    /**
     * locationTo(not null)
     */
    private LocationTo to; //Поле не может быть null
    /**
     * distance(could be null & more than 1)
     */
    private Integer distance; //Поле может быть null, Значение поля должно быть больше 1

    /**
     *
     * @param id
     * @param name
     * @param coordinates
     * @param creationDate
     * @param from
     * @param to
     * @param distance
     */
    public Route(int id, String name, Coordinates coordinates, LocalDateTime creationDate, LocationFrom from, LocationTo to, Integer distance) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }


    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     *
     * @param coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     *
     * @return creationDate
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     *
     * @param creationDate
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     *
     * @return locationFrom
     */
    public LocationFrom getLocationFrom() {
        return from;
    }

    /**
     *
     * @param from
     */
    public void setLocationFrom(LocationFrom from) {
        this.from = from;
    }

    /**
     *
     * @return locationTo
     */
    public LocationTo getLocationTo() {
        return to;
    }

    /**
     *
     * @param to
     */
    public void setLocationTo(LocationTo to) {
        this.to = to;
    }

    /**
     *
     * @return distance
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Route o) {
        return distance - o.distance;
    }

    /**
     *
     * @return toString
     */
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
