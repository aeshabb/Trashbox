package story;

import character.*;
import exception.NegativeBalanceException;
import food.Dish;
import food.Salt;
import item.Door;
import item.Item;
import item.Pot;
import item.Smoke;
import output.ConsolePrinter;
import place.*;
import timeline.Day;
import timeline.DayTime;

public class ChefStory extends Story {
    public ChefStory(String description, ConsolePrinter consolePrinter) {
        super(description, consolePrinter);
    }

    @Override
    public void execute() {
        Day day = new Day(DayTime.AFTERNOON);
        Building restaurant = new Restaurant("Restaurant", "Rock", 2052);
        Building kitchen = new Kitchen("Kitchen", "Gold", 50);

        restaurant.addNewBuilding(kitchen, consolePrinter);
        Item door = new Door("Wood", "Door");
        kitchen.addNewItem(door, consolePrinter);

        day.setDayTime(DayTime.EVENING, consolePrinter);
        Human alice = new Alice("Alice", 160, 40, 100, new Salt(30), restaurant, false);
        alice.setPlace(kitchen, consolePrinter);

        kitchen.getSmoky(new Smoke("Smoke", "Smoke", 100), consolePrinter);
        Place stool = new Stool("Taburet", "Wood", 3);
        Duchess duchess = new Duchess("Duchess", 180, 50, 1000000, new Salt(300), stool, false);
        Baby baby = new Baby("Baby", 80, 7, 0, new Salt(0), stool, false);
        duchess.rockBaby(baby, consolePrinter);

        Chef chef = new Chef("Chef", 163, 140, 200, new Salt(300), kitchen, false);
        chef.buyBrandedKnife(100, consolePrinter);
        chef.learnHowToCook(2, 30, consolePrinter);

        Pot pot = new Pot("Steel", "Pot");
        chef.addDishToPot(Dish.SOUP, pot, consolePrinter);
        chef.bandOverThePot(consolePrinter);
        chef.mixTheSoup(pot, consolePrinter);
        chef.giveDishToEveryone(pot.getDishToCook(), consolePrinter);


        Chef suChef = new Chef("SuChef", 190, 80, 200, new Salt(300), kitchen, false) {
            @Override
            public void learnHowToCook(double time, double money, ConsolePrinter consolePrinter) {
                money = money * time * 2;
                try {
                    if (getBalance() < money) {
                        throw new NegativeBalanceException("Недостаточно средств");
                    }
                    setBalance(getBalance() - money);
                    consolePrinter.printLine(getName() + " потребовалось вдвое больше средств для обучения по сравнению с Chef");
                } catch (NegativeBalanceException e) {
                    System.out.println("У " + getName() + " недостаточно средств для обучения");
                }
            }
        };
        suChef.learnHowToCook(10, 9, consolePrinter);
    }
}
