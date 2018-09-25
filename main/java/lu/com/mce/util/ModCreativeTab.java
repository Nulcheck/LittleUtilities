package lu.com.mce.util;

import lu.com.mce.objects.InitBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModCreativeTab extends CreativeTabs {
	public ModCreativeTab(String name) {
		super(name);
		this.setBackgroundImageName("lu.png");
	}

	public ItemStack getTabIconItem() {
		return new ItemStack(InitBlocks.CONDENSER);
	}
}