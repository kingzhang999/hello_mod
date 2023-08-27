package com.example.hello_mod.set;

import com.example.hello_mod.Main;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class DimensionInit {
    public static final ResourceKey<Level> HELLO_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,new ResourceLocation(Main.MOD_ID,"hello_world"));
    public static final ResourceKey<DimensionType> HELLO_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,HELLO_KEY.getRegistryName());
    public static void register() {
        System.out.println("Registering Hello_World Dimensions for " + Main.MOD_ID);
    }
}
