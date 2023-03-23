package ru.littleligr.magic.spell;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import ru.littleligr.magic.spell.engine.effect.SpellEffect;
import ru.littleligr.magic.spell.engine.modificator.SpellModificator;
import ru.littleligr.magic.spell.engine.type.SpellBase;
import ru.particgen.effect.Effect;

import java.util.*;
import java.util.function.Consumer;

public record Spell(SpellBase spellBase, List<SpellEffect> spellEffects,
                    HashMap<SpellEffect, SpellModificator> spellModificatorHashMap) implements ISpell {

    public Spell(SpellBase spellBase, List<SpellEffect> spellEffects, HashMap<SpellEffect, SpellModificator> spellModificatorHashMap) {
        this.spellBase = spellBase;
        this.spellEffects = Lists.reverse(spellEffects);
        this.spellModificatorHashMap = spellModificatorHashMap;
    }

    @Override
    public int getChargeTime() {
        return spellBase.getChargeTime() +
                spellEffects.stream().map(SpellEffect::getChargeTime).reduce(Integer::sum).orElse(0) +
                spellModificatorHashMap.values().stream().map(ISpell::getChargeTime).reduce(Integer::sum).orElse(0);
    }

    @Override
    public Effect getEffect() {
        return null;
    }

    @Override
    public void cast(PlayerEntity player, Vec3d pos, Consumer<Vec3d> after) {
        Iterator<SpellEffect> iterator = spellEffects.iterator();

        Consumer<Vec3d> afterEffect = (x) -> {
        };

        while (iterator.hasNext()) {
            Consumer<Vec3d> finalAfterEffect = afterEffect;
            SpellEffect nextSpellEffect = iterator.next();
            afterEffect = (newPos) -> nextSpellEffect.cast(player, newPos, finalAfterEffect);
        }

        spellBase.cast(player, pos, afterEffect);
    }

    public void cast(PlayerEntity player) {
        cast(player, player.getPos(), x -> {});
    }


    @Override
    public List<SpellModificator> getModificators() {
        return null;
    }

}
