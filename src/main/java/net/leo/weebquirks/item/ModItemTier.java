package net.leo.weebquirks.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModItemTier {


    public static final ForgeTier TECHNIUM = new ForgeTier(4, -1, 110.0f, 0.0f, 20,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.EMPTY);

    public static final ForgeTier ONEPUNCH = new ForgeTier(1, -1, 5f, 6f, 20,
            BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.EMPTY);
}