package com.example.hello_mod.set;

import com.example.hello_mod.Main;
import com.example.hello_mod.item.PotionBurn;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Potions {
    public static final Potion POTIONBURN = registerPotion(new PotionBurn(),"potionburn");
    public static Potion registerPotion(Potion potion, String name){
        DeferredRegister<Potion> deferredRegister = DeferredRegister.create(ForgeRegistries.POTIONS, Main.MOD_ID);
        deferredRegister.register(name,()->potion);
        deferredRegister.register(Main.bus);
        Initialize.potionArrayList.add(potion);
        return potion;
    }
}
