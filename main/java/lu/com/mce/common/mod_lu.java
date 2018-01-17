package lu.com.mce.common;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import lu.com.mce.blocks.Condenser;
import lu.com.mce.blocks.EdibleBlock;
import lu.com.mce.blocks.ModBlocks;
import lu.com.mce.blocks.ModBlocks.BlazeRodBlock;
import lu.com.mce.blocks.ModBlocks.GhastTearBlock;
import lu.com.mce.events.ChatEvent;
import lu.com.mce.events.GameEvent;
import lu.com.mce.handlers.AchievementHandler;
import lu.com.mce.handlers.GuiHandler;
import lu.com.mce.handlers.PlayerHandler;
import lu.com.mce.handlers.recipes.BlockRecipeHandler;
import lu.com.mce.handlers.recipes.ItemRecipeHandler;
import lu.com.mce.handlers.registers.AchRegistry;
import lu.com.mce.handlers.registers.BlockRegistry;
import lu.com.mce.handlers.registers.TileEntityRegistry;
import lu.com.mce.util.ModCreativeTab;
import lu.com.mce.util.updater.CheckVersion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = mod_lu.modid, name = mod_lu.name, version = mod_lu.version)
public class mod_lu {
	@Mod.Instance("mod_lu")
	public static mod_lu instance;

	public static final int renderId = RenderingRegistry.getNextAvailableRenderId();

	public static final String modid = "mod_lu";
	public static final String version = "1.4";
	public static final String name = "LittleUtilities";

	public static Block condenser;

	//// Condensed Blocks
	public static Block ghastTearBlock;
	public static Block blazeRodBlock;
	public static Block porkBlock;
	public static Block cookedPorkBlock;
	public static Block beefBlock;
	public static Block cookedBeefBlock;
	public static Block chickenBlock;
	public static Block cookedChickenBlock;
	public static Block fishBlock;
	public static Block cookedFishBlock;
	public static Block salmonBlock;
	public static Block cookedSalmonBlock;
	public static Block clownfishBlock;
	public static Block pufferfishBlock;
	public static Block rottenFleshBlock;
	public static Block appleBlock;
	public static Block breadBlock;
	public static Block cookieBlock;
	public static Block spiderEyeBlock;
	public static Block fSpiderEyeBlock;
	public static Block carrotBlock;
	public static Block potatoBlock;
	public static Block gunpowderBlock;
	public static Block flintBlock;
	public static Block netherStarBlock;
	public static Block paperBlock;
	public static Block slimeBlock;
	public static Block enderPerlBlock;
	public static Block enderEyeBlock;
	public static Block boneBlock;
	public static Block magmaCreamBlock;
	public static Block stickBlock;
	public static Block dyeBlock; // Maybe

	// Compact Blocks
	public static Block comCobble;
	public static Block comDirt;
	public static Block comNetherrack;

	public static final int condenserGUI = 0;

	@SidedProxy(clientSide = "lu.com.mce.client.ClientProxy", serverSide = "lu.com.mce.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		new CheckVersion();
		condenser = new Condenser(Material.ground).setBlockName("condenser").setBlockTextureName("mod_lu:condenser")
				.setCreativeTab(lu).setStepSound(Block.soundTypeStone);

		//// Condensed Blocks
		ghastTearBlock = new GhastTearBlock(Material.glass).setBlockName("ghastTearBlock")
				.setBlockTextureName("mod_lu:block_ghastTear").setCreativeTab(lu).setStepSound(Block.soundTypeGlass)
				.setLightLevel(0.4f);

		blazeRodBlock = new BlazeRodBlock(Material.ground).setBlockName("blazeRodBlock")
				.setBlockTextureName("mod_lu:block_blazeRod").setCreativeTab(lu).setStepSound(Block.soundTypeStone)
				.setLightLevel(1f);

		porkBlock = new EdibleBlock(Material.ground, 3, 0.3f).setBlockName("pork").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		cookedPorkBlock = new EdibleBlock(Material.ground, 8, 0.8f).setBlockName("cookedPork").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		beefBlock = new EdibleBlock(Material.ground, 3, 0.3f).setBlockName("beef").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		cookedBeefBlock = new EdibleBlock(Material.ground, 8, 0.8f).setBlockName("cookedBeef").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		chickenBlock = ((EdibleBlock) new EdibleBlock(Material.ground, 2, 0.3f).setBlockName("chicken")
				.setCreativeTab(lu).setStepSound(Block.soundTypeGravel)).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F);

