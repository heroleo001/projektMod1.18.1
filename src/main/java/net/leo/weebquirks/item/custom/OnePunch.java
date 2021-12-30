package net.leo.weebquirks.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;

public class OnePunch extends SwordItem {
    public long useTime = 0;
    public OnePunch(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
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
