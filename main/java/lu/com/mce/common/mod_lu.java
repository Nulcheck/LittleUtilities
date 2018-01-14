package lu.com.mce.common;

import lu.com.mce.events.HitEvent;
import lu.com.mce.handlers.recipes.BlockRecipeHandler;
import lu.com.mce.handlers.recipes.ItemRecipeHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = mod_lu.modid, name = mod_lu.name, version = mod_lu.version)
public class mod_lu {
	@Mod.Instance("mod_lu")
	public static mod_lu instance;

	public static final String modid = "mod_lu";
	public static final String version = "1.2-1102";
	public static final String name = "LittleUtilities";

	@SidedProxy(clientSide = "lu.com.mce.client.ClientProxy", serverSide = "lu.com.mce.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new HitEvent());
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		BlockRecipeHandler.registerCrafting();
		ItemRecipeHandler.registerCrafting();
		proxy.registerRenders();
	}
}