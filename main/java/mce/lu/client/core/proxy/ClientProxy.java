package mce.lu.client.core.proxy;

import mce.lu.common.core.proxy.ServerProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends ServerProxy {
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}

	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
}
