package place;

import output.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;

public class Veranda extends Building implements Complementable {
    private final List<Building> newBuildings = new ArrayList<>();

    public Veranda(String material, String name, double size) {
        super(material, name, size);
    }

    public void addNewBuilding(Building building, ConsolePrinter consolePrinter) {
        newBuildings.add(building);
        consolePrinter.printLine(building.getName() + " is built");
    }

    public List<Building> getNewBuildings() {
        return newBuildings;
    }
}
