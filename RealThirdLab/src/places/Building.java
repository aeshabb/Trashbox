package places;

import java.util.Objects;

public abstract class Building {
    private String material;
    private String name;
    private double size;

    public Building(String name, String material, double size) {
        this.name = name;
        this.material = material;
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building building)) return false;
        return Double.compare(getSize(), building.getSize()) == 0 && Objects.equals(getMaterial(), building.getMaterial()) && Objects.equals(getName(), building.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaterial(), getName(), getSize());
    }

    @Override
    public String toString() {
        return "Building{" +
                "material='" + material + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
