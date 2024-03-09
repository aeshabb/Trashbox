package character;

import exception.NegativeBalanceException;
import food.Dish;
import food.Salt;
import item.Pot;
import output.ConsolePrinter;
import place.Place;

public class Chef extends Human {
    public Chef(String name, double height, double weight, double balance, Salt salt, Place place, boolean seller) {
        super(name, height, weight, balance, salt, place, seller);
    }

    public void learnHowToCook(double time, double money, ConsolePrinter consolePrinter) {
        money = money * time;
        try {
            if (getBalance() < money) {
                throw new NegativeBalanceException("Недостаточно средств");
            }
            setBalance(getBalance() - money);
            consolePrinter.printLine(getName() + " learned how to cook");
        } catch (NegativeBalanceException e) {
            System.out.println("У " + getName() + " недостаточно средств для обучения");
        }

    }

    public void addDishToPot(Dish dish, Pot pot, ConsolePrinter consolePrinter) {
        pot.setDishToCook(dish);
        consolePrinter.printLine("The " + dish.name() + " is cooking in the " + pot.getName() + " now");
    }

    public void mixTheSoup(Pot pot, ConsolePrinter consolePrinter) {
        pot.mixTheDish(pot.getDishToCook(), consolePrinter);
    }

    public void bandOverThePot(ConsolePrinter consolePrinter) {
        consolePrinter.printLine(getName() + " Нагнулась над кастрюлей для готовки");
    }

    public void giveDishToEveryone(Dish dish, ConsolePrinter consolePrinter) {
        consolePrinter.printLine(getName() + " give " + dish.name() + " to everyone");
    }

    public void buyBrandedKnife(double money, ConsolePrinter consolePrinter) {
        try {
            if (getBalance() < money) {
                throw new NegativeBalanceException("Недостаточно денег");
            }
            setBalance(getBalance() - money);
            BrandedKnife knife = new BrandedKnife("Branded knife", "Steel");
            consolePrinter.printLine(getName() + " купила себе " + knife.name + " сделанный из " + knife.material);
        } catch (NegativeBalanceException e) {
            System.out.println("Недостаточно денег для такого ножа");
        }
    }

    public static class BrandedKnife {
        String name;
        String material;

        public BrandedKnife(String name, String material) {
            this.name = name;
            this.material = material;
        }
    }

}
