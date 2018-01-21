package lu.com.mce.items.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemBlockEdible extends ItemBlockMeta {
	public ItemBlockEdible(Block block) {
		super(block);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		list.add("Edible!");
	}
}
