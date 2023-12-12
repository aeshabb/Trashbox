import pokes.*;
import ru.ifmo.se.pokemon.Battle;

public class Main {
    public static void main(String[] args) {
        Battle worldsBestBattle = new Battle();
        worldsBestBattle.addAlly(new Poliwhirl("Poli", 1));
        worldsBestBattle.addAlly(new Manectric("Mane", 1));
        worldsBestBattle.addAlly(new Plusle("Plus", 1));
        worldsBestBattle.addFoe(new Gastly("Gast", 1));
        worldsBestBattle.addFoe(new Haunter("Haunt", 1));
        worldsBestBattle.addFoe(new Gengar("Geng", 1));
        worldsBestBattle.go();
    }

}
