package net.leo.weebquirks.item.custom;

import net.leo.weebquirks.item.ModItemTier;
import net.leo.weebquirks.util.ModTags;
import net.minecraft.world.item.DiggerItem;

public class DrillItem extends DiggerItem {
    public DrillItem(Properties pProperties) {
        super(0f, 0f, ModItemTier.TECHNIUM, ModTags.Blocks.DRILL_MINEABLES, pProperties);
    }
}