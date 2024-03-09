package story;

import character.Buyers;
import character.Mistress;
import character.Ponchik;
import food.Salt;
import output.ConsolePrinter;
import place.*;
import timeline.Day;
import timeline.DayTime;

public class MistressStory extends Story {
    public MistressStory(String description, ConsolePrinter consolePrinter) {
        super(description, consolePrinter);
    }

    @Override
    public void execute() {
        Day day = new Day(DayTime.MORNING);
        Place city = new City("New York", "Metal", 100000000);
        Sea sea = new Sea(new Salt(20), "Black sea", "Water", 999999999999.52);

        Mistress mistress = new Mistress("Хозяйка", 170, 55, 100, new Salt(0), city, false);

        mistress.new Pet("");


        Ponchik ponchik = new Ponchik("Пончик", 130, 40, 50, new Salt(0), city, false);
        Buyers buyers = new Buyers("Покупатели", 160, 55, 1000, new Salt(0), city, false);

        day.setDayTime(DayTime.AFTERNOON, consolePrinter);
        mistress.earnMoney(consolePrinter, 200);
        mistress.earnMoney(consolePrinter, 400);

        ponchik.addSaltFromSomewhere(20);
        ponchik.addSaltFromTheSea(sea);

        mistress.buySalt(50, ponchik);
        buyers.buySalt(30, ponchik);

        day.setDayTime(DayTime.EVENING, consolePrinter);
        Place station = new FoodFillingStation("Wood", "Food Station", 100);
        mistress.buyProperty(station, 500, consolePrinter);
        mistress.rentProperty(station, 40, consolePrinter, ponchik);
        ponchik.addSaltFromTheSea(sea);
        ponchik.addSaltFromSomewhere(1000);
        ponchik.setPlace(station, consolePrinter);
        buyers.buySalt(300, ponchik);
        buyers.buySalt(250, ponchik);
        mistress.buySalt(200, ponchik);

        day.setDayTime(DayTime.NIGHT, consolePrinter);
        mistress.earnMoney(consolePrinter, 9999);
        Restaurant restaurant = new Restaurant("ShwermaOtShaha", "Gold", 2052);
        Building veranda = new Veranda("Veranda", "Wood", 30);
        Building kitchen = new Kitchen("Kitchen", "Gold", 50);
        Building annex = new Annex("Annex", "Bedrock", 52);
        mistress.buyProperty(restaurant, 1000, consolePrinter);
        mistress.buyProperty(kitchen, 2000, consolePrinter);
        mistress.buyProperty(annex, 500, consolePrinter);

        restaurant.addNewBuilding(veranda, consolePrinter);
        restaurant.addNewBuilding(kitchen, consolePrinter);
        restaurant.addNewBuilding(annex, consolePrinter);

        mistress.openBusiness(restaurant, consolePrinter);
        mistress.moneyFromBusiness(restaurant, 10000, consolePrinter);


    }
}
