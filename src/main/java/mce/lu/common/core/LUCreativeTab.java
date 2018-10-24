package mce.lu.common.core;

import mce.lu.common.block.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class LUCreativeTab extends CreativeTabs {
	public LUCreativeTab(String name) {
		super(name);
		this.setBackgroundImageName("lu.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.CONDENSER);
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}

	@Override
	public int getSearchbarWidth() {
		return 71;
	}

	@Override
	public int getLabelColor() {
		return 5635925;
	}
}