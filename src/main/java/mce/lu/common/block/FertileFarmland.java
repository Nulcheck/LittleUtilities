package mce.lu.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.xendric.xenlib.common.core.block.BlockFarmlandBase;

public class FertileFarmland extends BlockFarmlandBase {
	public FertileFarmland(String name, List<Block> blockList, List<Item> itemList) {
		super(name, blockList, itemList);
		this.setSoundType(SoundType.GROUND);
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(world, pos, state, rand);
		Block block = world.getBlockState(pos.up()).getBlock();

		if (block instanceof IPlantable || block instanceof IGrowable) {
			for (int i = 0; i < 6; i++)
				block.updateTick(world, pos.up(), world.getBlockState(pos.up()), rand);
		}
	}

	@Override
	public void onFallenUpon(World world, BlockPos pos, Entity entity, float fallDistance) {
		if (ForgeHooks.onFarmlandTrample(world, pos, ModBlocks.FERTILE_DIRT.getDefaultState(), fallDistance, entity)) {
			turnToDirt(world, pos);
		}
	}

	protected static void turnToDirt(World world, BlockPos pos) {
		world.setBlockState(pos, ModBlocks.FERTILE_DIRT.getDefaultState());
		AxisAlignedBB aabb = field_194405_c.offset(pos);

		for (Entity entity : world.getEntitiesWithinAABBExcludingEntity((Entity) null, aabb)) {
			double d0 = Math.min(aabb.maxY - aabb.minY, aabb.maxY - entity.getEntityBoundingBox().minY);
			entity.setPositionAndUpdate(entity.posX, entity.posY + d0 + 0.001D, entity.posZ);
		}
	}

	public static boolean hasWater(World world, BlockPos pos) {
		return true;
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		if (world.getBlockState(pos.up()).getMaterial().isSolid()) {
			turnToDirt(world, pos);
		}
		super.neighborChanged(state, world, pos, block, fromPos);
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		if (world.getBlockState(pos.up()).getMaterial().isSolid()) {
			turnToDirt(world, pos);
		}
		super.onBlockAdded(world, pos, state);
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			IPlantable p) {
		EnumPlantType plantType = p.getPlantType(world, pos.offset(EnumFacing.UP));

		if (p instanceof IPlantable || p instanceof IGrowable)
			return true;

		switch (plantType) {
		case Crop:
			return true;
		case Plains:
			return true;
		default:
			break;
		}

		return false;
	}
}
