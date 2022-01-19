package net.leo.weebquirks.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class QuirksInventoryItem extends Item {
    public QuirksInventoryItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }


}