		cookedChickenBlock = new EdibleBlock(Material.ground, 6, 0.6f).setBlockName("cookedChicken").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		fishBlock = new EdibleBlock(Material.ground, 2, 0.4f).setBlockName("fish").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		cookedFishBlock = new EdibleBlock(Material.ground, 5, 0.6f).setBlockName("cookedFish").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		salmonBlock = new EdibleBlock(Material.ground, 2, 0.2f).setBlockName("salmon").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		cookedSalmonBlock = new EdibleBlock(Material.ground, 6, 0.6f).setBlockName("cookedSalmon").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		clownfishBlock = new EdibleBlock(Material.ground, 1, 0.2f).setBlockName("clownfish").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		pufferfishBlock = ((EdibleBlock) new EdibleBlock(Material.ground, 1, 0.2f).setBlockName("puff")
				.setCreativeTab(lu).setStepSound(Block.soundTypeGravel)).setPotionEffect(Potion.poison.id, 1200, 3, 1f)
						.setPotionEffect(Potion.hunger.id, 300, 2, 1f).setPotionEffect(Potion.confusion.id, 300, 1, 1f);

		rottenFleshBlock = new EdibleBlock(Material.ground, 4, 0.1f).setBlockName("rottenFleshBlock").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		appleBlock = new EdibleBlock(Material.ground, 4, 0.3f).setBlockName("appleBlock").setCreativeTab(lu)
				.setStepSound(Block.soundTypeWood);

		breadBlock = new EdibleBlock(Material.ground, 5, 0.6f).setBlockName("breadBlock").setCreativeTab(lu)
				.setStepSound(Block.soundTypeCloth);

		cookieBlock = new EdibleBlock(Material.ground, 2, 0.1f).setBlockName("cookieBlock").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		spiderEyeBlock = new EdibleBlock(Material.ground, 2, 0.8f).setBlockName("spiderEyeBlock").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		fSpiderEyeBlock = new ModBlocks(Material.ground).setBlockName("fSpiderEyeBlock").setCreativeTab(lu)
				.setStepSound(Block.soundTypeGravel);

		carrotBlock = new EdibleBlock(Material.gourd, 4, 0.6f).setBlockName("carrotBlock").setCreativeTab(lu)
				.setStepSound(Block.soundTypeWood);

		potatoBlock = new EdibleBlock(Material.gourd, 1, 0.3f).setBlockName("potatoBlock").setCreativeTab(lu)
				.setStepSound(Block.soundTypeWood);

		MinecraftForge.EVENT_BUS.register(new ChatEvent());
		MinecraftForge.EVENT_BUS.register(new GameEvent());
		FMLCommonHandler.instance().bus().register(new GameEvent());
		FMLCommonHandler.instance().bus().register(new PlayerHandler());
		FMLCommonHandler.instance().bus().register(new AchievementHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(mod_lu.instance, new GuiHandler());
	}

	public static CreativeTabs lu = new ModCreativeTab("LU");

	@EventHandler
	public void load(FMLInitializationEvent event) {
		BlockRegistry.registerBlocks();

		BlockRecipeHandler.registerCrafting();
		ItemRecipeHandler.registerCrafting();

		TileEntityRegistry.teRegistry();

		AchRegistry.registerAch();
		AchRegistry.namingAch();
		proxy.registerRenders();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}