package mce.lu.common;

import java.util.logging.Logger;

import mce.lu.client.core.handler.GuiHandler;
import mce.lu.client.core.handler.RecipeHandler;
import mce.lu.common.block.ModBlocks;
import mce.lu.common.core.handler.ModEntityRegistry;
import mce.lu.common.core.handler.TileEntityRegistry;
import mce.lu.common.core.proxy.CommonProxy;
import mce.lu.common.item.ModItems;
import mce.lu.common.util.OreDict;
import mce.lu.common.util.References;
import mce.lu.common.world.gen.feature.WorldGenLavaLily;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.xendric.xenlib.common.util.CreativeTabsHelper;
import net.xendric.xenlib.common.util.Util;

@Mod(modid = References.MOD_ID, name = References.NAME, version = References.VERSION, dependencies = References.DEP, updateJSON = References.UPDATE)
public class LittleUtilities {
	@Instance(References.MOD_ID)
	public static LittleUtilities instance;

	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static Logger logger = Logger.getLogger("Minecraft");
	public static CreativeTabs lu = new CreativeTabsHelper("littleutilities", false) {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModBlocks.CONDENSER);
		}
	};
	static {
		FluidRegistry.enableUniversalBucket();
	}

	@EventHandler
	public static void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
		Util.setDependants(References.MOD_ID);

		ForgeRegistries.BLOCKS.registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		ForgeRegistries.ITEMS.registerAll(ModItems.ITEMS.toArray(new Item[0]));

		ModEntityRegistry.registerEntities();
		TileEntityRegistry.registerTileEntities();
		GameRegistry.registerWorldGenerator(new WorldGenLavaLily(), 0);
		OreDict.registerOreDict();
		NetworkRegistry.INSTANCE.registerGuiHandler(LittleUtilities.instance, new GuiHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		ConfigManager.sync(References.MOD_ID, Type.INSTANCE);
		RecipeHandler.registerSmelting();
		RecipeHandler.registerMetaCrafting();
		RecipeHandler.registerMetaSmelting();
		FMLInterModComms.sendMessage(References.WAILA, "register", "mce.lu.api.waila.WailaDataProvider.register");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
	}
}