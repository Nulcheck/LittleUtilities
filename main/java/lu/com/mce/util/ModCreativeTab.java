package lu.com.mce.util;

import lu.com.mce.objects.InitBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class ModCreativeTab extends CreativeTabs {
	public ModCreativeTab(String name) {
		super(name);
		this.setBackgroundImageName("lu.png");
	}

	public ItemStack getTabIconItem() {
		return new ItemStack(InitBlocks.CONDENSER);
	}

	public String getTabLabel() {
		return super.getTabLabel();
	}

	public String getTranslatedTabLabel() {
		return TextFormatting.GREEN + "LittleUtilities";
	}
}