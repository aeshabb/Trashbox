package place;

import item.Sheet;

public class Table extends Building {
    private Sheet sheet;

    public Table(String name, String material, double size) {
        super(name, material, size);
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public Sheet getSheet() {
        return sheet;
    }
}
