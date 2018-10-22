package mce.lu.common.item;

import mce.lu.client.core.handler.ModelHandler;
import mce.lu.client.render.IModelRegister;
import mce.lu.common.LittleUtilities;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBase extends Item implements IModelRegister {
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(LittleUtilities.lu);

		ModItems.ITEMS.add(this);
	}

	@SideOnly(Side.CLIENT)
	public void registerItemModels() {
		ModelHandler.registerItemModel(this, 0, "inventory");
	}
}