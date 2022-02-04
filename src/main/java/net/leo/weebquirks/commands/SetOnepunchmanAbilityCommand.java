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

public class SetOnepunchmanAbilityCommand {
    public SetOnepunchmanAbilityCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("ability").requires((hh) -> hh.hasPermission(2))
                .then(Commands.literal("one_punch_man").executes((command) -> {
            return setOnepunchmanAbility(command.getSource());
        })));
    }

    private int setOnepunchmanAbility(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        boolean hasAbility = player.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability").length != 0;
        System.out.println(hasAbility + " player ability");

        if (!hasAbility) {
            player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                    new int[]{ 6 });
            WeebQuirks.setOnepunchmanPlayerEntity(player);
            source.sendSuccess(new TextComponent("ability set to Onepunchman"), true);
            player.getInventory().add(new ItemStack(ModItems.ONE_PUNCH_SWORD.get()));

            return 1;
        } else {
            source.sendSuccess(new TextComponent("player already has an ability"), true);
            return -1;
        }
    }
}
