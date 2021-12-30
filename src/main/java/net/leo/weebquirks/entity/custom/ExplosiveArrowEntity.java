package net.leo.weebquirks.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class ExplosiveArrowEntity extends Arrow {
    private boolean exploded = false;

    public ExplosiveArrowEntity(Level world, LivingEntity shooter) {
        super(world, shooter);
    }


    @Override
    protected void onHit(HitResult pResult) {
        Level world = this.level;
        BlockPos pos = this.blockPosition();
        // BlockState enlitedTNT = Blocks.TNT.defaultBlockState();
        // world.setBlockAndUpdate(pos, enlitedTNT);
        world.explode(null, pos.getX(),
                pos.getY(), pos.getZ(), 8f, Explosion.BlockInteraction.DESTROY);
        super.onHit(pResult);
    }
}
