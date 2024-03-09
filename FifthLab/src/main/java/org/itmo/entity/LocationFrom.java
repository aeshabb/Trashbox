package org.itmo.entity;

/**
 * Класс для локации из которой едет Route.
 */
public class LocationFrom {
    /**
     * x coordinate
     */
    private long xLF;
    /**
     * y coordinate
     */
    private double yLF;
    /**
     * z coordinate
     */
    private float zLF;
    /**
     * name(could be null)
     */
    private String nameLF; //Поле может быть null

    /**
     *
     * @param x
     * @param y
     * @param z
     * @param name
     */
    public LocationFrom(long x, double y, float z, String name) {
        this.xLF = x;
        this.yLF = y;
        this.zLF = z;
        this.nameLF = name;
    }

    /**
     *
     * @return x
     */
    public long getxLF() {
        return xLF;
    }

    /**
     *
     * @param xLF
     */
    public void setxLF(long xLF) {
        this.xLF = xLF;
    }

    /**
     *
     * @return y
     */
    public double getyLF() {
        return yLF;
    }

    /**
     *
     * @param yLF
     */
    public void setyLF(double yLF) {
        this.yLF = yLF;
    }

    /**
     *
     * @return z
     */
    public float getzLF() {
        return zLF;
    }

    /**
     *
     * @param zLF
     */
    public void setzLF(float zLF) {
        this.zLF = zLF;
    }

    /**
     *
     * @return name
     */
    public String getNameLF() {
        return nameLF;
    }

    /**
     *
     * @param nameLF
     */
    public void setNameLF(String nameLF) {
        this.nameLF = nameLF;
    }

    /**
     *
     * @return toString
     */
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
