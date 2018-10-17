package mce.lu.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FeatherBlock extends BlockBase {
	public FeatherBlock(String name, Material mat) {
		super(name, mat);
	}

	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		entityIn.fall(fallDistance, 0.0F);
	}

	public void onLanded(World worldIn, Entity entityIn) {
		if (entityIn.motionY < 0d) {
			entityIn.motionY = 0d;
		}
	}
}
