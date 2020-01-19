package mce.lu.common.block;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.xendric.xenlib.common.core.block.BlockBase;

public class BlockJumpPad extends BlockBase {
	public static final AxisAlignedBB PAD_AABB = new AxisAlignedBB(0d, 0d, 0d, 1d, 0.5d, 1d);

	public BlockJumpPad(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(name, mat, blockList, itemList);
	}

	/**
	 * Block's chance to react to a living entity falling on it.
	 */
	@Override
	public void onFallenUpon(World world, BlockPos pos, Entity entity, float fallDistance) {
		if (entity.isSneaking())
			super.onFallenUpon(world, pos, entity, fallDistance);
		else
			entity.fall(fallDistance, 0f);
	}

	/**
	 * Called when an Entity lands on this Block. This method *must* update motionY
	 * because the entity will not do that on its own
	 */
	@Override
	public void onLanded(World world, Entity entity) {
		if (entity.isSneaking())
			super.onLanded(world, entity);
		else if (entity.motionY < 0d) {
			entity.motionY = -entity.motionY;

			if (!(entity instanceof EntityLivingBase))
				entity.motionY *= 0.8d;
		}
	}

	/**
	 * Called when the given entity walks on this Block
	 */
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		if (Math.abs(entity.motionY) < 0.2d && !entity.isSneaking())
			entity.motionY *= 0.2d;

		else if (Math.abs(entity.motionY) < 0.1d && !entity.isSneaking()) {
			double d0 = 0.4D + Math.abs(entity.motionY) * 0.2D;
			entity.motionX *= d0;
			entity.motionZ *= d0;
		}

		super.onEntityWalk(world, pos, entity);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return PAD_AABB;
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
		return PAD_AABB;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
}
