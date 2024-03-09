package pokes;

import attacks.Bite;
import ru.ifmo.se.pokemon.Type;

public class Haunter extends Gastly{
    public Haunter(String name, int lvl) {
        super(name, lvl);
        setStats(45, 50, 45, 115, 55, 95);
        setType(Type.GHOST, Type.POISON);
        addMove(new Bite());
    }
}
