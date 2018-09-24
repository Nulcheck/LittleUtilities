package lu.com.mce.util;

import lu.com.mce.common.mod_lu;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModCreativeTab extends CreativeTabs {
	public final String gui_tab = "tab.png";
	
	public ModCreativeTab(String name){
		super(name);
		this.setBackgroundImageName(gui_tab);
	}
	
	public ItemStack getTabIconItem() {
		return new ItemStack(mod_lu.sponge);
	}

}
