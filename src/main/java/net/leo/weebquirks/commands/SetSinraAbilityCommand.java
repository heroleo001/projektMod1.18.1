package net.leo.weebquirks.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.leo.weebquirks.WeebQuirks;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class SetSinraAbilityCommand {
    public SetSinraAbilityCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("ability").requires((hh) -> hh.hasPermission(2))
                .then(Commands.literal("shinra").executes((command) -> {
            return setSinraAbility(command.getSource());
        })));
    }

    private int setSinraAbility(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        boolean hasAbility = player.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability").length != 0;

        if (!hasAbility){
            player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                    new int[]{ 3 });
            player.getPersistentData().putBoolean(WeebQuirks.MOD_ID + "fireActive", false);
            source.sendSuccess(new TextComponent("Ability set to Sinra"), true);

            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2147483646, 1, false, false));
            WeebQuirks.setSinraPlayerEntity(player);


            return 1;
        } else {
            source.sendSuccess(new TextComponent("This player already has an Ability!"), true);
            WeebQuirks.createLog("Unable to set Ability. Player already has an ability.");
            return -1;
        }
    }
}
