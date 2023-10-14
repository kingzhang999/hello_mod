package com.example.hello_mod.Entity;

import com.example.hello_mod.set.Entitys;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LiTao2BlockEntity extends BlockEntity {
    public LiTao2BlockEntity(BlockPos pos, BlockState state){
        super(Entitys.BLOCK_ENTITY_TYPE_REGISTRY_OBJECT.get(),pos,state);
        System.out.println("successful");
    }
}
