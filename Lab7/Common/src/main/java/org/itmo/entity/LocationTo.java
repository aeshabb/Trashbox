package org.itmo.entity;


import java.io.Serializable;

public class LocationTo implements Serializable {

    private Double xLT; //Поле не может быть null

    private Long yLT; //Поле не может быть null

    private Integer zLT; //Поле не может быть null


    public LocationTo(Double x, Long y, Integer z) {
        this.xLT = x;
        this.yLT = y;
        this.zLT = z;
    }


    public Double getxLT() {
        return xLT;
    }

    public void setxLT(Double xLT) {
        this.xLT = xLT;
    }


    public Long getyLT() {
        return yLT;
    }


    public void setyLT(Long yLT) {
        this.yLT = yLT;
    }

    public Integer getzLT() {
        return zLT;
    }


    public void setzLT(Integer zLT) {
        this.zLT = zLT;
    }


    @Override
    public String toString() {
        return "LocationTo{" +
                "x=" + xLT +
                ", y=" + yLT +
                ", z=" + zLT +
                '}';
    }
}

