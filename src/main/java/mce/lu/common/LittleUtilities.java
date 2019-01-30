package mce.lu.common;

import java.util.logging.Logger;

import mce.lu.client.core.handler.GuiHandler;
import mce.lu.client.core.handler.RecipeHandler;
import mce.lu.common.core.LUCreativeTab;
import mce.lu.common.core.handler.TileEntityRegistry;
import mce.lu.common.core.proxy.CommonProxy;
import mce.lu.common.util.OreDict;
import mce.lu.common.util.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = References.MOD_ID, name = References.NAME, version = References.VERSION, updateJSON = References.UPDATE)
public class LittleUtilities {
	@Instance(References.MOD_ID)
	public static LittleUtilities instance;

	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static Logger logger = Logger.getLogger("Minecraft");
	public static CreativeTabs lu = new LUCreativeTab("littleutilities");

	@EventHandler
	public static void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);

		TileEntityRegistry.registerTileEntities();
		NetworkRegistry.INSTANCE.registerGuiHandler(LittleUtilities.instance, new GuiHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		ConfigManager.sync(References.MOD_ID, Type.INSTANCE);
		RecipeHandler.registerSmelting();
		RecipeHandler.registerMetaCrafting();
		RecipeHandler.registerMetaSmelting();
		OreDict.registerOreDict();
		
		FMLInterModComms.sendMessage(References.WAILA, "register", "mce.lu.api.waila.WailaDataProvider.register");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
	}
}