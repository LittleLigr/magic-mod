package ru.littleligr.magic.spell;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import ru.littleligr.magic.spell.engine.modificator.SpellModificator;
import ru.particgen.effect.Effect;

import java.util.List;
import java.util.function.Consumer;

public interface ISpell {

    int getChargeTime();
    Effect getEffect();

    void cast(PlayerEntity player, Vec3d pos, Consumer<Vec3d> after);

    List<SpellModificator> getModificators();
}
