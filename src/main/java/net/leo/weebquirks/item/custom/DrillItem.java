package net.leo.weebquirks.item.custom;

import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;

public class DrillItem extends DiggerItem {
    public DrillItem(float pAttackDamageModifier, float pAttackSpeedModifier, Tier pTier, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, pBlocks, pProperties);
    }
}