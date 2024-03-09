package character;

import food.Salt;
import output.ConsolePrinter;
import place.Place;

public class Baby extends Human {

    public Baby(String name, double height, double weight, double balance, Salt salt, Place place, boolean seller) {
        super(name, height, weight, balance, salt, place, seller);
    }

    public void calmDown(Human mom, ConsolePrinter consolePrinter) {
        consolePrinter.printLine("Ребенок успокоился");
    }
}
