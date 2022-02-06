package net.leo.weebquirks.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup {

    public static final CreativeModeTab WEEBQUIRKS_GROUP = new CreativeModeTab("weebquirksgroup") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TECHNIUMINGOT.get());
        }
    };

    public static final CreativeModeTab WEEBQUIRKS_ACTIVATORS = new CreativeModeTab("weebquirks_activators") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SIMON_ACTIVATOR.get());
        }
    };
}
