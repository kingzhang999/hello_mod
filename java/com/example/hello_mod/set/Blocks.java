package com.example.hello_mod.set;

import com.example.hello_mod.Main;
import com.example.hello_mod.blocks.LiTao2;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Blocks {
    public static DeferredRegister<Block> deferredRegister = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);
    public static final Block LITAO2 = registerBlock(new LiTao2(),"litao2");
    public static Block registerBlock(Block block, String name){
        deferredRegister.register(name,()->block);/*此处要使用lambda表达式的原因是此处要输入一个Supplier<? extends I>类型的参数,
        而使用lambda表达式则可以在不创建其他类用于实现Supplier接口的情况下直接实现Supplier接口并返回Supplier<? extends I>类型的参数*/
        deferredRegister.register(Main.bus);
        Initialize.blocksArrayList.add(block);
        return block;
    }
}
