package lu.com.mce.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemFishBlock extends ItemBlockWithMetadata {
	String name = "";

	public ItemFishBlock(Block block) {
		super(block, block);
		this.setUnlocalizedName(getUnlocalizedName() + "." + name);
	}

	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getItemDamage()) {
		case 0:
			name = "fish";
			break;
		case 1:
			name = "salmon";
			break;
		case 2:
			name = "clown";
			break;
		case 3:
			name = "puff";
			break;
		case 4:
			name = "fish.cooked";
			break;
		case 5:
			name = "salmon.cooked";
			break;
		default:
			System.out.println("Invalid metadata for fish block!");
			name = "fish";
			break;
		}
		return getUnlocalizedName() + "." + name;
	}
}
