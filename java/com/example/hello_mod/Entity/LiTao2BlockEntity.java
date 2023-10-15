package com.example.hello_mod.Entity;

import com.example.hello_mod.set.Entitys;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.extensions.IForgeBlockEntity;

import java.util.List;

public class LiTao2BlockEntity extends BlockEntity implements IForgeBlockEntity {
    private static final int MAX_TIME = 5 * 20;
    private int timer = 0;
    public static BlockEntityTicker<LiTao2BlockEntity> ticker;
    public LiTao2BlockEntity(BlockPos pos, BlockState state){
        super(Entitys.BLOCK_ENTITY_TYPE_REGISTRY_OBJECT.get(),pos,state);
        ticker = createTicker(level,state,pos);
        System.out.println("successful");
    }
    public static BlockEntityTicker<LiTao2BlockEntity> createTicker(Level level, BlockState state, BlockPos pos /*BlockEntityType<LiTao2BlockEntity> blockEntityType*/) {
        return (level1, pos1, state1, blockEntity) -> blockEntity.tick();
    }

    private void tick() {
        if (level == null || level.isClientSide) return;

        timer++;
        if (timer >= 500) { // 1分钟 = 1200个游戏刻
            timer = 0;

            // 获取附近的玩家
            List<Player> players = level.getEntitiesOfClass(Player.class,getRenderBoundingBox().inflate(16));

            // 向玩家发送位置报告
            for (Player player : players) {
                double x = player.getX();
                double y = player.getY();
                double z = player.getZ();

                Component message = new TextComponent("The player " + player.getName().getString() + "'s position is" + x + ", " + y + ", " + z);
                player.sendMessage(message, player.getUUID());
            }
        }
    }
}
