package net.leo.weebquirks.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.leo.weebquirks.WeebQuirks;
import net.leo.weebquirks.item.ModItems;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;

public class EraseAbilityCommand {
    public EraseAbilityCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("ability").requires((hh) -> hh.hasPermission(2))
                .then(Commands.literal("erase_ability").executes((command) -> {
            return eraseAbility(command.getSource());
        })));
    }


    //LIST  Abilities:  Simon=1,  Eren=2, Shinra=3, Senku=4, Korosensei=5, OnePunchMan=6, Subaru=7

    public int eraseAbility(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        boolean hasAbility = player.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability").length != 0;
        System.out.println("1");
        if(hasAbility){
            switch (player.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability")[0]) {
                case 1 -> {
                    WeebQuirks.setSimonPlayerSet(false);
                    WeebQuirks.setSimonPlayerEntity(null);
                }
                case 2 -> {
                    WeebQuirks.setErenPlayerSet(false);
                    WeebQuirks.setErenPlayerEntity(null);
                }
                case 3 -> WeebQuirks.setSinraPlayerSet(false);
                case 4 -> {
                    WeebQuirks.setSenkuPlayerSet(false);
                    WeebQuirks.setSenkuPlayerEntity(null);
                }
                case 5 -> {
                    WeebQuirks.setKorosenseiPlayerEntity(null);
                    WeebQuirks.setKorosenseiPlayerSet(false);
                }
                case 6 -> {
                    WeebQuirks.setOnepunchmanPlayerEntity(null);
                    WeebQuirks.setOnepunchmanPlayerSet(false);
                }
                case 7 -> {
                    WeebQuirks.setSubaruPlayerEntity(null);
                    WeebQuirks.setSubaruPlayerSet(false);
                }
            }

            System.out.println("2");

            for (int i = 0; i < player.getInventory().getContainerSize(); ++i) {
                Item current = player.getInventory().getItem(i).getItem();
                if (current == ModItems.UPGRADER.get() || current == ModItems.TECHNIUM_DRILL.get() || current == ModItems.ONE_PUNCH_SWORD.get()){
                    player.getInventory().removeItem(i, 1);
                }
            }

            player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                    new int[]{  });
            source.sendSuccess(new TextComponent("Ability erased."), true);

            System.out.println("3");
            System.out.println("4");

            player.removeEffect(MobEffects.FIRE_RESISTANCE);
            player.removeEffect(MobEffects.HEALTH_BOOST);
            player.removeEffect(MobEffects.DAMAGE_BOOST);
            player.removeEffect(MobEffects.MOVEMENT_SPEED);
            
            player.getPersistentData().putBoolean(WeebQuirks.MOD_ID + "flameActive", false);
            WeebQuirks.createLog("Ability Erased.");
            System.out.println("5");
            return 1;
        } else {
            source.sendSuccess(new TextComponent("The ability can not be erased"), true);
            WeebQuirks.createLog("Ability could not be erased Erased.");
            return -1;
        }
    }
}
