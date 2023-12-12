package places;

import java.util.ArrayList;
import java.util.List;

public class Kitchen extends Building implements Complementable{
    private final List<Building> newBuildings = new ArrayList<>();
    public Kitchen(String name, String material, double size) {
        super(name, material, size);
    }
    public void addNewBuilding(Building building) {
        newBuildings.add(building);
        System.out.println(building.getName() + " is built");
    }

    public List<Building> getNewBuildings() {
        return newBuildings;
    }
}
