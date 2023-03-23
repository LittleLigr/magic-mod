package ru.littleligr.magic.effects;

import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import ru.particgen.animation.AnimationScheduler;
import ru.particgen.animation.EffectAnimation;
import ru.particgen.animation.spawn.ParticleSpawnSettings;
import ru.particgen.effect.Effect;
import ru.particgen.effect.EffectWorldData;
import ru.particgen.ParticleGenerator;
import ru.particgen.util.EffectTextureContainer;
import ru.particgen.util.ParticlePattern;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class MagicEffects {

    protected static ParticlePattern windPatter = null;
    protected static ParticlePattern rune1 = null;
    protected static EffectAnimation windAnimation = new EffectAnimation(AnimationScheduler.INSTANT, "end", animationTick -> {
        if (animationTick.tick() > 200)
            animationTick.scheduler().stop(animationTick.effect());
    });

    protected static EffectAnimation rune1Anim = new EffectAnimation(AnimationScheduler.INSTANT, "end", animationTick -> {
        if (animationTick.tick() > 100)
            animationTick.scheduler().stop(animationTick.effect());
    });

    public static void register(){
       ClassLoader classloader = Thread.currentThread().getContextClassLoader();
       try {
           EffectTextureContainer.registerFolder(new File(classloader.getResource("assets\\magic\\effects").toURI()));
           windPatter = EffectTextureContainer.convert("rune-wind").sizeInBlocks(new Vec2f(1, 1));
           rune1 = EffectTextureContainer.convert("rune1").sizeInBlocks(new Vec2f(1, 1));
       } catch (IOException e) {
           throw new RuntimeException(e);
       } catch (URISyntaxException e) {
           throw new RuntimeException(e);
       }
   }

   public static void generateWindEffect(ParticleSpawnSettings settings, ServerWorld world, Vec3d pos, Vec2f size) {
       EffectWorldData worldData =  new EffectWorldData(windPatter, settings, world, pos, size);
       worldData.particleEffect = ParticleTypes.EFFECT;
       ParticleGenerator.scheduler.subscribe(new Effect(worldData, windAnimation));
   }

    public static void generateRune1(ParticleSpawnSettings settings, ServerWorld world, Vec3d pos, Vec2f size) {
        EffectWorldData worldData =  new EffectWorldData(rune1, settings, world, pos, size);
        worldData.particleEffect = ParticleTypes.FLAME;
        ParticleGenerator.scheduler.subscribe(new Effect(worldData, rune1Anim));
    }
}
