package pokes;

import attacks.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Poliwhirl extends Pokemon {
    public Poliwhirl(String name, int lvl) {
        super(name, lvl);
        setStats(65, 65, 65, 50, 50, 90);
        setType(Type.WATER);
        setMove(new Substitute(), new LightScreen(), new ShadowPunch(), new HydroPump());

    }
}
