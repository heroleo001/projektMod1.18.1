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

public class SetSimonAbilityCommand {
    public SetSimonAbilityCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("ability").requires((hh) -> hh.hasPermission(2))
                .then(Commands.literal("simon").executes((command) -> {
            return setSimonAbility(command.getSource());
        })));
    }
    private int setSimonAbility(CommandSourceStack source) throws CommandSyntaxException{
        ServerPlayer player = source.getPlayerOrException();
        boolean hasAbility = player.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability").length != 0;

        if (!hasAbility){
            player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                    new int[]{ 1 });
                    //LIST  Abilities:  Simon=1,  Eren=2, Sinra=3
            source.sendSuccess(new TextComponent("Ability set to Simon"), true);
            WeebQuirks.createLog("Ability set");
            ItemStack drill = new ItemStack(ModItems.TECHNIUM_DRILL.get());
            player.getInventory().add(drill);

            return 1;
        } else {
            source.sendSuccess(new TextComponent("This player already has an Ability!"), true);
            WeebQuirks.createLog("Unable to set Ability. Player already has an ability.");

            return -1;
        }
    }
}
