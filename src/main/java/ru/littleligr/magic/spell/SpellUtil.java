package ru.littleligr.magic.spell;

import net.minecraft.entity.player.PlayerEntity;
import ru.littleligr.magic.spell.engine.SpellToken;
import ru.littleligr.magic.spell.engine.modificator.SpellModificator;
import ru.littleligr.magic.spell.engine.type.Projectile;
import ru.littleligr.magic.spell.engine.type.Self;

import java.util.List;

public abstract class SpellUtil {
    public static ISpell convertTokenToSpell(SpellToken token, PlayerEntity player, List<SpellModificator> mods){
        return switch (token){
            case PROJECTILE -> new Projectile(mods);
            case SELF -> new Self(mods);
        };
    }
}
