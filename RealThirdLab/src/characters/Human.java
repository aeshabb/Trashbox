package characters;

import items.Salt;
import places.Place;

public abstract class Human implements StationBehavior{
    private String name;
    private double height;
    private double weight;
    private double balance;
    private Salt salt;
    private Place place;
    private boolean seller;
    private String behavior;

    public Human(String name, double height, double weight, double balance, Salt salt, Place place, boolean seller) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.balance = balance;
        this.salt = salt;
        this.place = place;
        this.seller = seller;
    }

    @Override
    public void stationBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getBalance() {
        return balance;
    }

    public Salt getSalt() {
        return salt;
    }

    public void setSalt(Salt salt) {
        this.salt = salt;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public boolean isSeller() {
        return seller;
    }

    public void setSeller(boolean seller) {
        this.seller = seller;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
}
