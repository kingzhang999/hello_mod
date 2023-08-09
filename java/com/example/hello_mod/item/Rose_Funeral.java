package com.example.hello_mod.item;

import com.example.hello_mod.set.SoundInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class Rose_Funeral extends RecordItem {
    public static final Supplier<SoundEvent> songs = SoundInit.ENTITY_ROSE_FUNERAL_MEI_GUI_HUA_DE_ZANG_LI;
    public Rose_Funeral(CreativeModeTab tab){
        super(1,songs,getProperties(tab).stacksTo(1));
    }
    public static Item.Properties getProperties(CreativeModeTab tab){
        return new Item.Properties().tab(tab);
    }
}
