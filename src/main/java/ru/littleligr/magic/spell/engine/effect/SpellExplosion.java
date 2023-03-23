package ru.littleligr.magic.spell.engine.effect;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import ru.littleligr.magic.spell.ISpell;
import ru.littleligr.magic.spell.engine.modificator.SpellModificator;
import ru.particgen.effect.Effect;

import java.util.List;
import java.util.function.Consumer;

public class SpellExplosion implements ISpell, SpellEffect {

    public final float power;
    public SpellExplosion(float power){
        this.power = power;
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
        player.world.createExplosion(player, pos.x, pos.y, pos.z, power, Explosion.DestructionType.BREAK);
        after.accept(pos);
    }

    @Override
    public List<SpellModificator> getModificators() {
        return null;
    }

}
