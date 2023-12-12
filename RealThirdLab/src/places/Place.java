package places;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Place implements Complementable{
    private final List<Building> newBuildings = new ArrayList<>();
    private String material;
    private String name;
    private double size;

    public Place(String name, String material, double size) {
        this.name = name;
        this.material = material;
        this.size = size;
    }
    public Place() {}

    public void addNewBuilding(Building building) {
        newBuildings.add(building);
        System.out.println(building.getName() + " is built");
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

    public List<Building> getNewBuildings() {
        return newBuildings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place place)) return false;
        return Double.compare(getSize(), place.getSize()) == 0 && Objects.equals(getNewBuildings(), place.getNewBuildings()) && Objects.equals(getMaterial(), place.getMaterial()) && Objects.equals(getName(), place.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNewBuildings(), getMaterial(), getName(), getSize());
    }

    @Override
    public String toString() {
        return "Place{" +
                "newBuildings=" + newBuildings +
                ", material='" + material + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
