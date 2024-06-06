package org.itmo.entity;


import java.io.Serializable;

public class LocationFrom implements Serializable {

    private long xLF;

    private double yLF;

    private float zLF;

    private String nameLF; //Поле может быть null


    public LocationFrom(long x, double y, float z, String name) {
        this.xLF = x;
        this.yLF = y;
        this.zLF = z;
        this.nameLF = name;
    }

    public long getxLF() {
        return xLF;
    }


    public void setxLF(long xLF) {
        this.xLF = xLF;
    }


    public double getyLF() {
        return yLF;
    }


    public void setyLF(double yLF) {
        this.yLF = yLF;
    }


    public float getzLF() {
        return zLF;
    }

    public void setzLF(float zLF) {
        this.zLF = zLF;
    }

    public String getNameLF() {
        return nameLF;
    }


    public void setNameLF(String nameLF) {
        this.nameLF = nameLF;
    }


    @Override
    public String toString() {
        return "LocationFrom{" +
                "x=" + xLF +
                ", y=" + yLF +
                ", z=" + zLF +
                ", name='" + nameLF + '\'' +
                '}';
    }
}
