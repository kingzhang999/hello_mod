package com.example.hello_mod.effects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class EffectBurn extends BaseEffect{
    public EffectBurn(MobEffectCategory type,int color,boolean isInstant){
        super(type,color,isInstant);
    }//EffectBurn end
    @Override
    //buff隔多久生效一次
    protected boolean canApplyEffect(int remainingTicks, int level){
        return remainingTicks % 5 ==0;
    }
    //buff在生物身上的效果
    @Override
    public void applyEffectTick(LivingEntity living, int amplifier){
        amplifier++;
        if (living instanceof Player){//如果是玩家的话,就加快其饥饿速度,并让其冻伤
             ((Player)living).causeFoodExhaustion(1.3f*amplifier);
            ((Player)living).hurt(DamageSource.FREEZE,1f);
        }
        //生物每次受到0.5乘buff等级这么多的伤害
        living.hurt(DamageSource.ON_FIRE,0.5f*amplifier);
        living.hurt(DamageSource.WITHER,0.5f*amplifier);
    }
    @Override
    public boolean isBeneficial(){
        return false;
    }
}
