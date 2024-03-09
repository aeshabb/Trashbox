package org.itmo.entity;

/**
 * Класс для хранения координат Route.
 */
public class Coordinates {
    /**
     * x coordinate(not null & lower than 660)
     */
    private Double xC; //Максимальное значение поля: 660, Поле не может быть null
    /**
     * y coordinate(could be null & lower than 909)
     */
    private int yC; //Максимальное значение поля: 909

    /**
     *
     * @param x
     * @param y
     */
    public Coordinates(Double x, int y) {
        this.xC = x;
        this.yC = y;
    }

    /**
     *
     * @return toString
     */
    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + xC +
                ", y=" + yC +
                '}';
    }

    /**
     *
     * @return x
     */
    public Double getxC() {
        return xC;
    }

    /**
     *
     * @param xC
     */
    public void setxC(Double xC) {
        this.xC = xC;
    }

    /**
     *
     * @return y
     */
    public int getyC() {
        return yC;
    }

    /**
     *
     * @param yC
     */
    public void setyC(int yC) {
        this.yC = yC;
    }
}
