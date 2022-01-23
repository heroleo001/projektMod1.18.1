package net.leo.weebquirks.screen;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class QuirksInventoryMenu extends AbstractContainerMenu {
    private final IItemHandler itemHandler;

    public static QuirksInventoryMenu fromNetwork(final int windowId, final Inventory playerInventory, FriendlyByteBuf data){
        return new QuirksInventoryMenu(windowId, playerInventory, new ItemStackHandler(10));
    }

    public QuirksInventoryMenu(final int windowId, Inventory playerInventory, IItemHandler itemHandler) {
        super(ModMenuTypes.QUIRKS_INVENTORY_MENU.get(), windowId);
        checkContainerSize(playerInventory, 10);
        this.itemHandler = itemHandler;

        addPlayerHotbar(playerInventory);
        addPlayerInventory(playerInventory);

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new SlotItemHandler(itemHandler, i, 8 + i * 18, 50));
        }
        this.addSlot(new SlotItemHandler(itemHandler, 10, 79, 9));
    }



    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
