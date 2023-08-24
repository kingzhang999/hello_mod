package com.example.hello_mod.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LiTao2_item extends BlockItem {
    public LiTao2_item(Block block, Properties properties) {
        super(block,properties);
    }
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.nullToEmpty("This is a luminous and hard li tao block.(not very hard)").copy().withStyle(ChatFormatting.GREEN));
        super.appendHoverText(itemStack,level,components,tooltipFlag);
    }
}
