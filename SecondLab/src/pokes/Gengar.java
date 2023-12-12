package pokes;

import attacks.Overheat;
import ru.ifmo.se.pokemon.Type;

public class Gengar extends Haunter{
    public Gengar(String name, int lvl) {
        super(name, lvl);
        setStats(60, 65, 60, 130, 75, 110);
        setType(Type.GHOST, Type.POISON);
        addMove(new Overheat());
    }
}
