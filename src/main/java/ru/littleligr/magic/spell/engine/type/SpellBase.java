package ru.littleligr.magic.spell.engine.type;

import ru.littleligr.magic.spell.ISpell;
import ru.littleligr.magic.spell.engine.modificator.SpellModificator;

import java.util.List;

public abstract class SpellBase implements ISpell {

    protected final List<SpellModificator> spellModificators;

    public SpellBase(List<SpellModificator> spellModificators){
        this.spellModificators = spellModificators;
    }
}
