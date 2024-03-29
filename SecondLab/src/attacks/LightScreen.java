package attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class LightScreen extends StatusMove{
    public LightScreen(){
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        Effect effect = (new Effect()).stat(Stat.SPECIAL_DEFENSE, 3).turns(5);
        p.addEffect(effect);
    }

    @Override
    protected String describe(){
        return "uses Light Screen";
    }
}