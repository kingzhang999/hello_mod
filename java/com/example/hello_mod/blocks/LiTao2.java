package com.example.hello_mod.blocks;

import com.example.hello_mod.Entity.LiTao2BlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LiTao2 extends Block implements EntityBlock {
    public LiTao2(){
        super(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GREEN).sound(SoundType.METAL).strength(3.0f,9.0f)
                .requiresCorrectToolForDrops().friction(0.8f).lightLevel((value) -> 12));
    }
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new LiTao2BlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        return EntityBlock.super.getTicker(level, blockState, blockEntityType);
    }
}
