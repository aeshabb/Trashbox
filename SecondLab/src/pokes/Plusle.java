package pokes;

import attacks.Amnesia;
import ru.ifmo.se.pokemon.Type;

public class Plusle extends Manectric {
    public Plusle(String name, int lvl) {
        super(name, lvl);
        setStats(60, 50, 40, 85, 75, 95);
        setType(Type.ELECTRIC);
        addMove(new Amnesia());
    }
}
