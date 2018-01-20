package lu.com.mce.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;

public class ItemBlockMeta extends ItemBlockWithMetadata {
	public ItemBlockMeta(Block block) {
		super(block, block);
	}
}
