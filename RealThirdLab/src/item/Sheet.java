package item;

public class Sheet extends Item {
    private String description;

    public Sheet(String material, String name, String description) {
        super(material, name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
