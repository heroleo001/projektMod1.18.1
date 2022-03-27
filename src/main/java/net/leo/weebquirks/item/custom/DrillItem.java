package net.leo.weebquirks.item.custom;

import net.leo.weebquirks.item.ModItemTier;
import net.leo.weebquirks.item.ModItems;
import net.leo.weebquirks.util.ModTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DrillItem extends DiggerItem {
    public DrillItem(Properties pProperties) {
        super(0f, 0f, ModItemTier.TECHNIUM, ModTags.Blocks.DRILL_MINEABLES, pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            ThrownEnderpearl thrownenderpearl = new ThrownEnderpearl(pLevel, pPlayer);
            thrownenderpearl.setItem(new ItemStack(ModItems.TECHNIUMINGOT.get()));
            thrownenderpearl.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(thrownenderpearl);
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (5*20), 20));
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}