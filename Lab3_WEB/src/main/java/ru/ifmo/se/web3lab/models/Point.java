package ru.ifmo.se.web3lab.models;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "point")
@SessionScoped
public class Point implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private double x;
    private double y;
    private double r;
    private boolean insideArea;
    private Date timestamp;
    private long executionTime;

    public Point() {
    }

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isInsideArea() {
        return insideArea;
    }

    public void setInsideArea(boolean insideArea) {
        this.insideArea = insideArea;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public void calc() {
        long now = System.nanoTime();
        double a = r/2;
        double b = -r;
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        insideArea = (((x <= 0 && x >= (-r)) && (y >= 0 && y <= r / 2) && (y <= 0.5*x + r/2)) ||
                (x >= 0 && y <= 0 && x <= r/2 && y >= (-r)) ||
                (x <= 0 && y <= 0 && (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r / 2, 2)))) && (x >= -4 && x <= 4 && y >= -5 && y <= 5 && r >= 1 && r <= 4);

        timestamp = new Date(System.currentTimeMillis());
        executionTime = System.nanoTime() - now;

    }
}
