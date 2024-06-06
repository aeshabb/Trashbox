package org.itmo.entity;


import java.io.Serializable;

public class Coordinates implements Serializable {

    private Double xC; //Максимальное значение поля: 660, Поле не может быть null

    private int yC; //Максимальное значение поля: 909


    public Coordinates(Double x, int y) {
        this.xC = x;
        this.yC = y;
    }


    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + xC +
                ", y=" + yC +
                '}';
    }


    public Double getxC() {
        return xC;
    }


    public void setxC(Double xC) {
        this.xC = xC;
    }

    public int getyC() {
        return yC;
    }


    public void setyC(int yC) {
        this.yC = yC;
    }
}
