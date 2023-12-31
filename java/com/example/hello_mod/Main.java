package com.example.hello_mod;

import com.example.hello_mod.Command.TestCommand;
import com.example.hello_mod.Entity.LiTao2BlockEntity;
import com.example.hello_mod.set.*;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Objects;


@Mod("hello_mod")
@Mod.EventBusSubscriber
public class Main {
    public static final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    public static final String MOD_ID = "hello_mod";
    public static int cishu = 0;
    public static boolean isLoose = false;
    @SubscribeEvent//标记这个方法是用来处理事件的
    public static void playerjoinworld(PlayerEvent.PlayerLoggedInEvent event){
        Player player = event.getPlayer();
        Level level = player.level;
        player.sendMessage(new TextComponent("Hello, "+player.getDisplayName().getString()+" from "+ (level.isClientSide()?"CLIENT":"SERVER")+"."), Util.NIL_UUID);
    }//playerjoinworld end
    @SubscribeEvent//标记这个方法是用来处理事件的
    public static void leftClickBlock(PlayerInteractEvent.LeftClickBlock l_event){
        Player player1 = l_event.getPlayer();
        Level level1 = player1.level;
        if(level1.isClientSide() && cishu < 5) {
            player1.sendMessage(new TextComponent("You destroy a block."), Util.NIL_UUID);
            cishu++;
        }//if end
    }//leftClickBlock end
    @SubscribeEvent
    public static void rightClickItem(PlayerInteractEvent.RightClickItem r_event) {
        Player player2 = r_event.getPlayer();
        Level level2 = player2.level;
        if(!level2.isClientSide()){
            ItemStack itemStack = r_event.getItemStack();
            Item item = itemStack.getItem();
            if (item == Items.DIAMOND_SWORD){
                HitResult hitResult = player2.pick(40,0,false);
                Vec3 location = hitResult.getLocation();
                player2.teleportTo(location.x(),location.y(),location.z());
            }//if end
        }//if end
    }//rightClickItem end
    @SubscribeEvent
    public static void onAttack(LivingHurtEvent event){
        Level world = event.getEntity().level;
        if(!world.isClientSide()){
            LivingEntity hurtOne = event.getEntityLiving();
            LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
            if(attacker!=null&&attacker.getMainHandItem().getItem() == com.example.hello_mod.set.Items.KNIFE){
                hurtOne.playSound(SoundInit.ENTITY_KNIFE_AIPI.get(),1.0f,1.0f);
                attacker.heal(2);
                attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION,20*10,1));
                attacker.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,20*9,1));
                hurtOne.addEffect(new MobEffectInstance(MobEffects.WITHER,20*20,1));
                hurtOne.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,20*10,1));
                hurtOne.addEffect(new MobEffectInstance(MobEffects.POISON,20*8,1));
            }//if end
        }//if end
    }//onAttack end
    @SubscribeEvent
    public static void onHit(LivingHurtEvent event){
        Level level = event.getEntity().level;
        LivingEntity hurtone = event.getEntityLiving();
        if(event.getSource().getEntity() instanceof Player attacker){
            if (event.isCanceled() || level.isClientSide()) return;
            if (attacker.getMainHandItem().getItem() == com.example.hello_mod.set.Items.MODITEM){
                LightningBolt lightningbolt= EntityType.LIGHTNING_BOLT.create(hurtone.level);
                if (lightningbolt != null) {
                    lightningbolt.setPos(hurtone.position());
                    hurtone.level.addFreshEntity(lightningbolt);/*因为Level类继承了LevelAccessor接口,LevelAccessor接口继承了
                CommonLevelAccessor接口,CommonLevelAccessor接口继承了LevelSimulatedRW接口,LevelSimulatedRW接口继承了
                LevelWriter接口,所以在这里才能用addFreshEntity方法*/
                    var item =  attacker.getMainHandItem();
                    item.hurtAndBreak(10,attacker,(things)-> {things.broadcastBreakEvent(attacker.getUsedItemHand());});
                    attacker.getCooldowns().addCooldown(com.example.hello_mod.set.Items.MODITEM,100);
                }//if end
            }//if end
        }else{
            LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
            if (event.isCanceled() || level.isClientSide()){
                return;
            }//if end
            if (attacker != null && attacker.getMainHandItem().getItem() == com.example.hello_mod.set.Items.MODITEM){
                LightningBolt lightningbolt= EntityType.LIGHTNING_BOLT.create(hurtone.level);
                if (lightningbolt != null) {
                    lightningbolt.setPos(hurtone.position());
                    hurtone.level.addFreshEntity(lightningbolt);/*因为Level类继承了LevelAccessor接口,LevelAccessor接口继承了
                CommonLevelAccessor接口,CommonLevelAccessor接口继承了LevelSimulatedRW接口,LevelSimulatedRW接口继承了
                LevelWriter接口,所以在这里才能用addFreshEntity方法*/
                    var item = attacker.getMainHandItem();
                    item.shrink(1);
                }//if end
            }//if end
        }//else end
    }//onHit end
    @SubscribeEvent
    public static void arrowHitEvent(ProjectileImpactEvent event){
        if (event.getProjectile().getOwner() instanceof Player attacker){
            Level level;
            level = attacker.getLevel();
            if (event.getRayTraceResult().getType() == HitResult.Type.ENTITY && !level.isClientSide() && attacker.getMainHandItem().getItem() instanceof BowItem && isLoose) {
                Arrow en = (Arrow) event.getProjectile();
                level.playSound(null,attacker.getX(),attacker.getY(),attacker.getZ(),SoundInit.ENTITY_BOW_DING.get(),SoundSource.VOICE,1.0f,1.0f);
                if(EnchantmentHelper.getEnchantmentLevel(Enchantments.FIREPROOFING_SHOOT,attacker)>0){
                    attacker.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,20*30,1));
                    if (attacker.getRandom().nextFloat() < 0.35f){
                        level.explode(en,en.getX(),en.getY(),en.getZ(),3.0f,false, Explosion.BlockInteraction.BREAK);
                    }
                }
                isLoose = false;
            }else if (!level.isClientSide() && attacker.getMainHandItem().getItem() == com.example.hello_mod.set.Items.WATER_BOW && isLoose && event.getRayTraceResult().getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = event.getProjectile().getOnPos();
                level.setBlock(blockPos, Blocks.WATER.defaultBlockState(),1);
                event.getProjectile().remove(Entity.RemovalReason.KILLED);
            } else if (!level.isClientSide() && attacker.getMainHandItem().getItem() instanceof BowItem && EnchantmentHelper.getEnchantmentLevel(Enchantments.FIREPROOFING_SHOOT,attacker)>0 && isLoose){
                attacker.sendMessage(new TextComponent("You missed!!!"),Util.NIL_UUID);
            }
        }
    }
    @SubscribeEvent
    public static void loose_event(ArrowLooseEvent event){
        if(event.getEntity() != null){
            Entity entity = event.getEntity();
            if(entity instanceof Player){
                isLoose = true;
            }
        }
    }
    @SubscribeEvent
    public static void level_tick(TickEvent.PlayerTickEvent event){
        if(event.side.isServer()){
            Player player = event.player;
            if(event.phase == TickEvent.Phase.START && player.tickCount % 5000 == 0){
                Level level = player.getLevel();
                if(level.equals(Objects.requireNonNull(level.getServer()).getLevel(DimensionInit.HELLO_KEY))){
                    Zombie zombie = new Zombie(level);
                    zombie.setItemInHand(InteractionHand.MAIN_HAND, Items.DIAMOND_AXE.getDefaultInstance());
                    zombie.moveTo(player.getX()+player.getRandom().nextDouble(10,25),player.getY(),player.getZ()+player.getRandom().nextDouble(10,25));
                    level.addFreshEntity(zombie);
                }
            }
        }
    }
    @SubscribeEvent
    public static void first_command(RegisterCommandsEvent event){
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        LiteralCommandNode<CommandSourceStack> cmd = dispatcher.register(
                Commands.literal(MOD_ID).then(
                        Commands.literal("test")
                                .then(Commands.argument("password", StringArgumentType.string())
                                        .requires((sourceStack)-> sourceStack.hasPermission(0))
                                        .executes(TestCommand.instance))
                )
        );
        dispatcher.register(Commands.literal("hm").redirect(cmd));//表示hm和hello_mod是等价的。
    }
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.getWorld().isClientSide()) {
            return; // 只在服务器端执行逻辑
        }

        BlockState blockState = event.getState();
        BlockPos pos = event.getPos();

        // 检查方块实体是否存在

        BlockEntity tileEntity = event.getWorld().getBlockEntity(pos);//这个方法会获取曾经存在在这里的方块实体。
        if (tileEntity instanceof LiTao2BlockEntity) {
            LiTao2BlockEntity.MAX -= 2;
            // 方块实体存在
            // 在这里执行你想要的逻辑，比如发送消息提示等
        }
    }
    public Main(){
        new Initialize();
        SoundInit.SOUNDS.register(bus);
        Entitys.BLOCK_ENTITY_TYPE_DEFERRED_REGISTER.register(bus);
        DimensionInit.register();
        //ModStructures.register(bus);ps:以后解决问题后再用
    }//Main end
}//class end
