package character;

import exception.NegativeBalanceException;
import food.Salt;
import output.ConsolePrinter;
import place.Place;

import java.util.ArrayList;
import java.util.List;

public class Mistress extends Human implements Buyer {
    private boolean preparing;
    private List<Place> property = new ArrayList<>();

    public Mistress(String name, double height, double weight, double balance, Salt salt, Place place, boolean selling) {
        super(name, height, weight, balance, salt, place, selling);
        Pet pet = new Pet("Тобик");
        System.out.println("У " + name + " появился " + pet.name);
    }

    public void buySalt(double money, Ponchik ponchik) {
        try {
            if (getBalance() < money) {
                throw new NegativeBalanceException("Недостаточно денег");
            }
            setBalance(getBalance() - money);
            getSalt().setAmount(getSalt().getAmount() + money / ponchik.getSaltValue());
            ponchik.sellSalt(money);
        } catch (NegativeBalanceException e) {
            System.out.println("У " + getName() + " недостаточно денег для покупки соли");
        }
    }

    public void earnMoney(ConsolePrinter consolePrinter, double time) {
        setBalance(getBalance() + time);
        consolePrinter.printLine(getName() + " заработала " + time + " медяков");
    }

    public void buyProperty(Place propertyToBuy, double cost, ConsolePrinter consolePrinter) {
        if (getBalance() >= cost) {
            setBalance(getBalance() - cost);
            property.add(propertyToBuy);
            consolePrinter.printLine(getName() + " купила " + propertyToBuy.getName() + " за " + cost + " медяков");
        }

    }

    public void rentProperty(Place propertyToRent, double cost, ConsolePrinter consolePrinter, Human renter) {
        setBalance(getBalance() + cost);
        renter.setBalance(renter.getBalance() - cost);
        renter.setSeller(true);
        consolePrinter.printLine(getName() + " сдала " + propertyToRent.getName() + " в аренду " + renter.getName());
    }

    public void openBusiness(Place propertyToOpen, ConsolePrinter consolePrinter) {
        if (property.contains(propertyToOpen)) {
            consolePrinter.printLine(propertyToOpen.getName() + " открыт для посетителей");
        }

    }

    public void moneyFromBusiness(Place business, double money, ConsolePrinter consolePrinter) {
        setBalance(getBalance() + money);
        consolePrinter.printLine(getName() + " заработала " + money + " медяков, благодаря " + business.getName());
    }

    public boolean isPreparing() {
        return preparing;
    }

    public void setPreparing(boolean preparing) {
        this.preparing = preparing;
    }

    public List<Place> getProperty() {
        return property;
    }

    public void setProperty(List<Place> property) {
        this.property = property;
    }


    public class Pet {
        String name;

        public Pet(String name) {
            this.name = name;
        }
    }
}
