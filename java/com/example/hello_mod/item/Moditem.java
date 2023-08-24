package com.example.hello_mod.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

//创建了一个新物品
public class Moditem extends Item {
    public Moditem(CreativeModeTab tab){
        super(getProperties(tab));
    }
    public static Item.Properties getProperties(CreativeModeTab tab){
        return new Item.Properties().tab(tab);
    }
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.nullToEmpty("This is a very interesting jing lei.").copy().withStyle(ChatFormatting.GOLD));
        components.add(Component.nullToEmpty("It can make thunderbolt to hit entities.").copy().withStyle(ChatFormatting.GOLD));
        super.appendHoverText(itemStack,level,components,tooltipFlag);
    }
}
