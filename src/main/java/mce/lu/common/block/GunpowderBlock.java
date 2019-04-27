package mce.lu.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.xendric.xenlib.common.core.block.BlockBoundsBase;

public class GunpowderBlock extends BlockBoundsBase {
	public GunpowderBlock(String name, Material mat, List<Block> blockList, List<Item> itemList, double minX,
			double minY, double minZ, double maxX, double maxY, double maxZ) {
		super(name, mat, blockList, itemList, minX, minY, minZ, maxX, maxY, maxZ);
	}

	/**
	 * The higher the number, the faster fire will spread around this block.
	 * <p>
	 * Planks is 5
	 */
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 1000;
	}

	/**
	 * Chance that fire will spread and consume this block. 300 being a 100% chance,
	 * 0 being a 0% chance.
	 * <p>
	 * Planks is 20
	 */
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 300;
	}
}
