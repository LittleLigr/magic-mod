package ru.littleligr.magic.spell.engine.type;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;
import ru.littleligr.magic.spell.ISpell;
import ru.littleligr.magic.spell.engine.modificator.SpellModificator;
import ru.littleligr.magic.spell.world.ProjectileSpellModel;
import ru.particgen.effect.Effect;

import java.util.List;
import java.util.function.Consumer;

public class Projectile extends SpellBase implements ISpell {

    public Projectile(List<SpellModificator> spellModificators) {
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
        ProjectileSpellModel model = new ProjectileSpellModel(player, after);
        model.setVelocity(player, player.getPitch(), player.getYaw(), 0, 5, 1);
        player.world.spawnEntity(model);
    }

    @Override
    public List<SpellModificator> getModificators() {
        return null;
    }
}
