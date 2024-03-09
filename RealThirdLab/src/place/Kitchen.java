package place;

import item.Item;
import output.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;

public class Kitchen extends Building implements Complementable {
    private final List<Building> newBuildings = new ArrayList<>();
    private final List<Item> newItems = new ArrayList<>();

    public Kitchen(String name, String material, double size) {
        super(name, material, size);
    }

    public void addNewBuilding(Building building, ConsolePrinter consolePrinter) {
        newBuildings.add(building);
        consolePrinter.printLine(building.getName() + " is built");
    }

    public void addNewItem(Item item, ConsolePrinter consolePrinter) {
        newItems.add(item);
        consolePrinter.printLine(item.getName() + " added");
    }

    public List<Building> getNewBuildings() {
        return newBuildings;
    }

    public List<Item> getNewItems() {
        return newItems;
    }
}
