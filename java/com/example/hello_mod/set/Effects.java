package com.example.hello_mod.set;

import com.example.hello_mod.Main;
import com.example.hello_mod.effects.EffectBurn;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Effects {
    public static final MobEffect EFFECTBURN = registerBuff(new EffectBurn(MobEffectCategory.HARMFUL,25,false),"effectburn");
    public static MobEffect registerBuff(MobEffect effect, String name){
        DeferredRegister<MobEffect> deferredRegister = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Main.MOD_ID);
        deferredRegister.register(name,()->effect);
        deferredRegister.register(Main.bus);
        Initialize.effectArrayList.add(effect);
        return effect;
    }
}
