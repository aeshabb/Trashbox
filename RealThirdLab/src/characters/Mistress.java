package characters;

import items.Salt;
import places.Place;

public class Mistress extends Human implements Buyer {
    private boolean preparing;

    public Mistress(String name, double height, double weight, double balance, Salt salt, Place place, boolean selling) {
        super(name, height, weight, balance, salt, place, selling);
    }

    public void buySalt(double money, Ponchik ponchik) {
        setBalance(getBalance() - money);
        getSalt().setAmount(getSalt().getAmount() + money / ponchik.getSaltValue());
        ponchik.sellSalt(money);
    }
    public boolean isPreparing() {
        return preparing;
    }

    public void setPreparing(boolean preparing) {
        this.preparing = preparing;
    }
}
