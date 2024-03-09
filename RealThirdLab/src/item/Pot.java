package item;

import food.Dish;
import output.ConsolePrinter;

public class Pot extends Item {
    private Dish dishToCook;

    public Pot(String material, String name) {
        super(material, name);
    }

    public Dish getDishToCook() {
        return dishToCook;
    }

    public void setDishToCook(Dish dishToCook) {
        this.dishToCook = dishToCook;
    }

    public void mixTheDish(Dish dish, ConsolePrinter consolePrinter) {
        consolePrinter.printLine(dish.name() + " mixed by Chef");
    }

}
