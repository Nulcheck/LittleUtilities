package lu.com.mce.util;

import lu.com.mce.common.mod_lu;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTab extends CreativeTabs {
	public final String tabName;

	public ModCreativeTab(String name) {
		super(name);
		tabName = name;
	}

	public Item getTabIconItem() {
		return Item.getItemFromBlock(mod_lu.condenser);
	}
}
