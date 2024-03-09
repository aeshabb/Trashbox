package character;

import food.Salt;
import output.ConsolePrinter;
import place.Building;
import place.Place;

import java.util.ArrayList;
import java.util.List;

public class Duchess extends Human {
    private List<Human> slaves = new ArrayList<>();

    public Duchess(String name, double height, double weight, double balance, Salt salt, Place place, boolean seller) {
        super(name, height, weight, balance, salt, place, seller);
        class Crown {
            final String name;
            final String material;

            Crown(String name, String material) {
                this.name = name;
                this.material = material;
            }
        }
        Crown crown = new Crown("Crown", "Gold");
        System.out.println(getName() + " носит " + crown.name + " сделанную из " + crown.material);

    }

    public void rockBaby(Baby baby, ConsolePrinter consolePrinter) {
        consolePrinter.printLine(this.getName() + " качает ребенка");
        baby.calmDown(this, consolePrinter);
    }

    public Baby giveABirthToABaby(ConsolePrinter consolePrinter, Place place) {
        consolePrinter.printLine(getName() + " родила ребенка");
        return new Baby("Baby", 80, 7, 0, new Salt(0), place, false);
    }

    public void earnInheritance(ConsolePrinter consolePrinter) {
        setBalance(1000000000);
        consolePrinter.printLine("Баланс " + getName() + " теперь - " + getBalance());
    }

    public void spendMoney(double money, ConsolePrinter consolePrinter) {
        setBalance(getBalance() - money);
        consolePrinter.printLine(getName() + " потратила " + money + " впустую");
    }

    public void ownSlave(Human slave, ConsolePrinter consolePrinter) {
        slaves.add(slave);
        consolePrinter.printLine(getName() + " наняла на работу " + slave.getName());
    }

    public List<Human> getSlaves() {
        return slaves;
    }

    public void setSlaves(List<Human> slaves) {
        this.slaves = slaves;
    }


}
