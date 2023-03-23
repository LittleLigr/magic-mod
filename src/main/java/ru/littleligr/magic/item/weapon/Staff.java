package ru.littleligr.magic.item.weapon;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import ru.littleligr.magic.spell.Spell;
import ru.littleligr.magic.spell.engine.effect.SpellExplosion;
import ru.littleligr.magic.spell.engine.type.Projectile;

import java.util.HashMap;
import java.util.List;

public class Staff extends AxeItem {
    public Staff(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    Spell spell = new Spell(new Projectile(List.of()), List.of(new SpellExplosion(1), new SpellExplosion(10)), new HashMap<>());
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        spell.cast(user);

        return super.use(world, user, hand);
    }
}
