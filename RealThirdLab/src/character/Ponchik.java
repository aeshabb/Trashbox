package character;

import food.Dish;
import food.Salt;
import place.Place;
import place.Sea;

public class Ponchik extends Human {

    private double saltValue = 1;

    public Ponchik(String name, double height, double weight, double balance, Salt salt, Place place, boolean selling) {
        super(name, height, weight, balance, salt, place, selling);
    }

    protected void sellSalt(double money) {
        setBalance(getBalance() - money);
        getSalt().setAmount(getSalt().getAmount() - money / getSaltValue());
        System.out.println("Пончик заработал " + money + " медяков");
    }

    public void addSaltFromTheSea(Sea sea) {
        double seaSalt = sea.getSalt().getAmount();
        getSalt().setAmount(getSalt().getAmount() + seaSalt);
        System.out.println("Пончик накопал " + seaSalt + " грамм соли");
    }

    public void addSaltFromSomewhere(double value) {
        getSalt().setAmount(getSalt().getAmount() + value);
        System.out.println("Пончик нашел " + value + " грамм соли");
    }

    public void eat() {
        for (Dish dish : Dish.values()) {
            System.out.println("Пончик съел " + dish);
        }
    }

    public double getSaltValue() {
        return saltValue;
    }

    public void setSaltValue(double saltValue) {
        this.saltValue = saltValue;
    }
}
