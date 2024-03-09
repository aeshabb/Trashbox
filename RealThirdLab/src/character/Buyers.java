package character;

import exception.NegativeBalanceException;
import food.Salt;
import place.Place;

public class Buyers extends Human implements Buyer {
    public Buyers(String name, double height, double weight, double balance, Salt salt, Place place, boolean selling) {
        super(name, height, weight, balance, salt, place, selling);
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

}
