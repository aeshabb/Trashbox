package story;

import character.*;
import food.Salt;
import item.Door;
import item.Item;
import output.ConsolePrinter;
import place.*;
import timeline.Day;
import timeline.DayTime;

public class DuchessStory extends Story {
    public DuchessStory(String description, ConsolePrinter consolePrinter) {
        super(description, consolePrinter);
    }

    @Override
    public void execute() {
        Complementable kingdom = (building, printer) -> consolePrinter.printLine("В королевстве новое здание - " + building.getName());

        Day day = new Day(DayTime.AFTERNOON);
        Building restaurant = new Restaurant("Restaurant", "Rock", 2052) ;
        Building kitchen = new Kitchen("Kitchen", "Gold", 50);

        restaurant.addNewBuilding(kitchen, consolePrinter);
        kingdom.addNewBuilding(restaurant, consolePrinter);
        Item door = new Door("Wood", "Door");
        kitchen.addNewItem(door, consolePrinter);

        day.setDayTime(DayTime.EVENING, consolePrinter);
        Duchess duchess = new Duchess("Duchess", 180, 50, 1000000, new Salt(300), kitchen, false);
        duchess.earnInheritance(consolePrinter);
        duchess.spendMoney(42131, consolePrinter);

        Human alice = new Alice("Alice", 160, 40, 100, new Salt(30), restaurant, false);
        Chef chef = new Chef("Chef", 163, 140, 20, new Salt(300), kitchen, false);
        duchess.ownSlave(alice, consolePrinter);
        duchess.ownSlave(chef, consolePrinter);

        Baby baby = duchess.giveABirthToABaby(consolePrinter, new Table("Table", "Wood", 20));
        duchess.rockBaby(baby, consolePrinter);


    }
}
