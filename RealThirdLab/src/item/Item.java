package item;

public abstract class Item {
    private String material;
    private String name;

    public Item(String material, String name) {
        this.material = material;
        this.name = name;
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
}
