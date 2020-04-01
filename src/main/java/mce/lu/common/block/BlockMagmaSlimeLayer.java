package mce.lu.common.block;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.xendric.xenlib.common.core.block.BlockBase;

public class BlockMagmaSlimeLayer extends BlockBase {
	protected static final AxisAlignedBB LAYER_AABB = new AxisAlignedBB(0d, 0d, 0d, 1d, 0.0625d, 1d);

	public BlockMagmaSlimeLayer(String name, Material mat, List<Block> blockList, List<Item> itemList, SoundType type) {
		super(name, mat, blockList, itemList, type);
		// this.slipperiness = 1f;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity e) {
		if (e instanceof EntityLivingBase)
			e.setFire(8);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return LAYER_AABB;
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
		return LAYER_AABB;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.MAGMA_CREAM;
	}
}