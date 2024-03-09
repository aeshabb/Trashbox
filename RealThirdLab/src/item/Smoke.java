package item;

public class Smoke extends Item {
    private double amount;

    public Smoke(String material, String name, double amount) {
        super(material, name);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
