package com.example.hello_mod.item;

import com.example.hello_mod.set.Effects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class PotionBurn extends Potion {
    public PotionBurn(){
        super(new MobEffectInstance(Effects.EFFECTBURN,20*30,1,false,true));
    }
}
