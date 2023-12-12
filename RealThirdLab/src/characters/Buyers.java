package characters;

import items.Salt;
import places.Place;

public class Buyers extends Human implements Buyer {
    public Buyers(String name, double height, double weight, double balance, Salt salt, Place place, boolean selling) {
        super(name, height, weight, balance, salt, place, selling);
    }

    public void buySalt(double money, Ponchik ponchik) {
        setBalance(getBalance() - money);
        getSalt().setAmount(getSalt().getAmount() + money / ponchik.getSaltValue());
        ponchik.sellSalt(money);
    }

}
