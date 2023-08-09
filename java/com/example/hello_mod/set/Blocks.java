package com.example.hello_mod.set;

import com.example.hello_mod.Main;
import com.example.hello_mod.blocks.LiTao2;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Blocks {
    public static final Block LITAO2 = registerBlock(new LiTao2(),"litao2");
    public static Block registerBlock(Block block,String name){
        DeferredRegister<Block> deferredRegister = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);
        deferredRegister.register(name,()->block);
        deferredRegister.register(Main.bus);
        Initialize.blocksArrayList.add(block);
        return block;
    }
}
