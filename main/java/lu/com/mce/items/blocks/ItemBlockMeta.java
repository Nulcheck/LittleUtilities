package lu.com.mce.items.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBlockMeta extends ItemBlockWithMetadata {
	public ItemBlockMeta(Block block) {
		super(block, block);
		this.setHasSubtypes(true);
	}

	public IIcon getIconFromDamage(int meta) {
		return Block.getBlockFromItem(this).getIcon(2, meta);
	}

	public int getMetadata(int meta) {
		return meta;
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		switch(stack.getItemDamage()){
		case 0:
			list.add("9 Uses Left");
			break;
		case 1:
			list.add("8 Uses Left");
			break;
		case 2:
			list.add("7 Uses Left");
			break;
		case 3:
			list.add("6 Uses Left");
			break;
		case 4:
			list.add("5 Uses Left");
			break;
		case 5:
			list.add("4 Uses Left");
			break;
		case 6:
			list.add("3 Uses Left");
			break;
		case 7:
			list.add("2 Uses Left");
			break;
		case 8:
			list.add("1 Use Left");
			break;
		}
	}
}