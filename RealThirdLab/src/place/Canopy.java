package place;

import output.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;

public class Canopy extends Building implements Complementable {
    private final List<Building> newBuildings = new ArrayList<>();

    public Canopy(String name, String material, double size) {
        super(name, material, size);
    }

    public void addNewBuilding(Building building, ConsolePrinter consolePrinter) {
        newBuildings.add(building);
        consolePrinter.printLine(building.getName() + " is built");
    }

    public List<Building> getNewBuildings() {
        return newBuildings;
    }
}
