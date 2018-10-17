package mce.lu.client.core.proxy;

import mce.lu.common.core.proxy.ServerProxy;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends ServerProxy {
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}

	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
	
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
}
