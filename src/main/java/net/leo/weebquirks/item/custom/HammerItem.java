package net.leo.weebquirks.item.custom;

import net.leo.weebquirks.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class HammerItem extends DiggerItem {
    public HammerItem(Item.Properties builder) {
        super(0f, 0f, Tiers.IRON, ModTags.Blocks.HAMMER_MINEABLES, builder);
    }

    @Override
    public void onDestroyed(ItemEntity pItemEntity) {
        if (!pItemEntity.level.isClientSide) {
            Level worldIn = pItemEntity.level;
            BlockPos pos = pItemEntity.getOnPos();
            worldIn.destroyBlock(pos.below(), true);
            worldIn.destroyBlock(pos.above(), true);
            worldIn.destroyBlock(pos.north(), true);
            worldIn.destroyBlock(pos.south(), true);
            worldIn.destroyBlock(pos.west(), true);
            worldIn.destroyBlock(pos.east(), true);
            worldIn.destroyBlock(pos.east().above(), true);
            worldIn.destroyBlock(pos.east().below(), true);
            worldIn.destroyBlock(pos.west().above(), true);
            worldIn.destroyBlock(pos.west().below(), true);
            worldIn.destroyBlock(pos.north().above(), true);
            worldIn.destroyBlock(pos.north().below(), true);
            worldIn.destroyBlock(pos.south().above(), true);
            worldIn.destroyBlock(pos.south().below(), true);
        }
    }
}
