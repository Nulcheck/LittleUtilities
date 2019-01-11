package mce.lu.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class GunpowderBlock extends BoundsBlock {
	public GunpowderBlock(String name, Material mat, double maxY) {
		super(name, mat, maxY);
	}

	// The higher the number, the faster fire will spread around this block.
	// Planks is 5
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 1000;
	}

	/*
	 * Chance that fire will spread and consume this block. 300 being a 100%
	 * chance, 0 being a 0% chance.
	 */
	// Planks is 20
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 300;
	}
}
