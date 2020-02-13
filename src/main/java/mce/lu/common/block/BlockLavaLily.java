package mce.lu.common.block;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockLavaLily extends BlockBushBase {
	protected static final AxisAlignedBB LILY_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.09375D,
			0.9375D);

	public BlockLavaLily(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(name, mat, blockList, itemList);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.getPlantType("Lava");
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
		addCollisionBoxToList(pos, entityBox, collidingBoxes, LILY_AABB);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return LILY_AABB;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		IBlockState soil = worldIn.getBlockState(pos.down());
		return soil.getBlock() == Blocks.LAVA || soil.getMaterial() == Material.LAVA
				&& soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
	}

	@Override
	protected boolean canSustainBush(IBlockState state) {
		return state.getBlock() == Blocks.LAVA || state.getMaterial() == Material.LAVA;
	}

	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
		if (pos.getY() >= 0 && pos.getY() < 256) {
			IBlockState iState = worldIn.getBlockState(pos.down());
			Material material = iState.getMaterial();
			return material == Material.LAVA && ((Integer) iState.getValue(BlockLiquid.LEVEL)).intValue() == 0;
		} else {
			return false;
		}
	}

	public int getMetaFromState(IBlockState state) {
		return 0;
	}
}
