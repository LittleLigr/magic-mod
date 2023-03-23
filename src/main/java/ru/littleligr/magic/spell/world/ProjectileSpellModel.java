package ru.littleligr.magic.spell.world;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;

import java.util.function.Consumer;

public class ProjectileSpellModel extends ProjectileEntity {

    protected final Consumer<Vec3d> afterHit;

    public ProjectileSpellModel(PlayerEntity player, Consumer<Vec3d> afterHit) {
        super(EntityType.SHULKER_BULLET, player.world);
        this.setOwner(player);
        this.afterHit = afterHit;
        this.refreshPositionAndAngles(player.getX(), player.getY() + 1, player.getZ(), this.getYaw(), this.getPitch());
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        afterHit.accept(new Vec3d(blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ()));
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    public void tick() {
        HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
        if (hitResult.getType() != HitResult.Type.MISS)
            this.onCollision(hitResult);
        this.checkBlockCollision();

        this.setPosition(this.getX() + getVelocity().x, this.getY() + getVelocity().y, this.getZ() + getVelocity().z);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        afterHit.accept(new Vec3d(entityHitResult.getEntity().getX(), entityHitResult.getEntity().getY(), entityHitResult.getEntity().getZ()));
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        this.discard();
    }
}
