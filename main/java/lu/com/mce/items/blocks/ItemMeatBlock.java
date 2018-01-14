package lu.com.mce.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemMeatBlock extends ItemBlockWithMetadata {
	String name = "";

	public ItemMeatBlock(Block block) {
		super(block, block);
		this.setUnlocalizedName(getUnlocalizedName() + "." + name);
	}

	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getItemDamage()) {
		case 0:
			name = "raw";
			break;
		case 1:
			name = "cooked";
			break;
		default:
			System.out.println("Invalid metadata for meat block!");
			name = "raw";
			break;
		}
		return getUnlocalizedName() + "." + name;
	}
}
