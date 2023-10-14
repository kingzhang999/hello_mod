package com.example.hello_mod.set;

import com.example.hello_mod.Entity.LiTao2BlockEntity;
import com.example.hello_mod.Main;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Entitys {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Main.MOD_ID);
    public static final RegistryObject<BlockEntityType<?>> BLOCK_ENTITY_TYPE_REGISTRY_OBJECT = register("litao2_block_entity",Blocks.LITAO2, LiTao2BlockEntity::new);
    private static RegistryObject<BlockEntityType<?>> register(String registryname, Block block,
                                                               BlockEntityType.BlockEntitySupplier<?> supplier) {
        return BLOCK_ENTITY_TYPE_DEFERRED_REGISTER.register(registryname, () -> BlockEntityType.Builder.of(supplier, block).build(null));
    }
}
