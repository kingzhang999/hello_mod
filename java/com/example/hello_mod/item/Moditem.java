package com.example.hello_mod.item;

import com.example.hello_mod.set.Blocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//创建了一个新物品
public class Moditem extends Item {
    public Moditem(CreativeModeTab tab){
        super(getProperties(tab));
    }
    public static Item.Properties getProperties(CreativeModeTab tab){
        return new Item.Properties().tab(tab).durability(100);
    }
    public static ArrayList<Item> awards = new ArrayList<>(Arrays.asList(Items.ENCHANTED_GOLDEN_APPLE,Items.GOLDEN_APPLE,
            Items.TNT,Items.DIAMOND, com.example.hello_mod.set.Items.LITAO2ITEM, com.example.hello_mod.set.Items.MODITEM));
    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, List<Component> components, @NotNull TooltipFlag tooltipFlag) {
        components.add(Component.nullToEmpty("This is a very interesting jing lei.").copy().withStyle(ChatFormatting.GOLD));
        components.add(Component.nullToEmpty("It can make thunderbolt to hit entities.").copy().withStyle(ChatFormatting.GOLD));
        super.appendHoverText(itemStack,level,components,tooltipFlag);
    }
    @Override
    public @NotNull InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockpos = useOnContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if(block != Blocks.LITAO2){
            Player player = useOnContext.getPlayer();
            if (player != null) {
                int lucky_number = player.getRandom().nextInt(0,(awards.size() - 1));
                player.addItem(new ItemStack(awards.get(lucky_number),10));
                var itemstack = useOnContext.getItemInHand();
                itemstack.shrink(1);
                return InteractionResult.sidedSuccess(level.isClientSide());
            }
        }
        return super.useOn(useOnContext);
    }
}
