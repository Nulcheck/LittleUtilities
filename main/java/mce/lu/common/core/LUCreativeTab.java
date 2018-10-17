package mce.lu.common.core;

import mce.lu.common.block.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

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
	public String getTranslatedTabLabel() {
		return TextFormatting.GREEN + "LittleUtilities";
	}
}