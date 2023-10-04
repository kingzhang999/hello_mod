package com.example.hello_mod.set;

import com.example.hello_mod.Main;
import com.example.hello_mod.item.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.example.hello_mod.set.Blocks.LITAO2;

//这个类用来注册并保存物品
public class Items {
    public static final Item MODITEM = registerItem(new Moditem(CreativeModeTabs.INTEREST_THINGS),"moditem");
    public static final Item LITAO = registerItem(new LiTao(CreativeModeTabs.INTEREST_THINGS),"litao");
    public static final Item LITAO2ITEM = registerItem(new LiTao2_item(LITAO2,new Item.Properties().tab(CreativeModeTabs.INTEREST_THINGS)),"litao2");
    public static final Item KNIFE = registerItem(new Knife(CreativeModeTabs.INTEREST_THINGS),"knife");
    public static final Item ROSE_FUNERAL = registerItem(new Rose_Funeral(CreativeModeTabs.INTEREST_THINGS),"rose_funeral");
    public static final Item BEAT_IT = registerItem(new Beat_It(CreativeModeTabs.INTEREST_THINGS),"beat_it");
    public static final Item WATER_BOW = registerItem(new WaterBow(CreativeModeTabs.INTEREST_THINGS),"water_bow");
    public static Item registerItem(Item item,String name){
        DeferredRegister<Item> deferredRegister = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
        deferredRegister.register(name,()->item);
        deferredRegister.register(Main.bus);
        Initialize.itemsArrayList.add(item);
        return item;
    }
}
