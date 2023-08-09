package com.example.hello_mod.set;

import com.example.hello_mod.Main;
import com.example.hello_mod.enchantments.fireproofing_shoot;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Enchantments {
    public static final Enchantment FIREPROOFING_SHOOT = registerenchantment(new fireproofing_shoot(),"fireproofing_shoot");
    public static Enchantment registerenchantment(Enchantment enchantment, String name){
        DeferredRegister<Enchantment> deferredRegister = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Main.MOD_ID);
        deferredRegister.register(name,()->enchantment);
        deferredRegister.register(Main.bus);
        Initialize.enchantmentArrayList.add(enchantment);
        return enchantment;
    }
}
