package mce.lu.common;

import java.util.logging.Logger;

import mce.lu.client.core.handler.RecipeHandler;
import mce.lu.common.core.LUCreativeTab;
import mce.lu.common.core.proxy.ServerProxy;
import mce.lu.common.util.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MOD_ID, name = References.NAME, version = References.VERSION, updateJSON = References.UPDATE)
public class LittleUtilities {
	@Instance
	public static LittleUtilities instance;

	public static Logger logger = Logger.getLogger("Minecraft");

	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.COMMON_PROXY_CLASS)
	public static ServerProxy proxy;

	public static final int condenserGUI = 0;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	public static CreativeTabs lu = new LUCreativeTab("lu");

	@EventHandler
	public void init(FMLInitializationEvent e) {
		ConfigManager.sync(References.MOD_ID, Type.INSTANCE);
		RecipeHandler.registerSmeltingRecipe();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
	}
}