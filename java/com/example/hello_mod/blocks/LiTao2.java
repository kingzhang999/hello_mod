package com.example.hello_mod.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class LiTao2 extends Block {
    public LiTao2(){
        super(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GREEN).sound(SoundType.METAL).strength(3.0f)
                .requiresCorrectToolForDrops().friction(0.8f));
    }
}
