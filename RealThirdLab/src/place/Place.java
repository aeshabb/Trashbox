package place;

import item.Item;
import item.Smoke;
import output.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Place implements Complementable {
    private final List<Building> newBuildings = new ArrayList<>();
    private final List<Item> newItems = new ArrayList<>();
    private String material;
    private String name;
    private double size;
    private Smoke smoke;

    public Place(String name, String material, double size) {
        this.name = name;
        this.material = material;
        this.size = size;
    }

    public void addNewBuilding(Building building, ConsolePrinter consolePrinter) {
        newBuildings.add(building);
        consolePrinter.printLine(building.getName() + " is built to " + name);
    }

    public void addNewItem(Item item, ConsolePrinter consolePrinter) {
        newItems.add(item);
        consolePrinter.printLine(item.getName() + " added");
    }

    public void getSmoky(Smoke smoke, ConsolePrinter consolePrinter) {
        this.smoke = smoke;
        consolePrinter.printLine("Очень дымно");
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

    public Smoke getSmoke() {
        return smoke;
    }

    public void setSmoke(Smoke smoke) {
        this.smoke = smoke;
    }

    public List<Item> getNewItems() {
        return newItems;
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
