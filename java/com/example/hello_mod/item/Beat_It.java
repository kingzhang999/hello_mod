package com.example.hello_mod.item;

import com.example.hello_mod.set.SoundInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class Beat_It extends RecordItem {
    public static final Supplier<SoundEvent> song = SoundInit.ENTITY_BEAT_IT_BEAT_IT;
    public Beat_It(CreativeModeTab tab){
        super(1,song,getProperties(tab).stacksTo(1));
    }
    public static Item.Properties getProperties(CreativeModeTab tab){
        return new Item.Properties().tab(tab);
    }
}
