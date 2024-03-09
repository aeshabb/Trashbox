package pokes;

import attacks.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Manectric extends Pokemon {
    public Manectric(String name, int lvl) {
        super(name, lvl);
        setStats(70, 75, 60, 105, 60, 105);
        setType(Type.ELECTRIC);
        setMove(new ThunderShock(), new ShadowPunch(), new ThunderWave());

    }
}
