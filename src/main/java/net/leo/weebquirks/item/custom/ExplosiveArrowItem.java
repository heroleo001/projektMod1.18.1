package net.leo.weebquirks.item.custom;

import net.leo.weebquirks.entity.custom.ExplosiveArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ExplosiveArrowItem extends ArrowItem {
    public ExplosiveArrowItem(Properties builder) {
        super(builder);
    }

    @Override
    public Arrow createArrow(Level worldIn, ItemStack stack, LivingEntity shooter) {
        ExplosiveArrowEntity arrowEntity = new ExplosiveArrowEntity(worldIn, shooter);
        return arrowEntity;
    }
}
