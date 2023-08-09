package com.example.hello_mod.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BaseEffect extends MobEffect {
    private boolean instant;
    private boolean isRegistered = false;
    protected float resistancePerLevel = 0.5f;//for any buff

    public BaseEffect(MobEffectCategory type, int color, boolean isInstant) {
        super(type, color);
        this.instant = isInstant;
    }
    @Override
    public boolean isInstantenous() {
        return false;
    }//这个方法可以被注释掉

    @Override
    public boolean isDurationEffectTick(int remainingTicks, int level) {
        if (isInstantenous()) {
            return true;
        }
        return canApplyEffect(remainingTicks, level);
    }

    protected boolean canApplyEffect(int remainingTicks, int level) {
        if (!isInstantenous()) {
            Thread.dumpStack();//这一行也可以被注释掉
        }
        return false;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (isInstantenous()) {
            applyInstantenousEffect(null, null, entity, amplifier, 1.0d);
        }
    }//这个方法可以被注释掉
    public BaseEffect onRegister() {
        isRegistered = true;
        return this;
    }//这个方法可以被注释掉
    public boolean isRegistered() {
        return isRegistered;
    }//这个方法可以被注释掉
}
