package lu.com.mce.util;

import lu.com.mce.common.mod_lu;
import lu.com.mce.objects.items.ModItems;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(mod_lu.lu);
		
		ModItems.ITEMS.add(this);
	}
	
	public void registerModels() {
		mod_lu.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
