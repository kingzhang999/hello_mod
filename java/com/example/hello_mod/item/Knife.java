package com.example.hello_mod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class Knife extends SwordItem {
    public Knife(CreativeModeTab tab){
        super(Tiers.NETHERITE,10,-2,getProperties(tab));
    }
    public static Item.Properties getProperties(CreativeModeTab tab){
        return new Item.Properties().tab(tab);
    }
}
