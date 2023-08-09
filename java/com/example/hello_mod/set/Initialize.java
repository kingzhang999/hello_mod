package com.example.hello_mod.set;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
//这是个专门用来注册的类
public class Initialize {
    public static final ArrayList<Item> itemsArrayList = new ArrayList<Item>();
    public static final ArrayList<CreativeModeTab> creativemodetabArrayList = new ArrayList<>();
    public static final ArrayList<Block> blocksArrayList = new ArrayList<>();
    public static final ArrayList<MobEffect> effectArrayList = new ArrayList<>();
    public static final ArrayList<Potion> potionArrayList = new ArrayList<>();
    public static final ArrayList<Enchantment> enchantmentArrayList = new ArrayList<>();

    public Initialize(){
        CreativeModeTab interest_things = CreativeModeTabs.INTEREST_THINGS;
        Item modItem = Items.MODITEM;
        Item liTao = Items.LITAO;
        Block litao2 = Blocks.LITAO2;
        Item litao2item = Items.LITAO2ITEM;
        Item kniFe = Items.KNIFE;
        MobEffect effectBurn = Effects.EFFECTBURN;
        Potion potionBurn = Potions.POTIONBURN;
        Item rose_Funeral = Items.ROSE_FUNERAL;
        Item beat_It = Items.BEAT_IT;
        Enchantment fireproofing_Shoot = Enchantments.FIREPROOFING_SHOOT;
    }
}
