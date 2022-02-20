package net.leo.weebquirks.item.custom.activators;

import net.leo.weebquirks.WeebQuirks;
import net.leo.weebquirks.util.AbilitySetters;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class KororsenseiActivator extends Item implements ICurioItem {
    public KororsenseiActivator(Properties properties) {
        super(properties);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        System.out.println("equipped");
        Player player = ((Player) slotContext.entity());
        if (player.getPersistentData().getIntArray(WeebQuirks.MOD_ID+ "ability").length != 0) {
            if (!(player.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability")[0] == 5)) {
                AbilitySetters.setKorosenseiAbility(player);
            }
        } else {
            AbilitySetters.setKorosenseiAbility(player);
        }

        ICurioItem.super.onEquip(slotContext, prevStack, stack);
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        Player player = ((Player) slotContext.entity());
        AbilitySetters.eraseAbility(player);
        ICurioItem.super.onUnequip(slotContext, newStack, stack);
    }
}
