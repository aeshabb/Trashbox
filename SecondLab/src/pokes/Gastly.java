package pokes;

import attacks.HydroPump;
import attacks.LightScreen;
import attacks.ShadowPunch;
import attacks.Substitute;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Gastly extends Pokemon {
    public Gastly(String name, int lvl) {
        super(name, lvl);
        setStats(30, 35, 30, 100, 35, 80);
        setType(Type.GHOST, Type.POISON);
        setMove(new HydroPump(), new LightScreen());
    }
}
