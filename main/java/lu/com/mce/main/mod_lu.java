package lu.com.mce.main;

import java.util.logging.Logger;

import lu.com.mce.events.ChatEvent;
import lu.com.mce.events.GameEvent;
import lu.com.mce.handlers.PlayerHandler;
import lu.com.mce.proxy.CommonProxy;
import lu.com.mce.util.ModCreativeTab;
import lu.com.mce.util.References;
import lu.com.mce.util.config.ConfigHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = References.MOD_ID, name = References.NAME, version = References.VERSION, updateJSON = References.UPDATE, guiFactory = References.GUI_FACTORY)
public class mod_lu {
	@Instance
	public static mod_lu instance;

	public static Logger logger = Logger.getLogger("Minecraft");

	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	public static final int condenserGUI = 0;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);

		MinecraftForge.EVENT_BUS.register(new ConfigHandler());
		MinecraftForge.EVENT_BUS.register(new ChatEvent());
		MinecraftForge.EVENT_BUS.register(new GameEvent());
		FMLCommonHandler.instance().bus().register(new GameEvent());
		FMLCommonHandler.instance().bus().register(new PlayerHandler());
	}

	public static CreativeTabs lu = new ModCreativeTab("lu");

	@EventHandler
	public void init(FMLInitializationEvent e) {
		ConfigManager.sync(References.MOD_ID, Type.INSTANCE);
	}
	
	@SubscribeEvent
	public void onConfigChangedEvent(OnConfigChangedEvent e){
		if(e.getModID().equals(References.MOD_ID))
			ConfigManager.sync(References.MOD_ID, Type.INSTANCE);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
	}
}