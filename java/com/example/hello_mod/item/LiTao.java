package com.example.hello_mod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class LiTao extends Item {
    public LiTao(CreativeModeTab tab){
        super(getProperties(tab).food((new FoodProperties.Builder()).nutrition(10).alwaysEat()
                .effect(() -> new MobEffectInstance(MobEffects.JUMP,9600,2,false,true),1.0f)
                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,9600,2,false,true),1.0f).build()));
    }
    public static Item.Properties getProperties(CreativeModeTab tab){
        return new Item.Properties().tab(tab);
    }

}
