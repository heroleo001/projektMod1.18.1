package net.leo.weebquirks.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.leo.weebquirks.WeebQuirks;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;

public class EraseAbilityCommand {
    public EraseAbilityCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("ability").then(Commands.literal("erase_ability").executes((command) -> {
            return eraseAbility(command.getSource());
        })));
    }


    //LIST  Abilities:  Simon=1,  Eren=2, Shinra=3, Senku=4, Korosensei=5, OnePunchMan=6, Subaru=7

    private int eraseAbility(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        boolean hasAbility = player.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability").length != 0;
        System.out.println("1");
        if(hasAbility){
            switch (player.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability")[0]){
                case 1:
                    WeebQuirks.setSimonPlayerSet(false);
                    WeebQuirks.setSimonPlayerEntity(null);
                    WeebQuirks.drillMode = WeebQuirks.HAS_NO_DRILL;
                    break;
                case 2:
                    WeebQuirks.setErenPlayerSet(false);
                    WeebQuirks.setErenPlayerEntity(null);
                    break;
                case 3:
                    WeebQuirks.setSinraPlayerSet(false);
                    break;
                case 4:
                    WeebQuirks.setSenkuPlayerSet(false);
                    WeebQuirks.setSenkuPlayerEntity(null);
                    break;
                case 5:
                    WeebQuirks.setKorosenseiPlayerEntity(null);
                    WeebQuirks.setKorosenseiPlayerSet(false);
                    break;
                case 6:
                    WeebQuirks.setOnepunchmanPlayerEntity(null);
                    WeebQuirks.setOnepunchmanPlayerSet(false);
                    break;
                case 7:
                    WeebQuirks.setSubaruPlayerEntity(null);
                    WeebQuirks.setSubaruPlayerSet(false);
            }

            System.out.println("2");

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