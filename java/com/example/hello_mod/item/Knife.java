package com.example.hello_mod.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Knife extends SwordItem {
    public Knife(CreativeModeTab tab){
        super(Tiers.NETHERITE,10,-2,getProperties(tab));
    }
    public static Item.Properties getProperties(CreativeModeTab tab){
        return new Item.Properties().tab(tab);
    }
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.nullToEmpty("This is a very interesting knife.").copy().withStyle(ChatFormatting.LIGHT_PURPLE));
        components.add(Component.nullToEmpty("It can make some sound like 'HAO A!!'.").copy().withStyle(ChatFormatting.LIGHT_PURPLE));
        super.appendHoverText(itemStack,level,components,tooltipFlag);
    }
}
