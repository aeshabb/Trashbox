package story;

import character.Buyers;
import character.Human;
import character.Mistress;
import character.Ponchik;
import food.Salt;
import item.Sheet;
import output.ConsolePrinter;
import place.*;
import timeline.Day;
import timeline.DayTime;

public class PonchikStory extends Story {
    public PonchikStory(String description, ConsolePrinter consolePrinter) {
        super(description, consolePrinter);
    }

    @Override
    public void execute() {

        Day day = new Day(DayTime.NIGHT);
        Place station = new FoodFillingStation("Wood", "Food Station", 100);
        Place city = new City("New York", "Metal", 100000000);
        Sea sea = new Sea(new Salt(20), "Black sea", "Water", 999999999999.52);
        Buyers buyers = new Buyers("Покупатели", 160, 55, 100, new Salt(0), station, false);

        Mistress mistress = new Mistress("Хозяйка", 170, 55, 100, new Salt(0), station, false);
        Ponchik ponchik = new Ponchik("Пончик", 130, 40, 50, new Salt(0), city, false);

        day.setDayTime(DayTime.MORNING, consolePrinter);

        ponchik.setPlace(sea, consolePrinter);
        ponchik.addSaltFromTheSea(sea);

        mistress.setPreparing(true);
        Table table = new Table("Table", "Wood", 5);
        table.setSheet(new Sheet("Wood", "Sheet", "Продажа соли"));
        station.addNewBuilding(table, consolePrinter);

        ponchik.setPlace(station, consolePrinter);
        buyers.buySalt(20000, ponchik);
        ponchik.setBehavior("Торговал солью и одновременно закусывал, требуя подать ему то одно, то другое блюдо", consolePrinter);
        ponchik.eat();

        Restaurant restaurant = new Restaurant("ShwermaOtShaha", "Gold", 2052);
        Building veranda = new Veranda("Veranda", "Wood", 30);
        Building kitchen = new Kitchen("Kitchen", "Gold", 50);
        Building annex = new Annex("Annex", "Bedrock", 52);
        kitchen.setSize(kitchen.getSize() + 30);
        Canopy canopy = new Canopy("Canopy", "Брезент", 20);

        restaurant.addNewBuilding(veranda, consolePrinter);
        restaurant.addNewBuilding(kitchen, consolePrinter);
        restaurant.addNewBuilding(annex, consolePrinter);

        Seafront seafront = new Seafront("Sand", "", 525252);
        for (int i = 0; i < 20; i++) {
            canopy.addNewBuilding(new Table("Table", "Wood", 5), consolePrinter);
        }
        seafront.addNewBuilding(canopy, consolePrinter);

        ponchik.addSaltFromSomewhere(50);
        mistress.buySalt(ponchik.getSalt().getAmount() * ponchik.getSaltValue(), ponchik);

    }
}
