package lu.com.mce.proxy;

import java.io.File;

import lu.com.mce.util.config.ConfigHandler;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public static Configuration config;

	public void preInit(FMLPreInitializationEvent e) {
		File dir = e.getModConfigurationDirectory();
		config = new Configuration(new File(dir.getPath(), "LittleUtilities.cfg"));
		ConfigHandler.readConfig();
	}

	public void registerItemRenderer(Item item, int meta, String id) {
	}

	public void postInit(FMLPostInitializationEvent e) {
		if(config.hasChanged()){
			config.save();
		}
	}
}
