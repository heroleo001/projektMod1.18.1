package net.leo.weebquirks.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.leo.weebquirks.WeebQuirks;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;


public class SetKorosenseiAbilityCommand {
    public SetKorosenseiAbilityCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("ability").requires((hh) -> hh.hasPermission(2))
                .then(Commands.literal("korosensei").executes((command) -> {
            return setKorosenseiAbility(command.getSource());
        })));
    }

    private int setKorosenseiAbility(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        boolean hasAbility = player.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability").length != 0;
        System.out.println(hasAbility + " player abilitzy");

        if (!hasAbility) {
            player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                    new int[]{ 5 });
            WeebQuirks.setKorosenseiPlayerEntity(player);
            source.sendSuccess(new TextComponent("ability set to Korosensei"), true);
            player.getPersistentData().putBoolean(WeebQuirks.MOD_ID + "speedActive", false);

            return 1;
        } else {
            source.sendSuccess(new TextComponent("player already has an ability"), true);
            return -1;
        }
    }
}
