package ru.littleligr.magic.spell.engine.type;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import ru.littleligr.magic.spell.engine.modificator.SpellModificator;
import ru.particgen.effect.Effect;

import java.util.List;
import java.util.function.Consumer;

public class Self extends SpellBase {
    public Self(List<SpellModificator> spellModificators) {
        super(spellModificators);
    }

    @Override
    public int getChargeTime() {
        return 0;
    }

    @Override
    public Effect getEffect() {
        return null;
    }

    @Override
    public void cast(PlayerEntity player, Vec3d pos, Consumer<Vec3d> after) {

    }

    @Override
    public List<SpellModificator> getModificators() {
        return null;
    }


}
