package net.leo.weebquirks.events;

import net.leo.weebquirks.WeebQuirks;
import net.leo.weebquirks.commands.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = WeebQuirks.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event){
        new SetSimonAbilityCommand(event.getDispatcher());
        new EraseAbilityCommand(event.getDispatcher());
        new SetErenAbilityCommand(event.getDispatcher());
        new SetSinraAbilityCommand(event.getDispatcher());
        new SetSenkuAbilityCommand(event.getDispatcher());
        new SetKorosenseiAbilityCommand(event.getDispatcher());
        new SetOnepunchmanAbilityCommand(event.getDispatcher());
        new SetSubaruAbilityCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event){
        if (event.getOriginal().getLevel().isClientSide){
            event.getPlayer().getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                    event.getOriginal().getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability"));
        }
    }

    @SubscribeEvent
    public static void onPlayerTickEvent(TickEvent.PlayerTickEvent event){
        if (WeebQuirks.sinraPlayerSet){
            ServerPlayer player = WeebQuirks.sinraPlayerEntity;

            //player.kill

            player.clearFire();
            if (WeebQuirks.sinraPlayerEntity.getPersistentData().getBoolean(WeebQuirks.MOD_ID + "flameActive")){
                BlockPos pos = player.getOnPos().above();
                Level world = player.getLevel();

                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 1, false, false));

                if (world.getBlockState(pos).getBlock() != Blocks.WATER && world.getBlockState(pos).getBlock() != Blocks.LAVA){
                    world.setBlockAndUpdate(pos, Blocks.FIRE.defaultBlockState());
                }
            }
            player.clearFire();
        } else {
            WeebQuirks.setSinraPlayerSet(false);
        }
    }




}
