package com.example.hello_mod.CreativeModeTab;

import com.example.hello_mod.set.Initialize;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab extends CreativeModeTab {
    public ItemStack itemStack;
    public ModCreativeModeTab(String label,ItemStack itemStack){
        super(label);
        this.itemStack = itemStack;
        Initialize.creativemodetabArrayList.add(this);
    }
    @Override
    public ItemStack makeIcon() {
        return itemStack;
    }
}
