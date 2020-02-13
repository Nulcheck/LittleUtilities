package mce.lu.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.xendric.xenlib.common.core.block.BlockBase;

public class BlockPaper extends BlockBase {
	public BlockPaper(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(name, mat, blockList, itemList);
	}

	/**
	 * The higher the number, the faster fire will spread around this block. Planks
	 * is 5
	 */
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 7;
	}

	/**
	 * Chance that fire will spread and consume this block. 300 being a 100% chance,
	 * 0 being a 0% chance. Planks is 20
	 */
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 250;
	}
}
