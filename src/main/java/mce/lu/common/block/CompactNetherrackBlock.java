package mce.lu.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.xendric.xenlib.common.core.block.BlockBase;

public class CompactNetherrackBlock extends BlockBase {
	public CompactNetherrackBlock(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(name, mat, blockList, itemList);
	}

	@Override
	public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
		if (side == EnumFacing.UP)
			return true;
		else
			return false;
	}
}
