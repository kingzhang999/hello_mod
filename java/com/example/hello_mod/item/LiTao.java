package com.example.hello_mod.item;

import com.example.hello_mod.set.Items;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LiTao extends Item {
    public LiTao(CreativeModeTab tab) {
        super(getProperties(tab).food((new FoodProperties.Builder()).nutrition(10).alwaysEat()
                .effect(() -> new MobEffectInstance(MobEffects.JUMP, 9600, 2, false, true), 1.0f)
                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 2, false, true), 1.0f).build()).fireResistant());
    }

    public static Item.Properties getProperties(CreativeModeTab tab) {
        return new Item.Properties().tab(tab);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
        ItemStack things = new ItemStack(Items.LITAO);
        super.finishUsingItem(itemstack, world, entity);
        if (itemstack.isEmpty()) {
            return things;
        } else {
            if (entity instanceof Player player) {
                if (!player.getInventory().add(things)) {
                    player.drop(things, false);
                }
            }
        }
        return itemstack;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.nullToEmpty("This is a magic LiTao.").copy().withStyle(ChatFormatting.AQUA));
        super.appendHoverText(itemStack,level,components,tooltipFlag);
    }
}
