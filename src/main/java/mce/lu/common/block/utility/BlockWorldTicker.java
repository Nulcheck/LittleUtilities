package mce.lu.common.block.utility;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.xendric.xenlib.common.core.block.BlockBase;

public class BlockWorldTicker extends BlockBase {
	public static boolean isOn;
	GameRules rules;

	public BlockWorldTicker(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(name, mat, blockList, itemList);
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		if (!world.isRemote) {
			if (world.isBlockPowered(pos) || world.isBlockIndirectlyGettingPowered(pos) >= 1)
				isOn = setIsOn(true);
			else
				isOn = setIsOn(false);
		}
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		if (!world.isRemote) {
			if (world.isBlockPowered(pos) || world.isBlockIndirectlyGettingPowered(pos) >= 1)
				isOn = setIsOn(true);
			else
				isOn = setIsOn(false);
		}
	}

	public static boolean getIsOn() {
		return isOn;
	}

	public static boolean setIsOn(boolean isBlockPowered) {
		return isOn = isBlockPowered;
	}
}
