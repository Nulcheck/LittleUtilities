package mce.lu.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.xendric.xenlib.common.core.block.BlockBase;

public class BlockWorldTicker extends BlockBase {
	public BlockWorldTicker(String name, Material mat, List<Block> blockList, List<Item> itemList) {
		super(name, mat, blockList, itemList);
	}
}
