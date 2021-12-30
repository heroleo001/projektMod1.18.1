package net.leo.weebquirks.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.leo.weebquirks.WeebQuirks;
import net.leo.weebquirks.item.ModItems;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class SetSenkuAbilityCommand {
    public SetSenkuAbilityCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("ability").then(Commands.literal("senku").executes((command) -> {
            return setSenkuAbility(command.getSource());
        })));
    }

    private int setSenkuAbility(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        boolean hasAbility = player.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability").length != 0;
        System.out.println(hasAbility);

        if (!hasAbility){
            player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                    new int[]{ 4 });
            source.sendSuccess(new TextComponent("Ability set to Senku"), true);
            player.getInventory().add(new ItemStack(ModItems.UPGRADER.get()));
            return 1;
        } else {
            source.sendSuccess(new TextComponent("Ability could not be set!"), true);
            return -1;
        }
    }
}
