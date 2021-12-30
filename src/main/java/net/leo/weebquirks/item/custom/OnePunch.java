package net.leo.weebquirks.item.custom;

import net.leo.weebquirks.item.ModItemTier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class OnePunch extends SwordItem {
    public long useTime = 0;
    public OnePunch(Properties builderIn) {
        super(ModItemTier.ONEPUNCH, 5, 10f, builderIn);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (System.currentTimeMillis() - useTime >= (60*1000*3)) {
            if (pTarget.getArmorCoverPercentage() < 7.5) {
                pTarget.setHealth(0);
            } else {
                pTarget.setHealth(4);
            }
            useTime = System.currentTimeMillis();
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
