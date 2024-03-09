package story;

import character.*;
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

public class AliceStory extends Story {
    public AliceStory(String description, ConsolePrinter consolePrinter) {
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

        Human alice = new Alice("Alice", 160, 40, 100, new Salt(30), restaurant, false);
        alice.setPlace(kitchen, consolePrinter);

        kitchen.getSmoky(new Smoke("Smoke", "Smoke", 100), consolePrinter);
        Place stool = new Stool("Taburet", "Wood", 3);
        Duchess duchess = new Duchess("Duchess", 180, 50, 1000000, new Salt(300), stool, false);
        Baby baby = new Baby("Baby", 80, 7, 0, new Salt(0), stool, false);
        duchess.rockBaby(baby, consolePrinter);

        Chef chef = new Chef("Chef", 163, 140, 20, new Salt(300), kitchen, false);
        Pot pot = new Pot("Steel", "Pot");
        chef.addDishToPot(Dish.SOUP, pot, consolePrinter);
        chef.bandOverThePot(consolePrinter);
        chef.mixTheSoup(pot, consolePrinter);


    }
}
