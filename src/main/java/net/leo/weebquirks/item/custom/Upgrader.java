package net.leo.weebquirks.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Upgrader extends Item {
    public Upgrader(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack container = itemStack.copy();
        //if (container.isDamageableItem(1, random, null)) {
        //    return ItemStack.EMPTY;
        //} else {
            return container;
        //}
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}
