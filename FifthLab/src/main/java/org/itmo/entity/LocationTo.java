package org.itmo.entity;

/**
 * Класс локации в которую едет Route.
 */
public class LocationTo {
    /**
     * x coordinate
     */
    private Double xLT; //Поле не может быть null
    /**
     * y coordinate
     */
    private Long yLT; //Поле не может быть null
    /**
     * z coordinate
     */
    private Integer zLT; //Поле не может быть null

    /**
     *
     * @param x
     * @param y
     * @param z
     */
    public LocationTo(Double x, Long y, Integer z) {
        this.xLT = x;
        this.yLT = y;
        this.zLT = z;
    }

    /**
     *
     * @return x
     */
    public Double getxLT() {
        return xLT;
    }

    /**
     *
     * @param xLT
     */
    public void setxLT(Double xLT) {
        this.xLT = xLT;
    }

    /**
     *
     * @return y
     */
    public Long getyLT() {
        return yLT;
    }

    /**
     *
     * @param yLT
     */
    public void setyLT(Long yLT) {
        this.yLT = yLT;
    }

    /**
     *
     * @return z
     */
    public Integer getzLT() {
        return zLT;
    }

    /**
     *
     * @param zLT
     */
    public void setzLT(Integer zLT) {
        this.zLT = zLT;
    }

    /**
     *
     * @return toString
     */
    @Override
    public String toString() {
        return "LocationTo{" +
                "x=" + xLT +
                ", y=" + yLT +
                ", z=" + zLT +
                '}';
    }
}

