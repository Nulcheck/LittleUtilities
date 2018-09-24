package lu.com.mce.objects.items.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockEdible extends ItemBlockWithMetadata {
	public ItemBlockEdible(Block block) {
		super(block, block);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		Random rand = new Random();
		int i = rand.nextInt(150);
		list.add("Edible!");

		switch (stack.getItemDamage()) {
		case 0:
			list.add("9 Bites Left");
			break;
		case 1:
			list.add("8 Bites Left");
			break;
		case 2:
			list.add("7 Bites Left");
			break;
		case 3:
			list.add("6 Bites Left");
			break;
		case 4:
			list.add("5 Bites Left");
			break;
		case 5:
			list.add("4 Bites Left");
			break;
		case 6:
			list.add("3 Bites Left");
			break;
		case 7:
			list.add("2 Bites Left");
			break;
		case 8:
			if (i == 23) {
				list.add("1 Byte Left");
				break;
			} else {
				list.add("1 Bite Left");
				break;
			}
		}
	}
}