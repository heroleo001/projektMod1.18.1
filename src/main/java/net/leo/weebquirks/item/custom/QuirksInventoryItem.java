package net.leo.weebquirks.item.custom;

import net.leo.weebquirks.screen.QuirksInventoryMenu;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;

public class QuirksInventoryItem extends Item {
    public QuirksInventoryItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {


        NetworkHooks.openGui(((ServerPlayer) pPlayer), new SimpleMenuProvider(
                (windowId, playerInventory, playerEntity) -> new QuirksInventoryMenu(windowId, playerInventory,
                        new ItemStackHandler()), new TextComponent("Quirks Inventory")));
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }
}
