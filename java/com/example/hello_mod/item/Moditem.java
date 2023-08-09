package com.example.hello_mod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

//创建了一个新物品
public class Moditem extends Item {
    public Moditem(CreativeModeTab tab){
        super(getProperties(tab));
    }
    public static Item.Properties getProperties(CreativeModeTab tab){
        return new Item.Properties().tab(tab);
    }
}
