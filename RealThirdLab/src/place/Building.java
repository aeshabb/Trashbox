package place;

import java.util.Objects;

public abstract class Building extends Place {

    public Building(String name, String material, double size) {
        super(name, material, size);
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
                "material='" + getMaterial() + '\'' +
                ", name='" + getName() + '\'' +
                ", size=" + getSize() +
                '}';
    }
}
