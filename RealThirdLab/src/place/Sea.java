package place;

import food.Salt;

public class Sea extends Place {
    private Salt salt;

    public Sea(Salt salt, String name, String material, double size) {
        super(name, material, size);
        this.salt = salt;
    }

    public Salt getSalt() {
        return salt;
    }

    public void setSalt(Salt salt) {
        this.salt = salt;
    }
}
