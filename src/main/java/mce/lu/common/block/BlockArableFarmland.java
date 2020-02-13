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
import net.minecraftforge.common.IPlantable;
import net.xendric.xenlib.common.core.block.BlockNoWaterFarmlandBase;

public class BlockArableFarmland extends BlockNoWaterFarmlandBase {
	public BlockArableFarmland(String name, List<Block> blockList, List<Item> itemList) {
		super(name, blockList, itemList);
		this.setSoundType(SoundType.GROUND);
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		Block crop = world.getBlockState(pos.up()).getBlock();

		if (crop instanceof IPlantable || crop instanceof IGrowable)
			for (int i = 0; i < 10; i++)
				crop.updateTick(world, pos.up(), world.getBlockState(pos.up()), rand);
	}

	@Override
	public void onFallenUpon(World world, BlockPos pos, Entity entity, float fallDistance) {
		if (entity.canTrample(world, this, pos, fallDistance))
			turnIntoDirt(world, pos);
	}

	protected static void turnIntoDirt(World world, BlockPos pos) {
		world.setBlockState(pos, ModBlocks.ARABLE_DIRT.getDefaultState());
		AxisAlignedBB aabb = FARMLAND_AABB2.offset(pos);

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
		if (world.getBlockState(pos.up()).getMaterial().isSolid())
			turnIntoDirt(world, pos);
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		if (world.getBlockState(pos.up()).getMaterial().isSolid())
			turnIntoDirt(world, pos);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModBlocks.ARABLE_DIRT.getItemDropped(getDefaultState(), rand, fortune);
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
