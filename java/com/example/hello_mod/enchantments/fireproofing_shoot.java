package com.example.hello_mod.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class fireproofing_shoot extends Enchantment {
    public static final EquipmentSlot[] en = {EquipmentSlot.MAINHAND};
    public fireproofing_shoot(){
        super(Rarity.COMMON, EnchantmentCategory.BOW,en);
    }
    @Override
    public int getMaxLevel() {
        return 4;
    }
}
