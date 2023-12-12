package places;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends Building implements Complementable{
    private final List<Building> newBuildings = new ArrayList<>();

    public Restaurant(String material, String name, double size) {
        super(material, name, size);
    }

    public void addNewBuilding(Building building) {
        newBuildings.add(building);
        System.out.println(building.getName() + " is built");
    }

    public List<Building> getNewBuildings() {
        return newBuildings;
    }
}
